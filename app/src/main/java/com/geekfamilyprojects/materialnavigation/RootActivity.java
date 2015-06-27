package com.geekfamilyprojects.materialnavigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public abstract class RootActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

   @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    protected void showActivity(int id){

        Intent intent;

        switch (id) {
            case R.id.nav_tabbed:
                intent = new Intent(this, SlidingTabViewActivity.class);
                break;
            case R.id.nav_grid:
                intent = new Intent(this, GridViewActivity.class);
                break;
            default:
                intent = new Intent(this, MainActivity.class);
        }

        startActivity(intent);
    }
}