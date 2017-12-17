package com.codingblocks.listviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.codingblocks.listviews.models.Course;

import java.util.ArrayList;

public class DetailedListActivity extends AppCompatActivity {

    ArrayList<Course> courseList = Course.genRandCourses(100);
    ListView lvCourseDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_list);

        lvCourseDetails = findViewById(R.id.lvCourseDetails);
        CourseAdapter courseAdapter = new CourseAdapter();
        lvCourseDetails.setAdapter(courseAdapter);
    }

    class CourseAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return courseList.size();
        }

        @Override
        public Course getItem(int position) {
            return courseList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater li = getLayoutInflater();
            View itemView = li.inflate(R.layout.list_item_course_details, parent, false);

            TextView tvTeacherName = itemView.findViewById(R.id.tvTeacherName);
            TextView tvCourseName = itemView.findViewById(R.id.tvCourseName);
            TextView tvOnGoing = itemView.findViewById(R.id.tvOnGoing);
            TextView tvLectureCount = itemView.findViewById(R.id.tvLectureCount);

            Course thisCourse = getItem(position);

            tvCourseName.setText(thisCourse.getName());
            tvTeacherName.setText(thisCourse.getTeacherName());
            tvOnGoing.setText(String.valueOf(thisCourse.isOnGoing()));
            tvLectureCount.setText(String.valueOf(thisCourse.getLectures()));

            return itemView;
        }
    }
}
