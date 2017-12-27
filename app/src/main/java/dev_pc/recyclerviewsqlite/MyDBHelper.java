package dev_pc.recyclerviewsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Dev-pc on 26.12.2017.
 */

public class MyDBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "MyTasks";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "Tasks";
    private static final String KEY_ID = "_id";
    private static final String KEY_NAME = "name";
    private static final String KEY_INF = "inf";

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

    public void addZadachu(AdapterZadach adapterZadach){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_ID, adapterZadach.getId());
        cv.put(KEY_NAME, adapterZadach.getName());
        cv.put(KEY_INF, adapterZadach.getInf());
        db.insert(DB_NAME, null, cv);
        db.query(TABLE_NAME, null, null, null, null, null, null);
        db.close();
    }
}
