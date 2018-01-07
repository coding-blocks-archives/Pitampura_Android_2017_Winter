package com.codingblocks.todowithdb;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.codingblocks.todowithdb.db.TodoDatabaseHelper;
import com.codingblocks.todowithdb.db.tables.TodoTable;
import com.codingblocks.todowithdb.models.Todo;

import java.util.ArrayList;

import static com.codingblocks.todowithdb.db.tables.TodoTable.getAllTodos;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "TODOS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TodoDatabaseHelper myDbHelper = new TodoDatabaseHelper(this);
        SQLiteDatabase writeDb = myDbHelper.getWritableDatabase();
        SQLiteDatabase readDb = myDbHelper.getReadableDatabase();

        TodoTable.insertTodo(new Todo(0, "One task", false), writeDb);

        ArrayList<Todo> todos = TodoTable.getAllTodos(readDb);
        Log.d(TAG, "onCreate: size = " + todos.size());
        Log.d(TAG, "onCreate: 0 = " + todos.get(0).getTask());


    }
}
