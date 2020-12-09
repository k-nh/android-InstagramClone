package com.example.instagramclone.src.Main.Navigation.Search.Models;

import com.google.gson.annotations.SerializedName;

public class SearchResponse {


    @SerializedName("result")
    private SearchResponse.SearchResult[] searchResults;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    public class SearchResult {
        @SerializedName("userIdx")
        private int userIdx;

        @SerializedName("userId")
        private String userId;

        @SerializedName("profileImgUrl")
        private String profileImgUrl;

        @SerializedName("name")
        private String name;

        @SerializedName("follow")
        private String follow;

        public int getUserIdx() {
            return userIdx;
        }

        public String getUserId() {
            return userId;
        }

        public String getProfileImgUrl() {
            return profileImgUrl;
        }

        public String getName() {
            return name;
        }

        public String getFollow() {
            return follow;
        }
    }


    public SearchResult[] getSearchResults() {
        return searchResults;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
