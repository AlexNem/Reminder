package dev_pc.recyclerviewsqlite;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Dev-pc on 27.12.2017.
 */

public class FABBirthday extends DialogFragment {

    Button btn_save, btn_cancel;
    EditText ed_name, ed_inf;
    AdapterBirthday adapterBirthday;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        getDialog();
        View v = inflater.inflate(R.layout.fab, null);
        btn_save = v.findViewById(R.id.btn_save);
        ed_name = v.findViewById(R.id.ed_name);
        ed_inf = v.findViewById(R.id.ed_inf);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addBirthday();

            }
        });
        btn_cancel = v.findViewById(R.id.btn_cansel);
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });
        return v;
    }

    public void addBirthday(){
        MyDBHelper dbHelper = new MyDBHelper(getContext());
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        adapterBirthday = new AdapterBirthday(1,ed_name.getText().toString(), ed_inf.getText().toString());
        ContentValues contentValues = new ContentValues();
        contentValues.put(dbHelper.KEY_BNAME, adapterBirthday.getName());
        contentValues.put(dbHelper.KEY_DATA, adapterBirthday.getData());
        database.insert(dbHelper.TABLE_BIRTHDAY, null, contentValues);
        dbHelper.close();
        ed_name.setText("");
        ed_inf.setText("");
    }
}
