package com.example.instagramclone.src.Main.Navigation.Search.interfaces;

import com.example.instagramclone.src.Main.Navigation.Search.Models.SearchResponse;

public interface SearchActivityView {

    void SearchSuccess(SearchResponse searchResponse);

    void SearchFailure(String message);

}
