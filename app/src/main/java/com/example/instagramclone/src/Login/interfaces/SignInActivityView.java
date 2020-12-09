package com.example.instagramclone.src.Login.interfaces;

import com.example.instagramclone.src.Login.models.SignInResponse;

public interface SignInActivityView {

    void validateSuccess(SignInResponse signInResponse);

    void validateFailure(String message);

}
