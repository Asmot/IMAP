package com.common.maps.model;


import android.graphics.Bitmap;

import com.common.maps.IPoint;

import java.util.ArrayList;

/**
 * 根据不同的SDk有不同的实现
 * Created by zxy94400 on 2016/7/29.
 */
public interface IMarker {

    public void setPeriod(int var1);

    public int getPeriod();

    public void setIcons(ArrayList<Bitmap> var1);

    public ArrayList<Bitmap> getIcons();

    public void remove();

    public void destroy();

    public String getId();

    /**
     * @deprecated
     */
    public void setPerspective(boolean var1);

    /**
     * @deprecated
     */
    public boolean isPerspective();

    public void setPosition(LatLngWrapper var1);

    public void setTitle(String var1);

    public String getTitle();

    public void setSnippet(String var1);

    public String getSnippet();

    public void setIcon(Bitmap var1);

    public void setAnchor(float var1, float var2);

    public void setDraggable(boolean var1);

    public boolean isDraggable();

    public void showInfoWindow();

    public void hideInfoWindow();

    public boolean isInfoWindowShown();

    public void setVisible(boolean var1);

    public boolean isVisible();

    public boolean equals(Object var1);

    public int hashCode();

    public void setObject(Object var1);

    public Object getObject();

    public void setRotateAngle(float var1);

    public float getRotateAngle();

    public void setToTop();

    public void setGeoPoint(IPoint var1);

    public IPoint getGeoPoint();

    public void setFlat(boolean var1);

    public boolean isFlat();

    public void setPositionByPixels(int var1, int var2);

    public void setZIndex(float var1);

    public float getZIndex();
}
