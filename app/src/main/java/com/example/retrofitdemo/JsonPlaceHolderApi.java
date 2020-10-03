package com.example.retrofitdemo;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface JsonPlaceHolderApi {

    @GET("posts")
    Call<List<Post>> getPosts();      // For getPostFirst()

    @GET("posts/{id}/comments")
    Call<List<Comment>> getComments(@Path("id") int postId);

    @GET("posts")
    Call<List<Post>> getPosts(@Query("userId") int userId);        // For getPostSecond()

    @GET("posts")
    Call<List<Post>> getPosts(
            @Query("userId") Integer[] userId,                         // For multiple user ID
            @Query("_sort") String sort,
            @Query("_order") String order);                         // For multiple query

    @GET("posts")
    Call<List<Post>> getPosts(@QueryMap Map<String, String> parameters);  // For getting value as key value pair, do not declare
    // in method.

    @GET
    Call<List<Comment>> getComments(@Url String url);                     // For Url

    @POST("posts")
    Call<Post> createPost(@Body Post post);

    @FormUrlEncoded
    @POST("posts")
    Call<Post> createPost(
            @Field("userId") int userId,
            @Field("title") String title,
            @Field("body") String text
    );

    @FormUrlEncoded
    @POST("posts")
    Call<Post> createPost(@FieldMap Map<String, String> fields);

    @PUT("posts/{id}")
    Call<Post> putPost(@Path("id") int id, @Body Post post);

    @PATCH("posts/{id}")
    Call<Post> patchPost(@Path("id") int id, @Body Post post);

    @DELETE("posts/{id}")
    Call<Void> deletePost(@Path("id") int id);
}
