package dev_pc.recyclerviewsqlite.data_base;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import dev_pc.recyclerviewsqlite.models.AdapterBirthday;
import dev_pc.recyclerviewsqlite.models.AdapterZadach;

/**
 * Created by Dev-pc on 13.01.2018.
 */

public class DBdao {

    public List<AdapterZadach> getTaskList(Context context) {
        List<AdapterZadach> list = new ArrayList<>();
        String query = "SELECT * FROM " + MyDBHelper.TABLE_NAME;
        MyDBHelper dbH = new MyDBHelper(context);
        SQLiteDatabase db = dbH.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex(MyDBHelper.KEY_ID));
                String name = cursor.getString(cursor.getColumnIndex(MyDBHelper.KEY_NAME));
                String inf = cursor.getString(cursor.getColumnIndex(MyDBHelper.KEY_INF));
                list.add(new AdapterZadach(id, name, inf));
            } while (cursor.moveToNext());
        }
        dbH.close();
        return list;
    }

    public List<AdapterBirthday> getBirthdayList(Context context) {
        List<AdapterBirthday> list = new ArrayList<>();
        String query = "SELECT * FROM " + MyDBHelper.TABLE_BIRTHDAY;
        MyDBHelper dbHelper = new MyDBHelper(context);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        Cursor cursor = database.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex(MyDBHelper.KEY_IDB));
                String name = cursor.getString(cursor.getColumnIndex(MyDBHelper.KEY_BNAME));
                String data = cursor.getString(cursor.getColumnIndex(MyDBHelper.KEY_DATA));
                list.add(new AdapterBirthday(id, name, data));
            } while (cursor.moveToNext());
        }
        dbHelper.close();
        return list;
    }

}
