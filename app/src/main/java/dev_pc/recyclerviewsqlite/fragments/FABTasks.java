package dev_pc.recyclerviewsqlite.fragments;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import dev_pc.recyclerviewsqlite.AdapterZadach;
import dev_pc.recyclerviewsqlite.MyDBHelper;
import dev_pc.recyclerviewsqlite.R;

/**
 * Created by Dev-pc on 27.12.2017.
 */

public class FABTasks extends DialogFragment {

    Button btn_save, btn_cancel;
    EditText ed_name, ed_inf;
    AdapterZadach adapterZadach;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        getDialog().setTitle("Нове завдання!");
        View v = inflater.inflate(R.layout.fab, null);
        btn_save = v.findViewById(R.id.btn_save);
        ed_name = v.findViewById(R.id.ed_name);
        ed_inf = v.findViewById(R.id.ed_inf);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!TextUtils.isEmpty(ed_name.getText().toString())){

                    if (!TextUtils.isEmpty(ed_inf.getText().toString())){
                        addZadachu();
                        getActivity().recreate();
                        dismiss();
                    }else {
                        Toast.makeText(getContext(), "Заповніть поле подробиці", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(getContext(), "Заповніть поле назва", Toast.LENGTH_SHORT).show();

                }


            }
        });
        btn_cancel = v.findViewById(R.id.btn_cansel);
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Скасовано", Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });
        return v;
    }
    public void addZadachu(){
        MyDBHelper dbH = new MyDBHelper(getContext());
        SQLiteDatabase db = dbH.getWritableDatabase();
        adapterZadach = new AdapterZadach(1, ed_name.getText().toString(), ed_inf.getText().toString());
        ContentValues cv = new ContentValues();
        cv.put(dbH.KEY_NAME, adapterZadach.getName());
        cv.put(dbH.KEY_INF, adapterZadach.getInf());
        db.insert(dbH.TABLE_NAME, null, cv);
        dbH.close();
        ed_name.setText("");
        ed_inf.setText("");
        }
}
