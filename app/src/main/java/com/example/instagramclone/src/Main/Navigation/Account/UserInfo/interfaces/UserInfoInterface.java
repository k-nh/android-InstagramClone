package com.example.instagramclone.src.Main.Navigation.Account.UserInfo.interfaces;

import com.example.instagramclone.src.Main.Navigation.Account.UserInfo.Models.EditInfoBody;
import com.example.instagramclone.src.Main.Navigation.Account.UserInfo.Models.EditInfoResponse;
import com.example.instagramclone.src.Main.Navigation.Account.UserInfo.Models.UserInfoResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;

public interface UserInfoInterface {

    @GET("/userInfo")
    Call<UserInfoResponse> getUserInfo();

    @PATCH("/userInfo")
    Call<EditInfoResponse> editUserInfo(@Body EditInfoBody params);


}
