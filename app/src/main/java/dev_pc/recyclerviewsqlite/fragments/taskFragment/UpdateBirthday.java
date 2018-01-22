package dev_pc.recyclerviewsqlite.fragments.taskFragment;

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
import android.widget.Toast;

import dev_pc.recyclerviewsqlite.AdapterBirthday;
import dev_pc.recyclerviewsqlite.MyDBHelper;
import dev_pc.recyclerviewsqlite.R;

/**
 * Created by Dev-pc on 18.01.2018.
 */

public class UpdateBirthday extends DialogFragment {

    private Button btn_delete, btn_update;
    private EditText upd_name, upd_inf;
    private AdapterBirthday adapterBirthday;

    public void setAdapterBirthday(AdapterBirthday adapterBirthday) {
        this.adapterBirthday = adapterBirthday;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        getDialog();
        View v = inflater.inflate(R.layout.update_layout, null);
        btn_delete = v.findViewById(R.id.btn_delete);
        upd_name = v.findViewById(R.id.upd_name);
        upd_inf = v.findViewById(R.id.upd_inf);
        btn_update = v.findViewById(R.id.btn_update);
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updBirthday();
                Toast.makeText(getContext(), "Оновлено", Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delBirthday();
                Toast.makeText(getContext(), "Видалено", Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });
        return v;
    }


    @Override
    public void onStart() {
        super.onStart();
        setEditText();
    }
    private void setEditText(){
        upd_name.setText(adapterBirthday.getName());
        upd_inf.setText(adapterBirthday.getData());
    }


    public void updBirthday(){
        MyDBHelper dbH = new MyDBHelper(getContext());
        SQLiteDatabase db = dbH.getWritableDatabase();
        adapterBirthday.setName(upd_name.getText().toString());
        adapterBirthday.setData(upd_inf.getText().toString());
        ContentValues cv = new ContentValues();
        cv.put(dbH.KEY_BNAME, adapterBirthday.getName());
        cv.put(dbH.KEY_DATA, adapterBirthday.getData());
        db.update(dbH.TABLE_BIRTHDAY, cv, "_id = ?", new String[]{Integer.toString(adapterBirthday.getId())} );
        dbH.close();
        getActivity().recreate();
    }
    public void delBirthday(){
        MyDBHelper dbH = new MyDBHelper(getContext());
        SQLiteDatabase db = dbH.getWritableDatabase();
        db.delete(MyDBHelper.TABLE_BIRTHDAY, "_id = " + Integer.toString(adapterBirthday.getId()), null);
        dbH.close();
        getActivity().recreate();
    }
}

