package dev_pc.recyclerviewsqlite.ui.fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by Dev-pc on 18.12.2017.
 */

public class AbstractTabsFragment extends Fragment {
    private String title;
    protected Context context;
    protected View view;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
