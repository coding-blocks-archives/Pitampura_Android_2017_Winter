package com.codingblocks.listviews.models;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by arnav on 12/23/2017.
 */

public class Course {
    String name;
    String teacherName;
    int lectures;

    public Course(String name, String teacherName, int lectures) {
        this.name = name;
        this.teacherName = teacherName;
        this.lectures = lectures;
    }

    public String getName() {
        return name;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public int getLectures() {
        return lectures;
    }
    public String getLecturesAsString () { return String.valueOf(lectures); }

    static String[] sampleCourseNames = {
            "Launchpad", "Crux", "Pandora", "Elixir",
            "Algo++", "Perceptron"
    };

    static String[] sampleTeacherNames = {
            "Prateek", "Deepak", "Rishab",
            "Garima", "Arnav", "Aayush"
    };

    public static ArrayList<Course> genRandomCourses(int n) {
        ArrayList<Course> courses = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            courses.add(new Course(
                    sampleCourseNames[r.nextInt(6)],
                    sampleTeacherNames[r.nextInt(6)],
                    10 + r.nextInt(10)
            ));
        }

        return courses;
    }
}
