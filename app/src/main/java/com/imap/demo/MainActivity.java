package com.imap.demo;

import android.app.Activity;
import android.os.Bundle;

import com.imap.R;
import com.imap.maps.IMap;
import com.imap.maps.model.LatLngWrapper;
import com.imap.maps.MapViewAdapter;
import com.imap.maps.tools.LogManager;


public class MainActivity extends Activity {

    MapViewAdapter mapViewAdapter;
    IMap imap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapViewAdapter = (MapViewAdapter) findViewById(R.id.map);
        mapViewAdapter.onCreate(savedInstanceState);

        imap = mapViewAdapter.getMap();

        imap.setOnMapClickListener(new IMap.OnMapClickListenerWrapper() {

            @Override
            public void onMapClick(LatLngWrapper point) {
                LogManager.Log(LogManager.DEBUG,"onMapClick",point);
            }
        });
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
