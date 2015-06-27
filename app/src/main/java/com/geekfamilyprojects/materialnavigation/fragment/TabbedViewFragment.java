package com.geekfamilyprojects.materialnavigation.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geekfamilyprojects.materialnavigation.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class TabbedViewFragment extends Fragment {

    public TabbedViewFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sliding_tabs_view, container, false);
    }
}
