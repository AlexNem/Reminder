package dev_pc.recyclerviewsqlite;

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

public class FAB extends DialogFragment {

    Button btn_save, btn_cancel;
    EditText ed_name, ed_inf;
    String name, inf;
    AdapterZadach adapterZadach;
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
                name = ed_name.getText().toString();
                inf = ed_inf.getText().toString();
                adapterZadach = new AdapterZadach(1, name, inf);
                MyDBHelper db = new MyDBHelper(getContext());
                db.addZadachu(adapterZadach);
                ed_name.setText("");
                ed_inf.setText("");
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
}
