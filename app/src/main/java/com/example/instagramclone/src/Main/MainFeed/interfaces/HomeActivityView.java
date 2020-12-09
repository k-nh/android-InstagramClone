package com.example.instagramclone.src.Main.MainFeed.interfaces;

import com.example.instagramclone.src.Main.MainFeed.Models.HomeResponse;

public interface HomeActivityView {

    void HomeSuccess(HomeResponse homeResponse);

    void HomeFailure(String message);

}
