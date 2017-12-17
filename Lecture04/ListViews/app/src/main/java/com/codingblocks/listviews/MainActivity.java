package com.codingblocks.listviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] courses = {
            "Pandora",
            "Elixir",
            "Launchpad",
            "Crux",
            "Perceptron",
            "Gamedev",
            "Competitive Coding",
            "Algo++"
    };
    ListView lvCourses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvCourses = findViewById(R.id.lvCourses);
        ArrayAdapter<String> courseAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                courses
        );
        lvCourses.setAdapter(courseAdapter);
        lvCourses.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,
                        "Clicked on" + position,
                        Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }
}
