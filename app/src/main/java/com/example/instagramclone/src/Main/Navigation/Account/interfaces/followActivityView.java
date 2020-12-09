package com.example.instagramclone.src.Main.Navigation.Account.interfaces;

import com.example.instagramclone.src.Main.Navigation.Account.followModels.FollowRequsetResponse;
import com.example.instagramclone.src.Main.Navigation.Account.followModels.FollowingDeleteResponse;

public interface followActivityView {

    void FollowRequestSuccess(FollowRequsetResponse followRequsetResponse);

    void FollowRequestFailed(String message);

    void FollowingDeleteSuccess(FollowingDeleteResponse followingDeleteResponse);
    void FollowingDeleteFailed(String message);

}
