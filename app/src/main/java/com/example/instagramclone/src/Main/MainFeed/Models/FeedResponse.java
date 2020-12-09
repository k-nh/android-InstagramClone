package com.example.instagramclone.src.Main.MainFeed.Models;

import com.google.gson.annotations.SerializedName;

public class FeedResponse {



    @SerializedName("result")
    private FeedResult[] feedResult;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;



    public FeedResult[] getFeedResult() {
        return feedResult;
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

    public static class FeedResult {
        public int commentWrite;


        public int isCommentWrite() {
            return commentWrite;
        }

        public void setCommentWrite(int commentWrite) {
            this.commentWrite = commentWrite;
        }

        public String comment;

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        @SerializedName("feedInfo")
        private FeedInfo feedInfo;

        @SerializedName("feedImgUrls")
        private FeedImgUrls[] feedImgUrls;

        public FeedInfo getFeedInfo() {
            return feedInfo;
        }

        public FeedImgUrls[] getFeedImgUrls() {
            return feedImgUrls;
        }
    }

    public class FeedInfo {
        @SerializedName("feedId")
        private int feedId;

        @SerializedName("profileImgUrl")
        private String profileImgUrl;

        @SerializedName("userIdx")
        private int userIdx;

        @SerializedName("userId")
        private String userId;

        @SerializedName("location")
        private String location;

        @SerializedName("caption")
        private String caption;

        @SerializedName("commentNum")
        private int commentNum;

        @SerializedName("likeNum")
        private int LikeNum;

        @SerializedName("likeUserId")
        private String likeUserId;

        @SerializedName("likeUserProfileImgUrl")
        private String likeUserProfileImgUrl;

        @SerializedName("isLiked")
        private int isLiked;

        public int getFeedId() {
            return feedId;
        }

        public String getProfileImgUrl() {
            return profileImgUrl;
        }

        public int getUserIdx() {
            return userIdx;
        }

        public String getUserId() {
            return userId;
        }

        public String getLocation() {
            return location;
        }

        public String getCaption() {
            return caption;
        }

        public int getCommentNum() {
            return commentNum;
        }

        public int getLikeNum() {
            return LikeNum;
        }

        public String getLikeUserId() {
            return likeUserId;
        }

        public String getLikeUserProfileImgUrl() {
            return likeUserProfileImgUrl;
        }

        public int isLiked() {
            return isLiked;
        }

        public void setLike(int like) {
            isLiked = like;
        }
    }

    public class FeedImgUrls {

        @SerializedName("imgUrl")
        private String feedImgUrl;

        public String getFeedImgUrl() {
            return feedImgUrl;
        }
    }

}
