package com.example.instagramclone.src.Signup;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.instagramclone.R;
import com.example.instagramclone.src.BaseActivity;
import com.example.instagramclone.src.Login.SignInActivity;

import static com.example.instagramclone.src.ApplicationClass.sSharedPreferences;

public class Signup_ID_Activity extends BaseActivity {
    LinearLayout ly_select_phone;
    LinearLayout ly_select_email;
    TextView tv_select_phone;
    TextView tv_select_email;
    View v_select_phone;
    View v_select_email;
    Button btn_next;
    TextView tv_phone_notice;

    EditText et_phone;
    EditText et_email;
    EditText et_id;
    EditText et_name;
    TextView tv_login;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        ly_select_phone = findViewById(R.id.ly_phone);
        ly_select_email = findViewById(R.id.ly_email);
        tv_select_phone = findViewById(R.id.tv_phone);
        tv_select_email = findViewById(R.id.tv_email);
        v_select_phone = findViewById(R.id.phone_underBar);
        v_select_email = findViewById(R.id.email_underBar);
        btn_next = findViewById(R.id.btn_next);
        tv_phone_notice = findViewById(R.id.tv_phone_notice);

        et_phone = findViewById(R.id.et_phoneNumber);
        et_email = findViewById(R.id.et_email);

        et_id = findViewById(R.id.et_id);
        et_name = findViewById(R.id.et_name);
        tv_login=findViewById(R.id.tv_login);

        tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SignInActivity.class);
                startActivity(intent);
            }
        });


        tv_select_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //edittext visible과 textview 색상변경
                ly_select_phone.setVisibility(view.VISIBLE);
                ly_select_email.setVisibility(View.INVISIBLE);
                tv_select_phone.setTextColor(Color.BLACK);
                v_select_phone.setBackgroundColor(Color.BLACK);
                tv_select_email.setTextColor(Color.GRAY);
                v_select_email.setBackgroundColor(Color.GRAY);
                tv_phone_notice.setVisibility(view.VISIBLE);
            }
        });

        tv_select_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //edittext visible과 textview 색상변경
                ly_select_phone.setVisibility(view.INVISIBLE);
                ly_select_email.setVisibility(View.VISIBLE);
                tv_select_email.setTextColor(Color.BLACK);
                v_select_email.setBackgroundColor(Color.BLACK);
                tv_select_phone.setTextColor(Color.GRAY);
                v_select_phone.setBackgroundColor(Color.GRAY);
                tv_phone_notice.setVisibility(view.INVISIBLE);


            }
        });


        btn_next.setEnabled(false);
        et_phone.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable edit) {
                if (edit.toString().length() > 8) {
                    // 버튼 상태 활성화.
                    btn_next.setVisibility(View.VISIBLE);
                    btn_next.setEnabled(true) ;
                    btn_next.setOnClickListener(new View.OnClickListener(){
                        public void onClick(View v) {
                            SharedPreferences sharedPreferences = getSharedPreferences("test", MODE_PRIVATE);

                            if (et_email.getText().toString().isEmpty()) { // email 공백
                                sSharedPreferences.edit().putString("PhoneNum", et_phone.getText().toString()).apply();

                            } else // phone 공백
                            {
                                sSharedPreferences.edit().putString("Email", et_email.getText().toString()).apply();
                            }

                            Intent intent = new Intent(getApplicationContext(), Signup_PW_Activity.class);
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

        et_email.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable edit) {
                if (edit.toString().length() > 8) {
                    // 버튼 상태 활성화.
                    btn_next.setVisibility(View.VISIBLE);
                    btn_next.setEnabled(true) ;
                    btn_next.setOnClickListener(new View.OnClickListener(){
                        public void onClick(View v) {
                            SharedPreferences sharedPreferences = getSharedPreferences("test", MODE_PRIVATE);

                            if (et_email.getText().toString().isEmpty()) { // email 공백
                                sSharedPreferences.edit().putString("PhoneNum", et_phone.getText().toString()).apply();

                            } else // phone 공백
                            {
                                sSharedPreferences.edit().putString("Email", et_email.getText().toString()).apply();
                            }

                            Intent intent = new Intent(getApplicationContext(), Signup_PW_Activity.class);
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
