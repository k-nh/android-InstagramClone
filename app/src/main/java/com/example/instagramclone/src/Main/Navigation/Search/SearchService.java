package com.example.instagramclone.src.Main.Navigation.Search;

import android.util.Log;

import com.example.instagramclone.src.Main.Navigation.Search.Models.SearchResponse;
import com.example.instagramclone.src.Main.Navigation.Search.interfaces.SearchActivityView;
import com.example.instagramclone.src.Main.Navigation.Search.interfaces.SearchInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.instagramclone.src.ApplicationClass.getRetrofit;

public class SearchService {

    private final SearchActivityView mSearchActivityView;

    SearchService(final SearchActivityView searchActivityView) {
        this.mSearchActivityView = searchActivityView;
    }

    void getSearch(String userId) {
        final SearchInterface searchInterface = getRetrofit().create(SearchInterface.class);
        searchInterface.getSearch(userId).enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
                final SearchResponse searchResponse = response.body();
                if (searchResponse == null) {
                    mSearchActivityView.SearchFailure(null);
                    return;
                }

                mSearchActivityView.SearchSuccess(searchResponse);
            }

            @Override
            public void onFailure(Call<SearchResponse> call, Throwable t) {
                mSearchActivityView.SearchFailure(null);
                Log.e("test",t.toString());
            }
        });
    }
}
