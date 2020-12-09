package com.example.instagramclone.src.Main.Navigation.Account.interfaces;

import com.example.instagramclone.src.Main.Navigation.Account.Models.AccountResponse;

public interface AccountActivityView {

    void AccountSuccess(AccountResponse accountResponse);

    void AccountFailure(String message);

}
