package com.codingblocks.kotlinsample.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.codingblocks.kotlinsample.R
import com.codingblocks.kotlinsample.models.Course
import kotlinx.android.synthetic.main.list_item_course.view.*

/**
 * Created by arnav on 12/24/2017.
 */
class CourseAdapter(val context: Context, val courses: ArrayList<Course>): RecyclerView.Adapter<CourseAdapter.CourseViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CourseViewHolder {
        val li: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val itemView = li.inflate(R.layout.list_item_course, parent, false)
        return CourseViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CourseViewHolder?, position: Int) {
        holder?.bindView(courses[position])
    }

    override fun getItemCount(): Int {
        return courses.size
    }

    inner class CourseViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        fun bindView (course: Course) {
            itemView.tvCourseName.text = course.name
            itemView.tvTeacherName.text = course.teacherName
            itemView.tvLectures.text = course.lectures.toString()
        }


    }
}