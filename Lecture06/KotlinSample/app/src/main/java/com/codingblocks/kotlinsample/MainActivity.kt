package com.codingblocks.kotlinsample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.codingblocks.kotlinsample.adapters.CourseAdapter
import com.codingblocks.kotlinsample.models.Course
import com.codingblocks.kotlinsample.models.genCourses
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val courses: ArrayList<Course> = genCourses(100)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvCourses.layoutManager = LinearLayoutManager(this)
        rvCourses.adapter = CourseAdapter(this, courses)

    }
}
