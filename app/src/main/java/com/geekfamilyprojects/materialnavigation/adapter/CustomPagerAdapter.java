package com.geekfamilyprojects.materialnavigation.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.geekfamilyprojects.materialnavigation.fragment.CheeseListFragment;

import java.util.ArrayList;
import java.util.List;

public class CustomPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;
    private List<CheeseListFragment> fragments = new ArrayList<>();
    private List<String> labels = new ArrayList<>();

    public CustomPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {

        // Create fragment object
        Fragment fragment = fragments.get(position);

        // Attach some data to the fragment
        // that we'll use to populate our fragment layouts
        Bundle args = new Bundle();
        args.putInt("page_position", position + 1);

        // Set the arguments on the fragment
        // that will be fetched in the
        // DemoFragment@onCreateView
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return labels.get(position);
    }

    public void addFragment(CheeseListFragment fragment, String label) {
        fragments.add(fragment);
        labels.add(label);
    }
}
