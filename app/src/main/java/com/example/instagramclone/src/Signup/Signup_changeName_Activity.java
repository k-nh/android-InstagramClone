package com.example.instagramclone.src.Signup;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.instagramclone.R;
import com.example.instagramclone.src.BaseActivity;
import com.example.instagramclone.src.Login.SignInActivity;
import com.example.instagramclone.src.Signup.interfaces.MainActivityView;
import com.example.instagramclone.src.Signup.models.SignUpResponse;

import static com.example.instagramclone.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.example.instagramclone.src.ApplicationClass.sSharedPreferences;

public class Signup_changeName_Activity extends BaseActivity implements MainActivityView {
    Button btn_next;
    EditText et_id;
    private SignUpService signUpService;
    TextView tv_login;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changename);
        signUpService = new SignUpService(this);

        btn_next = findViewById(R.id.btn_next);
        et_id = findViewById(R.id.et_id);
        tv_login=findViewById(R.id.tv_login);

        tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SignInActivity.class);
                startActivity(intent);
            }
        });

        btn_next.setEnabled(false);
        et_id.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable edit) {
                if (edit.toString().length() > 1) {
                    // 버튼 상태 활성화.
                    btn_next.setVisibility(View.VISIBLE);
                    btn_next.setEnabled(true) ;
                    btn_next.setOnClickListener(new View.OnClickListener(){
                        SharedPreferences sharedPreferences = getSharedPreferences("test", MODE_PRIVATE);

                        @Override
                        public void onClick(View v) {
                            sSharedPreferences.edit().putString("Id", et_id.getText().toString()).apply();

                            String PhoneNum = sSharedPreferences.getString("PhoneNum","");
                            String Email = sSharedPreferences.getString("Email","");
                            String PassWord = sSharedPreferences.getString("Password","");
                            String Name =   sSharedPreferences.getString("Name","");
                            String Id = sSharedPreferences.getString("Id","");
                            //회원가입, 서버에 정보 보냄
                            Log.d("test","서버에 회원가입 정보 보냄");
                            signUpService.PostSignUp(PhoneNum,Email,PassWord,Name,Id);
                        }
                    });
                } else {
                    // 버튼 상태 비활성화.
                    btn_next.setVisibility(View.INVISIBLE);
                    btn_next.setEnabled(false) ;
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

    @Override
    public void validateSuccess(SignUpResponse signUpResponse) {

        if (signUpResponse.isSuccess()) {
            showCustomToast("가입성공");

            //jwt 토큰 보냄
            String jwtResponse= signUpResponse.getSignUpResult().getJwt();
            sSharedPreferences.edit().putString(X_ACCESS_TOKEN, jwtResponse).apply();
            //userIdx 저장
            int userIdx = signUpResponse.getSignUpResult().getUserIdx();
            sSharedPreferences.edit().putInt("userIdx",userIdx).apply();


//            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
//            startActivity(intent);

        } else {
            switch (signUpResponse.getCode()) {
                case 300 :
                    showCustomToast("id를 입력해주세요");
                    break;

                case 301 :
                    showCustomToast("name을 입력해주세요");
                    break;

                case 302 :
                    showCustomToast("password를 입력해주세요");
                    break;
                case 303 :
                    showCustomToast("email과 phoneNum 중 하나는 입력해주세요");
                    break;
                case 304 :
                    showCustomToast("이메일은 30자리 미만으로 입력해주세요");
                    break;
                case 305 :
                    showCustomToast("올바르지 않은 email 형식입니다");
                    break;
                case 306 :
                    showCustomToast("비밀번호는 6~20자리의 영문 숫자조합이어야 합니다.");
                    break;
                case 307 :
                    showCustomToast("phoneNum 형식이 맞지 않습니다 (ex: 01012341234)");
                    break;
                case 401 :
                    showCustomToast("중복된 id입니다");
                    break;

                default :
                    break;
            }
        }


    }

    @Override
    public void validateFailure(String message) {

    }

}