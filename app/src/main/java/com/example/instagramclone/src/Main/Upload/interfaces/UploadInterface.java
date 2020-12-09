package com.example.instagramclone.src.Main.Upload.interfaces;

import com.example.instagramclone.src.Main.Upload.models.UploadBody;
import com.example.instagramclone.src.Main.Upload.models.UploadResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UploadInterface {
    @POST("/feed")
    Call<UploadResponse> upLoadFeed(@Body UploadBody params);

}
