package com.codingblocks.listviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.codingblocks.listviews.adapters.CourseAdapter;
import com.codingblocks.listviews.models.Course;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Course> courses = Course.genRandomCourses(50);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvCourses = findViewById(R.id.lvCourses);
        CourseAdapter courseAdapter = new CourseAdapter(this, courses);
        lvCourses.setAdapter(courseAdapter);

    }
}
