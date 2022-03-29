package com.cst2335.androidproject;

import android.os.Bundle;
import android.util.Log;
import android.view.ViewStub;

import com.cst2335.utilities.BaseNavActivity;

/**
 * Application launch screen. Will contain title screen and a posting of the last recipe saved
 * to favourites showing the details of that recipe to the user.
 */
public class MainActivity extends BaseNavActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_nav);//setting base layout

        // checking for phone or tablet to apply appropriate layout
        boolean isPhone = findViewById(R.id.recipe_details_fragment) == null;
        setupNavigation("Chad Rocheleau", "Main Activity", "1.0");
        // get the ViewStub into which this activities layout will be loaded.
        ViewStub stub = (ViewStub) findViewById(R.id.layout_stub);
        stub.setLayoutResource(R.layout.activity_main);
        stub.inflate();

        Log.d("main", "" + isPhone);
    }


}