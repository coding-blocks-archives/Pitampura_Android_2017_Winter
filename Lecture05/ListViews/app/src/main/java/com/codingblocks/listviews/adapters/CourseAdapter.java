package com.codingblocks.listviews.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.codingblocks.listviews.R;
import com.codingblocks.listviews.models.Course;

import java.util.ArrayList;

/**
 * Created by arnav on 12/23/2017.
 */

public class CourseAdapter extends BaseAdapter{
    public static final String TAG = "LIST";

    private ArrayList<Course> courses;
    private Context context;

    public CourseAdapter(Context context, ArrayList<Course> courses) {
        this.context = context;
        this.courses = courses;
    }

    @Override
    public int getCount() {
        return courses.size();
    }

    @Override
    public Course getItem(int position) {
        return courses.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d(TAG, "position = " + position + "convertView: = " + convertView);
        if (convertView == null) {
            LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = li.inflate(R.layout.list_item_course, parent, false);

        }
        Course currentCourse = getItem(position);
        ((TextView) convertView.findViewById(R.id.tvCourseName)).setText(currentCourse.getName());
        ((TextView) convertView.findViewById(R.id.tvTeacherName)).setText(currentCourse.getTeacherName());
        ((TextView) convertView.findViewById(R.id.tvLectures)).setText(currentCourse.getLecturesAsString());


        return convertView;
    }
}
