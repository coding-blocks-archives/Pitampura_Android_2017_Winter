package com.codingblocks.ankorestapi.api

import com.codingblocks.ankorestapi.models.*
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by championswimmer on 21/01/18.
 */
interface JpApi {
    @GET("posts")
    fun getPosts(): Call<Array<Post>>

    @GET("album")
    fun getAlbums(): Call<Array<Album>>

    @GET("todo")
    fun getTodos(): Call<Array<Todo>>

    @GET("photo")
    fun getPhotos(): Call<Array<Photo>>

    @GET("comment")
    fun getComments(): Call<Array<Comment>>

    @GET("user")
    fun getUsers(): Call<Array<User>>


}