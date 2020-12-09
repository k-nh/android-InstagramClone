package com.example.instagramclone.src.Main.MainFeed.Comments.interfaces;


import com.example.instagramclone.src.Main.MainFeed.Comments.models.CommentListResponse;

public interface CommentListActivityView {

    void CommentListSuccess(CommentListResponse commentListResponse);

    void CommentListFailure(String message);

}
