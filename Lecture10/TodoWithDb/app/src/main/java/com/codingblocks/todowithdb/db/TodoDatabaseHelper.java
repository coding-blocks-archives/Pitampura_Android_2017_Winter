package com.codingblocks.todowithdb.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.codingblocks.todowithdb.db.tables.TodoTable;

/**
 * Created by arnav on 1/7/2018.
 */

public class TodoDatabaseHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "todo.db";
    public static final int DB_VER = 1;


    public TodoDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TodoTable.CMD_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
