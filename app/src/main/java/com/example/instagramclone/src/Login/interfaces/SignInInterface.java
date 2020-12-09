package com.example.instagramclone.src.Login.interfaces;


import com.example.instagramclone.src.Login.models.SignInBody;
import com.example.instagramclone.src.Login.models.SignInResponse;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface SignInInterface {
//    //    @GET("/test")
//    @GET("/test")
//    Call<DefaultResponse> getTest();
//
//    @GET("/test/{number}")
//    Call<DefaultResponse> getTestPathAndQuery(
//            @Path("number") int number,
//            @Query("content") final String content
//    );
//
//    @POST("/test")
//    Call<DefaultResponse> postTest(@Body RequestBody params);

    @POST("/signIn")
    Call<SignInResponse> SignInTest(@Body SignInBody params);
}
