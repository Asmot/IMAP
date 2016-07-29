package com.common.maps.model;


import android.graphics.Bitmap;

import java.util.ArrayList;

/**
 * 没有存在的必要
 * Created by zxy94400 on 2016/7/29.
 */
interface IMarkerOptions {
    public IMarkerOptions icons(ArrayList<Bitmap> var1);

    public ArrayList<Bitmap> getIcons();

    public IMarkerOptions period(int var1);

    public int getPeriod();
    /** @deprecated */
    public boolean isPerspective();
    /** @deprecated */
    public IMarkerOptions perspective(boolean var1);

    public IMarkerOptions position(LatLngWrapper var1);

    public IMarkerOptions setFlat(boolean var1);

    public IMarkerOptions icon(Bitmap var1);

    public IMarkerOptions anchor(float anchorX, float anchorY);

    public IMarkerOptions setInfoWindowOffset(int offsetX, int offsetY);

    public IMarkerOptions title(String var1);

    public IMarkerOptions snippet(String var1);

    public IMarkerOptions draggable(boolean var1);

    public IMarkerOptions visible(boolean var1);
    public IMarkerOptions setGps(boolean var1) ;

    public LatLngWrapper getPosition();

    public String getTitle();

    public String getSnippet();

    public Bitmap getIcon();

    public float getAnchorU();

    public int getInfoWindowOffsetX();

    public int getInfoWindowOffsetY();

    public float getAnchorV();

    public boolean isDraggable();

    public boolean isVisible();

    public boolean isGps();

    public boolean isFlat();

    public IMarkerOptions zIndex(float var1);
    public float getZIndex();

}
