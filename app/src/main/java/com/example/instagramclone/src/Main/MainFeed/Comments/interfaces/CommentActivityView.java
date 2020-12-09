package com.example.instagramclone.src.Main.MainFeed.Comments.interfaces;


import com.example.instagramclone.src.Main.MainFeed.Comments.models.CommentResponse;

public interface CommentActivityView {
    void WriteCommentSuccess(CommentResponse commentResponse);

    void WriteCommentFailure(String message);

}
