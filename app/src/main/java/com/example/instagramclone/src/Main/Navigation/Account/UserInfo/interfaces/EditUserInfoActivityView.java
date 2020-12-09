package com.example.instagramclone.src.Main.Navigation.Account.UserInfo.interfaces;

import com.example.instagramclone.src.Main.Navigation.Account.UserInfo.Models.EditInfoResponse;

public interface EditUserInfoActivityView {
    void EditUserInfoSuccess(EditInfoResponse editInfoResponse);

    void EditUserInfoFailure(String message);
}
