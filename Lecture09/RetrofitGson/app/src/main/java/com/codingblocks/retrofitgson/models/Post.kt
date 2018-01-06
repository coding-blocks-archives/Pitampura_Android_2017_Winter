package com.codingblocks.retrofitgson.models

/**
 * Created by arnav on 1/6/2018.
 */
data class Post (
        val userId: Int,
        val id: Int,
        val title: String,
        val body: String
)