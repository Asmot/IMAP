package com.imap.demo;

import android.app.Activity;
import android.os.Bundle;

import com.imap.R;
import com.amap.MapViewAdapter;
import com.common.maps.model.MarkerOptionWrapper;
import com.common.maps.IMap;
import com.common.maps.model.BitmapFactory;
import com.common.maps.model.IMarker;
import com.common.maps.model.LatLngWrapper;
import com.common.maps.tools.LogManager;


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


        iMarker = imap.addMarker(new MarkerOptionWrapper()
                .icon(BitmapFactory.fromResource(this,R.drawable.car))
                .position(new LatLngWrapper(39.90403, 116.407525))
                .anchor(0.5f,0.5f));

    }

    @Override
    protected void onResume() {
        super.onResume();
        mapViewAdapter.onResume();
        simulateStop = false;
        new Thread(simulateRunnable).start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapViewAdapter.onPause();
        simulateStop = true;
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

    boolean simulateStop = true;


    Runnable simulateRunnable = new Runnable() {
        @Override
        public void run() {

            int counter = 0;
            LogManager.Log(LogManager.DEBUG,"start simulate Runnable");

            while (!simulateStop) {
                counter ++;
                if(iMarker != null) {
                    float rotate = iMarker.getRotateAngle();
                    rotate += 5;
                    iMarker.setRotateAngle(rotate);
                }
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    };
}
