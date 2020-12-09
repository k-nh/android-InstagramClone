package com.example.instagramclone.src.Main.MainFeed;

import android.util.Log;

import com.example.instagramclone.src.Main.MainFeed.Models.HomeResponse;
import com.example.instagramclone.src.Main.MainFeed.interfaces.HomeActivityView;
import com.example.instagramclone.src.Main.MainFeed.interfaces.HomeInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.instagramclone.src.ApplicationClass.getRetrofit;

class HomeService {
    private final HomeActivityView mHomeActivityView;

    HomeService(final FragmentMain homeActivityView) {
        this.mHomeActivityView = homeActivityView;
    }

    void getTest() {
        final HomeInterface homeInterface = getRetrofit().create(HomeInterface.class);
        homeInterface.SignInAuto().enqueue(new Callback<HomeResponse>() {
            @Override
            public void onResponse(Call<HomeResponse> call, Response<HomeResponse> response) {
                final HomeResponse homeResponse = response.body();
                if (homeResponse == null) {
                    mHomeActivityView.HomeFailure(null);
                    return;
                }

                mHomeActivityView.HomeSuccess(homeResponse);
            }

            @Override
            public void onFailure(Call<HomeResponse> call, Throwable t) {
                mHomeActivityView.HomeFailure(null);
                Log.e("test",t.toString());
            }
        });
    }
}