package com.geekfamilyprojects.materialnavigation;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import com.geekfamilyprojects.materialnavigation.adapter.GridAdapter;
import com.geekfamilyprojects.materialnavigation.data.Cheeses;
import com.geekfamilyprojects.materialnavigation.misc.IViewHolderClickListener;
import com.geekfamilyprojects.materialnavigation.model.Category;

public class GridViewActivity extends RootActivity implements IViewHolderClickListener {

    private DrawerLayout mDrawerLayout;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }

        setUpGrid();
        setupAdapter();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sample_actions, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void setUpGrid() {

        mRecyclerView = (RecyclerView)findViewById(R.id.container_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {
            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });

        // The number of Columns
        mLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(mLayoutManager);
    }

    private void setupAdapter() {
        final GridAdapter adapter = new GridAdapter(this, this);
        Category cat = new Category();
        cat.setTitle("Category 1");
        cat.setIcon(Cheeses.getRandomCheeseDrawable());
        adapter.addCategory(cat);
        cat = new Category();
        cat.setTitle("Category 2");
        cat.setIcon(Cheeses.getRandomCheeseDrawable());
        adapter.addCategory(cat);
        cat = new Category();
        cat.setTitle("Category 3");
        cat.setIcon(Cheeses.getRandomCheeseDrawable());
        adapter.addCategory(cat);
        cat = new Category();
        cat.setTitle("Category 4");
        cat.setIcon(Cheeses.getRandomCheeseDrawable());
        adapter.addCategory(cat);
        cat = new Category();
        cat.setTitle("Category 5");
        cat.setIcon(Cheeses.getRandomCheeseDrawable());
        adapter.addCategory(cat);

        mRecyclerView.setAdapter(adapter);
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        showActivity(menuItem.getItemId());
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });
    }

    @Override
    public void gridItemClick(Category category) {
        Intent intent = new Intent(this, CheeseListActivity.class);
        intent.putExtra(CheeseListActivity.CATEGORY_NAME, category.getTitle());
        startActivity(intent);
    }
}