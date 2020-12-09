package com.example.instagramclone.src.Main.Navigation.Account.UserInfo.interfaces;

import com.example.instagramclone.src.Main.Navigation.Account.UserInfo.Models.UserInfoResponse;

public interface UserInfoActivityView {

    void UserInfoSuccess(UserInfoResponse userInfoResponse);

    void UserInfoFailure(String message);

}
