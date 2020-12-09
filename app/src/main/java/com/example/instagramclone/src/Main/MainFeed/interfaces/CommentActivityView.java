package com.example.instagramclone.src.Main.MainFeed.interfaces;


import com.example.instagramclone.src.Main.MainFeed.Models.CommentResponse;

public interface CommentActivityView {
    void WriteCommentSuccess(CommentResponse commentResponse);

    void WriteCommentFailure(String message);

}
