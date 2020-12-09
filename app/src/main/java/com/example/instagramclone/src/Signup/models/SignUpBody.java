package com.example.instagramclone.src.Signup.models;

import com.google.gson.annotations.SerializedName;

public class SignUpBody {
    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("password")
    private String password;

    @SerializedName("email")
    private String email;

    @SerializedName("phoneNum")
    private String phoneNum;

    public SignUpBody(String phoneNum,String email, String password, String name, String id) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phoneNum= phoneNum;
    }
}
