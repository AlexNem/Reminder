package dev_pc.recyclerviewsqlite.ui.activity;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import dev_pc.recyclerviewsqlite.models.AdapterBirthday;
import dev_pc.recyclerviewsqlite.models.AdapterZadach;
import dev_pc.recyclerviewsqlite.R;
import dev_pc.recyclerviewsqlite.ui.fragments.TabsAdapter;
import dev_pc.recyclerviewsqlite.ui.fragments.dialog_fragments.UpdateTask;
import dev_pc.recyclerviewsqlite.ui.fragments.birthdayFragment.ItemFragment;
import dev_pc.recyclerviewsqlite.ui.fragments.dialog_fragments.UpdateBirthday;

public class MainActivity extends AppCompatActivity implements
        dev_pc.recyclerviewsqlite.ui.fragments.taskFragment.ItemFragment.OnListFragmentInteractionListener,
        ItemFragment.OnListFragmentInteractionListener{


    private ViewPager viewPager;
    CoordinatorLayout coordinatorLayout;
    UpdateTask updateTask;
    UpdateBirthday updateBirthday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.main_layout);
        coordinatorLayout = findViewById(R.id.coteiner);
        updateTask =  new UpdateTask();
        updateBirthday = new UpdateBirthday();
        initTabs();
    }


    private void initTabs() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        TabsAdapter adapter = new TabsAdapter(this,getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.TabLayout);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onListFragmentInteraction(AdapterZadach item) {
        updateTask.setAdapterZadach(item);
        updateTask.show(getSupportFragmentManager(), "updZ");
    }

    @Override
    public void onListFragmentInteraction1(AdapterBirthday item) {
        updateBirthday.setAdapterBirthday(item);
        updateBirthday.show(getSupportFragmentManager(), "updB");

    }


}
