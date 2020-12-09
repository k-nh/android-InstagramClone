package com.example.instagramclone.src.Main.MainFeed.Comments.interfaces;


import com.example.instagramclone.src.Main.MainFeed.Comments.models.CommentBody;
import com.example.instagramclone.src.Main.MainFeed.Comments.models.CommentListResponse;
import com.example.instagramclone.src.Main.MainFeed.Comments.models.CommentResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CommentInterface {

    @GET("/feed/{feedId}/comments")
    Call<CommentListResponse> getFeedComments(
            @Path("feedId") int feedId,
            @Query("limitStart") int limitStart,
            @Query("limitCount") int limitCount
    );


    @POST("/comment")
    Call<CommentResponse> WriteComment(@Body CommentBody params);

}