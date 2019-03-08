package dev_pc.recyclerviewsqlite.ui.fragments;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.HashMap;
import java.util.Map;

import dev_pc.recyclerviewsqlite.ui.fragments.birthdayFragment.BirthdaysFragment;
import dev_pc.recyclerviewsqlite.ui.fragments.taskFragment.TasksFragment;

public class TabsAdapter extends FragmentPagerAdapter{
    private Map<Integer, AbstractTabsFragment> tabs;
    Context context;

    public TabsAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
        initTabsMap(context);

    }
    @Override
    public CharSequence getPageTitle(int position) {
        return tabs.get(position).getTitle();
    }


    @Override
    public Fragment getItem(int position) {
        return tabs.get(position);

    }

    @Override
    public int getCount() {
        return tabs.size();
    }

    private void initTabsMap(Context context){
        tabs = new HashMap<>();
        tabs.put(0, BirthdaysFragment.getInstance(context));
        tabs.put(1, TasksFragment.getInstance(context));

    }
}
