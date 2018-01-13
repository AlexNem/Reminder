package dev_pc.recyclerviewsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Dev-pc on 26.12.2017.
 */

public class MyDBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "MyTasks";
    public static final int DB_VERSION = 1;
    public static final String TABLE_NAME = "Tasks";
    public static final String KEY_ID = "_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_INF = "inf";

    public MyDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String exec = "create table " + TABLE_NAME + " ("
        + KEY_ID + " integer primary key autoincrement,"
        + KEY_NAME + " text,"
        + KEY_INF + " text" + ")";
        db.execSQL(exec);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME );
        this.onCreate(db);
    }

}
