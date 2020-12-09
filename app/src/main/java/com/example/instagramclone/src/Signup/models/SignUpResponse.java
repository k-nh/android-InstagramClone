package com.example.instagramclone.src.Signup.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SignUpResponse {

    public class signUpResult{
        @SerializedName("userIdx")
        private int userIdx;

        @SerializedName("jwt")
        private String jwt;

        public int getUserIdx() {
            return userIdx;
        }

        public String getJwt() {
            return jwt;
        }
    }

    @SerializedName("isSuccess")
    private boolean isSuccess;

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("result")
    private signUpResult signUpResult;


    public boolean isSuccess() {
        return isSuccess;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public SignUpResponse.signUpResult getSignUpResult() {
        return signUpResult;
    }
}
