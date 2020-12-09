package com.example.instagramclone.src.Main.Navigation.Search.interfaces;

import com.example.instagramclone.src.Main.Navigation.Search.Models.SearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SearchInterface {
    @GET("/users")
    Call<SearchResponse> getSearch(
            @Query("userId") String userId);

}
