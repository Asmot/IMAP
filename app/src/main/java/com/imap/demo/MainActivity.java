package com.imap.demo;

import android.app.Activity;
import android.os.Bundle;

import com.common.maps.IMapView;
import com.common.maps.SDKInitializer;
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

    IMapView mapViewAdapter;
    IMap imap;
    IMarker iMarker;

    IMapView bdmapView;
    IMap bdImap;
    IMarker bdImarker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testAmap(savedInstanceState);

        testBDMap(savedInstanceState);

    }

    private void testBDMap(Bundle savedInstanceState) {
        bdmapView = (com.bdmap.MapViewAdapter) findViewById(R.id.bdmap);
        bdmapView.onCreate(savedInstanceState);

        bdImap = bdmapView.getMap();


        bdImap.setOnMapClickListener(new IMap.OnMapClickListenerWrapper() {

            @Override
            public void onMapClick(LatLngWrapper point) {
                LogManager.Log(LogManager.DEBUG, "bdImap onMapClick", point);
            }
        });


        bdImarker = bdImap.addMarker(new MarkerOptionWrapper()
                .icon(BitmapFactory.fromResource(this, R.drawable.car))
                .position(new LatLngWrapper(39.90403, 116.407525))
                .anchor(0.5f, 0.5f));

//        bdImap.setMapType(IMap.IMAP_TYPE_NONE);

    }

    private void testAmap(Bundle savedInstanceState) {
        mapViewAdapter = (MapViewAdapter) findViewById(R.id.map);
        mapViewAdapter.onCreate(savedInstanceState);

        imap = mapViewAdapter.getMap();

        imap.setOnMapClickListener(new IMap.OnMapClickListenerWrapper() {

            @Override
            public void onMapClick(LatLngWrapper point) {
                LogManager.Log(LogManager.DEBUG, "aMAP onMapClick", point);
            }
        });


        iMarker = imap.addMarker(new MarkerOptionWrapper()
                .icon(BitmapFactory.fromResource(this, R.drawable.car))
                .position(new LatLngWrapper(39.90403, 116.407525))
                .anchor(0.5f, 0.5f));


//        imap.setMapType(IMap.IMAP_TYPE_NIGHT);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mapViewAdapter != null)
            mapViewAdapter.onResume();

        if (bdmapView != null)
            bdmapView.onResume();

        simulateStop = false;
//        new Thread(simulateRunnable).start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mapViewAdapter != null)
            mapViewAdapter.onPause();

        if (bdmapView != null)
            bdmapView.onPause();

        simulateStop = true;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mapViewAdapter != null)
            mapViewAdapter.onSaveInstanceState(outState);

        if (bdmapView != null)
            bdmapView.onSaveInstanceState(outState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mapViewAdapter != null)
            mapViewAdapter.onDestroy();

        if (bdmapView != null)
            bdmapView.onDestroy();
    }

    boolean simulateStop = true;


    Runnable simulateRunnable = new Runnable() {
        @Override
        public void run() {

            int counter = 0;
            LogManager.Log(LogManager.DEBUG, "start simulate Runnable");

            while (!simulateStop) {
                counter++;
                if (iMarker != null) {
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
