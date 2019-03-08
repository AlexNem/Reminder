package dev_pc.recyclerviewsqlite.ui.fragments.dialog_fragments;

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

import dev_pc.recyclerviewsqlite.models.AdapterZadach;
import dev_pc.recyclerviewsqlite.data_base.MyDBHelper;
import dev_pc.recyclerviewsqlite.R;

/**
 * Created by Dev-pc on 16.01.2018.
 */

public class UpdateTask extends DialogFragment {

  private Button btn_delete, btn_update;
  private EditText upd_name, upd_inf;
  private AdapterZadach adapterZadach;


    public void setAdapterZadach(AdapterZadach adapterZadach) {
        this.adapterZadach = adapterZadach;
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
                updZadachu();
                Toast.makeText(getContext(), "Оновлено", Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delZadachy();
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
        upd_name.setText(adapterZadach.getName());
        upd_inf.setText(adapterZadach.getInf());
    }

    public void updZadachu(){
        MyDBHelper dbH = new MyDBHelper(getContext());
        SQLiteDatabase db = dbH.getWritableDatabase();
        adapterZadach.setName(upd_name.getText().toString());
        adapterZadach.setInf(upd_inf.getText().toString());
        ContentValues cv = new ContentValues();

        cv.put(dbH.KEY_NAME, adapterZadach.getName());
        cv.put(dbH.KEY_INF, adapterZadach.getInf());
        db.update(dbH.TABLE_NAME, cv, "_id = ?", new String[]{Integer.toString(adapterZadach.getId())} );
        dbH.close();
        getActivity().recreate();
    }
    public void delZadachy(){
        MyDBHelper dbH = new MyDBHelper(getContext());
        SQLiteDatabase db = dbH.getWritableDatabase();
        db.delete(MyDBHelper.TABLE_NAME, "_id = " + Integer.toString(adapterZadach.getId()), null);
        dbH.close();
        getActivity().recreate();
    }
}
