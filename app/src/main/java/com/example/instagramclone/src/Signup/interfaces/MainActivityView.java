package com.example.instagramclone.src.Signup.interfaces;

import com.example.instagramclone.src.Signup.models.SignUpResponse;

public interface MainActivityView {

    void validateSuccess(SignUpResponse result);

    void validateFailure(String message);

}
