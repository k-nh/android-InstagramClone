package com.example.instagramclone.src.Login;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.instagramclone.R;
import com.example.instagramclone.src.BaseActivity;
import com.example.instagramclone.src.Login.interfaces.SignInActivityView;
import com.example.instagramclone.src.Login.models.SignInResponse;
import com.example.instagramclone.src.Main.MainActivity;
import com.example.instagramclone.src.Signup.Signup_ID_Activity;

import static com.example.instagramclone.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.example.instagramclone.src.ApplicationClass.sSharedPreferences;


public class SignInActivity extends BaseActivity implements SignInActivityView{
    private TextView tv_signUp;
    private TextView tv_facebookLogin;
    private EditText et_userID;
    private EditText et_userPW;
    private SignInService signInService;
    private Button btn_login;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        signInService = new SignInService(this);
        tv_signUp = findViewById(R.id.tv_signup);
        btn_login = findViewById(R.id.btn_login);
        et_userID = findViewById(R.id.et_userID);
        et_userPW = findViewById(R.id.et_userPW);

        btn_login.setEnabled(false);
        et_userPW.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable edit) {
                if (edit.toString().length() > 5) {
                    // 버튼 상태 활성화.
                    btn_login.setVisibility(View.VISIBLE);
                    btn_login.setEnabled(true) ;
                } else {
                    // 버튼 상태 비활성화.
                    btn_login.setVisibility(View.INVISIBLE);
                    btn_login.setEnabled(false) ;
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        }) ;
    }





    private void tryPostSignIn(){

        String userID = et_userID.getText().toString();
        String userPW = et_userPW.getText().toString();

        signInService.PostSignIn(userID,userPW);
    }



    public void customOnClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                Log.d("test","서버에 로그인 정보 보냄");
                tryPostSignIn();
                break;
            case R.id.tv_signup:
                Intent intent = new Intent(getApplicationContext(), Signup_ID_Activity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }


    @Override
    public void validateSuccess(SignInResponse signInResponse) {

        if (signInResponse.isSuccess()) {
            showCustomToast("로그인성공");

            String jwtResponse = signInResponse.getSignInResult().getJwt();

            //jwt 토큰 보냄
            sSharedPreferences.edit().putString(X_ACCESS_TOKEN, jwtResponse).apply();

            //userIdx 저장
            int userIdx = signInResponse.getSignInResult().getUserIdx();
            sSharedPreferences.edit().putInt("userIdx",userIdx).apply();

            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);


        } else {
            switch (signInResponse.getCode()) {
                case 302:
                    showCustomToast("올바른 번호를 입력해주세요");
                    break;
                case 304:
                    showCustomToast("password를 입력해주세요");
                    break;
                case 310:
                    showCustomToast("없는 id거나 password가 틀렸습니다");
                    break;
                case 312:
                    showCustomToast("탈퇴된 계정입니다. 고객센터에 문의해주세요");
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void validateFailure(String message) {

    }



}
