package com.example.instagramclone.src.Signup.interfaces;


import com.example.instagramclone.src.Login.models.SignInResponse;
import com.example.instagramclone.src.Signup.models.SignUpBody;
import com.example.instagramclone.src.Signup.models.SignUpResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface MainRetrofitInterface {


    @POST("/signUp")
    Call<SignUpResponse> signUpTest(@Body SignUpBody params);



}
