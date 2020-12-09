package com.example.instagramclone.src.Login.models;

import com.google.gson.annotations.SerializedName;

public class SignInBody {

    @SerializedName("Id")
    private String Id;

    @SerializedName("password")
    private String password;

    public SignInBody(String Id, String password) {
        this.Id = Id;
        this.password = password;
    }
}
