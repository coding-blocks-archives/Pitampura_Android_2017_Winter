package com.codingblocks.kotlinsample.models

import java.util.ArrayList

/**
 * Created by arnav on 12/24/2017.
 */
data class Course (
        val name: String,
        val teacherName: String,
        val lectures: Int,
        val onGoing: Boolean
)

fun genCourses (n: Int): ArrayList<Course> {
    val courses: ArrayList<Course> = ArrayList()
    for (i in 0 until n) {
        courses.add(
                Course(
                        "Android",
                        "Arnav",
                        22,
                        true
                )
        )
    }
    return  courses
}