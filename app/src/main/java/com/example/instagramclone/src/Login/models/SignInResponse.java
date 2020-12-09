package com.example.instagramclone.src.Login.models;

import com.google.gson.annotations.SerializedName;

public class SignInResponse {

    public class signInResult{
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

    @SerializedName("result")
    private signInResult signInResult;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    public SignInResponse.signInResult getSignInResult() {
        return signInResult;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
