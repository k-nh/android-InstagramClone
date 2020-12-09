package com.example.instagramclone.src.Signup;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.instagramclone.R;
import com.example.instagramclone.src.BaseActivity;
import com.example.instagramclone.src.Login.SignInActivity;

import static com.example.instagramclone.src.ApplicationClass.sSharedPreferences;

public class Signup_PW_Activity extends BaseActivity {
    Button btn_next;
    EditText et_passwd;
    TextView tv_login;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_pw);
        btn_next = findViewById(R.id.btn_next);
        et_passwd = findViewById(R.id.et_passwd);
        tv_login=findViewById(R.id.tv_login);

        tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SignInActivity.class);
                startActivity(intent);
            }
        });

        btn_next.setEnabled(false);
        et_passwd.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable edit) {
                if (edit.toString().length() > 5) {
                    // 버튼 상태 활성화.
                    btn_next.setVisibility(View.VISIBLE);
                    btn_next.setEnabled(true) ;
                    btn_next.setOnClickListener(new View.OnClickListener(){
                        SharedPreferences sharedPreferences= getSharedPreferences("test", MODE_PRIVATE);

                        @Override
                        public void onClick(View v) {
                            sSharedPreferences.edit().putString("Password", et_passwd.getText().toString()).apply();
                            Intent intent = new Intent(getApplicationContext(), Signup_addName_Activity.class);
                            startActivity(intent);
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
}
