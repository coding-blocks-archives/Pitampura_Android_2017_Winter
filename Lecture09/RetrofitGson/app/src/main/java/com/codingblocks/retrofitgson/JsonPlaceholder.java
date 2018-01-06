package com.codingblocks.retrofitgson;

import com.codingblocks.retrofitgson.models.Post;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by arnav on 1/6/2018.
 */

public interface JsonPlaceholder {

    @GET("posts")
    Call<ArrayList<Post>> getPosts();

    @GET("posts/{postId}")
    Call<Post> getPostById (
            @Path("postId") Integer postId
    );
}
