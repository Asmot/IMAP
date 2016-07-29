package com.imap.demo;

import android.app.Activity;
import android.os.Bundle;

import com.imap.R;
import com.imap.amap.model.MarkerOptionWrapper;
import com.imap.maps.IMap;
import com.imap.maps.model.IMarker;
import com.imap.maps.model.LatLngWrapper;
import com.imap.amap.MapViewAdapter;
import com.imap.maps.tools.LogManager;


public class MainActivity extends Activity {
    //39.90403, 116.407525

    MapViewAdapter mapViewAdapter;
    IMap imap;
    IMarker iMarker;

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


        iMarker = imap.addMarker(new MarkerOptionWrapper().position(new LatLngWrapper(39.90403, 116.407525)));

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
