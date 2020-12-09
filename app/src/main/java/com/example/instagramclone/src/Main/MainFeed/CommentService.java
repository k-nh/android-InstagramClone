package com.example.instagramclone.src.Main.MainFeed;

import android.util.Log;

import com.example.instagramclone.src.Main.MainFeed.Models.CommentBody;
import com.example.instagramclone.src.Main.MainFeed.Models.CommentResponse;
import com.example.instagramclone.src.Main.MainFeed.interfaces.CommentActivityView;
import com.example.instagramclone.src.Main.MainFeed.interfaces.HomeInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.instagramclone.src.ApplicationClass.getRetrofit;

public class CommentService {

    private final CommentActivityView mcommentActivityView;


    CommentService(final FragmentMain commentActivityView) {
        this.mcommentActivityView = commentActivityView;
    }



    void WriteComment(int feedId, String comment) {
        final HomeInterface commentInterface = getRetrofit().create(HomeInterface.class);
        commentInterface.WriteComment(new CommentBody(feedId,comment)).enqueue(new Callback<CommentResponse>() {
            @Override
            public void onResponse(Call<CommentResponse> call, Response<CommentResponse> response) {
                final CommentResponse commentResponse = response.body();
                if (commentResponse == null) {
                    Log.d("test","실패");
                    mcommentActivityView.WriteCommentFailure(null);
                    return;
                }
                mcommentActivityView.WriteCommentSuccess(commentResponse);
            }

            @Override
            public void onFailure(Call<CommentResponse> call, Throwable t) {
                mcommentActivityView.WriteCommentFailure(null);
                Log.e("test",t.toString());

            }
        });
    }
}
