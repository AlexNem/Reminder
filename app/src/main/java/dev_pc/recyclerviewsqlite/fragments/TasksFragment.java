package dev_pc.recyclerviewsqlite.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dev_pc.recyclerviewsqlite.AbstractTabsFragment;
import dev_pc.recyclerviewsqlite.R;
import dev_pc.recyclerviewsqlite.fragments.taskFragment.ItemFragment;

/**
 * Created by Dev-pc on 18.12.2017.
 */

public class TasksFragment extends AbstractTabsFragment {

    private static final int LAYOUT = R.layout.task_layout;
    FloatingActionButton btn_fabTask;
    FABTasks fabTasks = new FABTasks();
    ItemFragment itemFragment;
    FragmentTransaction fragmentTransaction;
    FragmentManager fragmentManager;
    CoordinatorLayout coordinatorLayout;

    public static TasksFragment getInstance(Context context){
        Bundle args = new Bundle();
        TasksFragment fragment = new TasksFragment();
        fragment.setArguments(args);
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.task_fragment));
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);
        btn_fabTask = view.findViewById(R.id.FABTask);
        btn_fabTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fabTasks.show(getFragmentManager(), "fabTasks");
            }
        });
        coordinatorLayout = view.findViewById(R.id.task_coodinator);
        return view;

    }

    @Override
    public void onStart() {
        fragmentManager = getActivity().getSupportFragmentManager();
        itemFragment = new ItemFragment();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.task_coodinator, itemFragment);
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
