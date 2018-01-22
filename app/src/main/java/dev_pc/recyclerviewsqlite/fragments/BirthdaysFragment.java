package dev_pc.recyclerviewsqlite.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dev_pc.recyclerviewsqlite.AbstractTabsFragment;
import dev_pc.recyclerviewsqlite.R;
import dev_pc.recyclerviewsqlite.fragments.birthdayFragment.BirthdayFragment;

/**
 * Created by Dev-pc on 18.12.2017.
 */

public class BirthdaysFragment extends AbstractTabsFragment {

    private static final int LAYOUT = R.layout.birthday_fragment;
    FABBirthday fabBirthday = new FABBirthday();
    FloatingActionButton btn_fabBirthday;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    BirthdayFragment birthdayFragment;

    public static BirthdaysFragment getInstance(Context context){
        Bundle args = new Bundle();
        BirthdaysFragment fragment = new BirthdaysFragment();
        fragment.setArguments(args);
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.start_fragment));
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);
        btn_fabBirthday = view.findViewById(R.id.FABBirthday);
        btn_fabBirthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fabBirthday.show(getFragmentManager(), "fabBirthday");
            }
        });
        return view;
    }

    @Override
    public void onStart() {
        fragmentManager = getActivity().getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        birthdayFragment = new BirthdayFragment();
        fragmentTransaction.replace(R.id.birthday_container, birthdayFragment);
        fragmentTransaction.commit();
        super.onStart();
    }




    @Override
    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
