package com.example.instagramclone.src.Main.Navigation.Account.Models;

import com.google.gson.annotations.SerializedName;

public class AccountBody {
    @SerializedName("Name")
    private String Name;

    public AccountBody(String name) {
        Name = name;
    }
}
