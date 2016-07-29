package com.imap.demo;

import android.app.Activity;
import android.os.Bundle;

import com.imap.R;
import com.imap.maps.model.MapViewAdapter;


public class MainActivity extends Activity {

    MapViewAdapter mapViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapViewAdapter = (MapViewAdapter) findViewById(R.id.map);
        mapViewAdapter.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapViewAdapter.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapViewAdapter.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapViewAdapter.onSaveInstanceState(outState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapViewAdapter.onDestroy();
    }
}
