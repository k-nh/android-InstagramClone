package com.example.instagramclone.src.Login;

import android.util.Log;

import com.example.instagramclone.src.Login.models.SignInBody;
import com.example.instagramclone.src.Login.models.SignInResponse;
import com.example.instagramclone.src.Login.interfaces.SignInActivityView;
import com.example.instagramclone.src.Login.interfaces.SignInInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.instagramclone.src.ApplicationClass.getRetrofit;

class SignInService {
    private final SignInActivityView mSignInActivityView;

    SignInService(final SignInActivityView signInActivityView) {
        this.mSignInActivityView = signInActivityView;
    }



    void PostSignIn(String id, String pw) {
        final SignInInterface signInInterface = getRetrofit().create(SignInInterface.class);
        signInInterface.SignInTest(new SignInBody(id,pw)).enqueue(new Callback<SignInResponse>() {
            @Override
            public void onResponse(Call<SignInResponse> call, Response<SignInResponse> response) {
                final SignInResponse signInResponse = response.body();
                if (signInResponse == null) {
                    mSignInActivityView.validateFailure(null);
                    Log.d("test","실패");
                    return;
                }

                Log.d("test","성공");
                mSignInActivityView.validateSuccess(signInResponse);

            }

            @Override
            public void onFailure(Call<SignInResponse> call, Throwable t) {
                mSignInActivityView.validateFailure(null);
                Log.e("test",t.toString());

            }
        });
    }
}
