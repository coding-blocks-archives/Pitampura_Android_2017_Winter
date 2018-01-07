package com.codingblocks.todowithdb.models

/**
 * Created by arnav on 1/7/2018.
 */
data class Todo (
        val id: Int,
        val task: String,
        val done: Boolean
)