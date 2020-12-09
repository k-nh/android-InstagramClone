package com.example.instagramclone.src.Signup.AutoLogin.interfaces;


import com.example.instagramclone.src.Signup.AutoLogin.models.AutoLoginResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AutoLoginRetrofitInterface {
    @GET("/testJWT")
    Call<AutoLoginResponse> AutoLogInTest();
}
