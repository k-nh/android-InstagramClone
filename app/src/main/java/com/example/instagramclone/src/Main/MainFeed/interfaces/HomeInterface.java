package com.example.instagramclone.src.Main.MainFeed.interfaces;


import com.example.instagramclone.src.Main.MainFeed.Models.CommentBody;
import com.example.instagramclone.src.Main.MainFeed.Models.CommentResponse;
import com.example.instagramclone.src.Main.MainFeed.Models.FeedLikeResponse;
import com.example.instagramclone.src.Main.MainFeed.Models.FeedResponse;
import com.example.instagramclone.src.Main.MainFeed.Models.HomeResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface HomeInterface {

    @GET("/signIn/auto")
    Call<HomeResponse> SignInAuto();

    @GET("/feeds")
    Call<FeedResponse> GetFeedList();

    @GET("/feed/{feedId}")
    Call<FeedResponse> GetUserFeedList(
            @Path("feedId") int feedId
    );


    @POST("/feed/{feedId}/like")
    Call<FeedLikeResponse> FeedLike(
            @Path("feedId") int feedId
    );


    @POST("/comment")
    Call<CommentResponse> WriteComment(@Body CommentBody params);



}
