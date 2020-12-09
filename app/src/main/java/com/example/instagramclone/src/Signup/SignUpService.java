package com.example.instagramclone.src.Signup;

import android.util.Log;

import com.example.instagramclone.src.Signup.interfaces.MainActivityView;
import com.example.instagramclone.src.Signup.interfaces.MainRetrofitInterface;
import com.example.instagramclone.src.Signup.models.SignUpBody;
import com.example.instagramclone.src.Signup.models.SignUpResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.instagramclone.src.ApplicationClass.getRetrofit;

class SignUpService {
    private final MainActivityView mMainActivityView;

    SignUpService(final MainActivityView mainActivityView) {
        this.mMainActivityView = mainActivityView;
    }


    void PostSignUp(String phone,String email, String pw, String name, String id) {
        final MainRetrofitInterface mainRetrofitInterface = getRetrofit().create(MainRetrofitInterface.class);
        mainRetrofitInterface.signUpTest(new SignUpBody(phone, email, pw, name, id)).enqueue(new Callback<SignUpResponse>() {
            @Override
            public void onResponse(Call<SignUpResponse> call, Response<SignUpResponse> response) {
                final SignUpResponse signUpResponse = response.body();
                if (signUpResponse == null) {
                    mMainActivityView.validateFailure(null);
                    Log.d("test","실패");
                    return;
                }

                Log.d("test","성공");
                mMainActivityView.validateSuccess(signUpResponse);

            }

            @Override
            public void onFailure(Call<SignUpResponse> call, Throwable t) {
                mMainActivityView.validateFailure(null);
                Log.e("test",t.toString());
            }
        });

    }
}