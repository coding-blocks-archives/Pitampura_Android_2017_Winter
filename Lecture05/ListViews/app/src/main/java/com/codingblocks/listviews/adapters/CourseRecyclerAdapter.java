package com.codingblocks.listviews.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codingblocks.listviews.R;
import com.codingblocks.listviews.models.Course;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by arnav on 12/23/2017.
 */

public class CourseRecyclerAdapter extends RecyclerView.Adapter<CourseRecyclerAdapter.CourseViewHolder> {

    private Context context;
    private ArrayList<Course> courses;

    public CourseRecyclerAdapter(Context context, ArrayList<Course> courses) {
        this.context = context;
        this.courses = courses;
    }

    @Override
    public CourseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.list_item_course_left, parent, false);

        return new CourseViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CourseViewHolder holder, int position) {
        Course currentCourse = courses.get(position);
        holder.tvLectures.setText(currentCourse.getLecturesAsString());
        holder.tvCourseName.setText(currentCourse.getName());
        holder.tvTeacherName.setText(currentCourse.getTeacherName());


    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    static class CourseViewHolder extends RecyclerView.ViewHolder {
        TextView tvCourseName, tvTeacherName, tvLectures;

        public CourseViewHolder(View itemView) {
            super(itemView);
            tvCourseName = itemView.findViewById(R.id.tvCourseName);
            tvTeacherName = itemView.findViewById(R.id.tvTeacherName);
            tvLectures = itemView.findViewById(R.id.tvLectures);
        }
    }
}
