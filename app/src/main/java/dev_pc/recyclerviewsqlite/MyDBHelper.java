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
    public static final String TABLE_BIRTHDAY = "Birthdays";
    public static final String KEY_ID = "_id";
    public static final String KEY_IDB = "_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_INF = "inf";
    public static final String KEY_BNAME = "name";
    public static final String KEY_DATA = "data";

    public MyDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String exec = "create table " + TABLE_NAME + " ("
        + KEY_ID + " integer primary key autoincrement,"
        + KEY_NAME + " text,"
        + KEY_INF + " text" + ")";
        String execb = "create table " + TABLE_BIRTHDAY + " ("
                + KEY_IDB + " integer primary key autoincrement,"
                + KEY_BNAME + " text,"
                + KEY_DATA + " text" + ")";
        db.execSQL(exec);
        db.execSQL(execb);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME );
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BIRTHDAY );
        this.onCreate(db);
    }

}
