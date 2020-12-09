package com.example.instagramclone.src.Signup.AutoLogin;

import android.util.Log;

import com.example.instagramclone.src.Signup.AutoLogin.interfaces.AutoLogInActivityView;
import com.example.instagramclone.src.Signup.AutoLogin.interfaces.AutoLoginRetrofitInterface;
import com.example.instagramclone.src.Signup.AutoLogin.models.AutoLoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.instagramclone.src.ApplicationClass.getRetrofit;

class AutoLoginService {
    private final AutoLogInActivityView mAutoLogInActivityView;

    AutoLoginService(final AutoLogInActivityView autoLogInActivityView) {
        this.mAutoLogInActivityView = autoLogInActivityView;
    }



    void AutoLogInTest() {
        final AutoLoginRetrofitInterface mainRetrofitInterface = getRetrofit().create(AutoLoginRetrofitInterface.class);
        mainRetrofitInterface.AutoLogInTest().enqueue(new Callback<AutoLoginResponse>() {
            @Override
            public void onResponse(Call<AutoLoginResponse> call, Response<AutoLoginResponse> response) {
                final AutoLoginResponse defaultResponse = response.body();
                if (defaultResponse == null) {
                    mAutoLogInActivityView.validateFailure(null);
                    return;
                }

                mAutoLogInActivityView.validateSuccess(defaultResponse.getMessage());
            }

            @Override
            public void onFailure(Call<AutoLoginResponse> call, Throwable t) {
                mAutoLogInActivityView.validateFailure(null);
            }
        });
    }
}
