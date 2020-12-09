package com.example.instagramclone.src.Main.MainFeed.interfaces;


import com.example.instagramclone.src.Main.MainFeed.Models.FeedLikeResponse;
import com.example.instagramclone.src.Main.MainFeed.Models.FeedResponse;

public interface FeedItemActivityView {
    void FeedItemSuccess(FeedResponse feedResponse);

    void FeedItemFailure(String message);

    void FeedUserItemSuccess(FeedResponse feedResponse);

    void FeedUserItemFailure(String message);


    void FeedLikeSuccess(FeedLikeResponse feedLikeResponse);
    void FeedLikeFailure(String message);

}
