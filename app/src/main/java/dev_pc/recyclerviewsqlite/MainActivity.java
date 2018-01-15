package dev_pc.recyclerviewsqlite;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import android.widget.Toast;



import dev_pc.recyclerviewsqlite.fragments.birthdayFragment.BirthdayFragment;
import dev_pc.recyclerviewsqlite.fragments.taskFragment.ItemFragment;

public class MainActivity extends AppCompatActivity implements
        ItemFragment.OnListFragmentInteractionListener,
        BirthdayFragment.OnListFragmentInteractionListener{


    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.main_layout);

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
        Toast.makeText(this, Integer.toString(item.getId()), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onListFragmentInteraction1(AdapterBirthday item) {
        Toast.makeText(this, Integer.toString(item.getId()), Toast.LENGTH_SHORT).show();
    }
}
