package com.imap.maps;

import com.imap.maps.model.IMarker;
import com.imap.maps.model.IMarkerOptions;
import com.imap.maps.model.LatLngWrapper;

/**
 * Created by zxy94400 on 2016/7/29.
 */
public interface IMap {
//
//    /**
//     * 道路底图。
//     */
//    public static final int MAP_TYPE_NORMAL = 1;
//    /**
//     * 卫星底图。
//     */
//    public static final int MAP_TYPE_SATELLITE = 2;
//    /**
//     * 黑夜地图。
//     *
//     * @since V2.2.1
//     */
//    public static final int MAP_TYPE_NIGHT = 3;
//    /**
//     * 导航模式
//     */
//    public static final int MAP_TYPE_NAVI = 4;
//    /**
//     * 只在第一次定位移动到地图中心点。
//     *
//     * @since V2.2.1
//     */
//    public static final int LOCATION_TYPE_LOCATE = 1; //只定位，值为1
//    /**
//     * 定位、移动到地图中心点并跟随。
//     *
//     * @since V2.2.1
//     */
//    public static final int LOCATION_TYPE_MAP_FOLLOW = 2; //定位、移动到中心点并跟踪，值为2
//    /**
//     * 定位、移动到地图中心点，跟踪并根据方向旋转地图。
//     *
//     * @since V2.2.1
//     */
//    public static final int LOCATION_TYPE_MAP_ROTATE = 3;//定位、移动到中心点，跟踪并根据方向显示，值为3
//
//    public static final int MASK_LAYER_NONE = -1;
//    public static final int MASK_LAYER_UNDER_MARKER = 0;
//    public static final int MASK_LAYER_UNDER_LINE = 1;
    //// TODO: 2016/7/29 暂时只实现单击
    public static abstract interface OnMapClickListenerWrapper{
        /**
         * 当用户点击地图时回调此方法，如果点击在某overlays 上，overlays 相应了点击事件，则不会触发此方法。如果overlays
         * 没有相应点击事件，则会透传给此方法。此方法的调用是在主线程中。
         *
         * @param point 用户所点击的地理坐标
         */
        public abstract void onMapClick(LatLngWrapper point);
    }

    public void setOnMapClickListener(final OnMapClickListenerWrapper listener);


    /**
     * 添加marker 大头针
     * @param markerOptions
     * @return
     */
    public IMarker addMarker(IMarkerOptions markerOptions);

//public final CameraPosition getCameraPosition() {
//    try {
//        return this.a.getCameraPosition();
//    } catch (RemoteException var2) {
//        throw new RuntimeRemoteException(var2);
//    }
//}
//
//    public final float getMaxZoomLevel() {
//        return this.a.getMaxZoomLevel();
//    }
//
//    public final float getMinZoomLevel() {
//        return this.a.getMinZoomLevel();
//    }
//
//    public final void moveCamera(CameraUpdate var1) {
//        try {
//            this.a.moveCamera(var1.a());
//        } catch (RemoteException var3) {
//            throw new RuntimeRemoteException(var3);
//        }
//    }
//
//    public final void animateCamera(CameraUpdate var1) {
//        try {
//            this.a.animateCamera(var1.a());
//        } catch (RemoteException var3) {
//            throw new RuntimeRemoteException(var3);
//        }
//    }
//
//    public final void animateCamera(CameraUpdate var1, AMap.CancelableCallback var2) {
//        try {
//            this.a.animateCameraWithCallback(var1.a(), var2);
//        } catch (RemoteException var4) {
//            throw new RuntimeRemoteException(var4);
//        }
//    }
//
//    public final void animateCamera(CameraUpdate var1, long var2, AMap.CancelableCallback var4) {
//        try {
//            cv.b(var2 > 0L, "durationMs must be positive");
//            this.a.animateCameraWithDurationAndCallback(var1.a(), var2, var4);
//        } catch (RemoteException var6) {
//            throw new RuntimeRemoteException(var6);
//        }
//    }
//
//    public final void stopAnimation() {
//        try {
//            this.a.stopAnimation();
//        } catch (RemoteException var2) {
//            throw new RuntimeRemoteException(var2);
//        }
//    }
//
//    public final NavigateArrow addNavigateArrow(NavigateArrowOptions var1) {
//        try {
//            return new NavigateArrow(this.a.addNavigateArrow(var1));
//        } catch (RemoteException var3) {
//            throw new RuntimeRemoteException(var3);
//        }
//    }
//
//    public final Polyline addPolyline(PolylineOptions var1) {
//        try {
//            return new Polyline(this.a.addPolyline(var1));
//        } catch (RemoteException var3) {
//            throw new RuntimeRemoteException(var3);
//        }
//    }
//
//    public final Circle addCircle(CircleOptions var1) {
//        try {
//            return new Circle(this.a.addCircle(var1));
//        } catch (RemoteException var3) {
//            throw new RuntimeRemoteException(var3);
//        }
//    }
//
//    public final Arc addArc(ArcOptions var1) {
//        try {
//            return new Arc(this.a.addArc(var1));
//        } catch (RemoteException var3) {
//            throw new RuntimeRemoteException(var3);
//        }
//    }
//
//    public final Polygon addPolygon(PolygonOptions var1) {
//        try {
//            return new Polygon(this.a.addPolygon(var1));
//        } catch (RemoteException var3) {
//            throw new RuntimeRemoteException(var3);
//        }
//    }
//
//    public final GroundOverlay addGroundOverlay(GroundOverlayOptions var1) {
//        try {
//            return new GroundOverlay(this.a.addGroundOverlay(var1));
//        } catch (RemoteException var3) {
//            throw new RuntimeRemoteException(var3);
//        }
//    }
//
//    public final Marker addMarker(MarkerOptions var1) {
//        try {
//            return this.a.addMarker(var1);
//        } catch (RemoteException var3) {
//            throw new RuntimeRemoteException(var3);
//        }
//    }
//
//    public final Text addText(TextOptions var1) {
//        try {
//            return this.a.addText(var1);
//        } catch (RemoteException var3) {
//            throw new RuntimeRemoteException(var3);
//        }
//    }
//
//    public final ArrayList<Marker> addMarkers(ArrayList<MarkerOptions> var1, boolean var2) {
//        try {
//            return this.a.addMarkers(var1, var2);
//        } catch (RemoteException var4) {
//            throw new RuntimeRemoteException(var4);
//        }
//    }
//
//    public final List<Marker> getMapScreenMarkers() {
//        try {
//            return this.a.getMapScreenMarkers();
//        } catch (RemoteException var2) {
//            throw new RuntimeRemoteException(var2);
//        }
//    }
//
//    public final TileOverlay addTileOverlay(TileOverlayOptions var1) {
//        try {
//            return this.a.addTileOverlay(var1);
//        } catch (RemoteException var3) {
//            throw new RuntimeRemoteException(var3);
//        }
//    }
//
//    public final void clear() {
//        try {
//            this.a.clear();
//        } catch (RemoteException var2) {
//            throw new RuntimeRemoteException(var2);
//        }
//    }
//
//    public final void clear(boolean var1) {
//        try {
//            this.a.clear(var1);
//        } catch (RemoteException var3) {
//            throw new RuntimeRemoteException(var3);
//        }
//    }
//
//    public final int getMapType() {
//        try {
//            return this.a.getMapType();
//        } catch (RemoteException var2) {
//            throw new RuntimeRemoteException(var2);
//        }
//    }
//
//    public final void setMapType(int var1) {
//        try {
//            this.a.setMapType(var1);
//        } catch (RemoteException var3) {
//            throw new RuntimeRemoteException(var3);
//        }
//    }
//
//    public final boolean isTrafficEnabled() {
//        try {
//            return this.a.isTrafficEnabled();
//        } catch (RemoteException var2) {
//            throw new RuntimeRemoteException(var2);
//        }
//    }
//
//    public void setTrafficEnabled(boolean var1) {
//        try {
//            this.a.setTrafficEnabled(var1);
//        } catch (RemoteException var3) {
//            throw new RuntimeRemoteException(var3);
//        }
//    }
//
//    public void showMapText(boolean var1) {
//        try {
//            this.a.setMapTextEnable(var1);
//        } catch (RemoteException var3) {
//            throw new RuntimeRemoteException(var3);
//        }
//    }
//
//    public void showIndoorMap(boolean var1) {
//        try {
//            this.a.setIndoorEnabled(var1);
//        } catch (RemoteException var3) {
//            throw new RuntimeRemoteException(var3);
//        }
//    }
//
//    public void showBuildings(boolean var1) {
//        try {
//            this.a.set3DBuildingEnabled(var1);
//        } catch (RemoteException var3) {
//            throw new RuntimeRemoteException(var3);
//        }
//    }
//
//    public void setMyTrafficStyle(MyTrafficStyle var1) {
//        try {
//            this.d = var1;
//            this.a.setMyTrafficStyle(var1);
//        } catch (RemoteException var3) {
//            throw new RuntimeRemoteException(var3);
//        }
//    }
//
//    public MyTrafficStyle getMyTrafficStyle() {
//        return this.d;
//    }
//
//    public final boolean isMyLocationEnabled() {
//        try {
//            return this.a.isMyLocationEnabled();
//        } catch (RemoteException var2) {
//            throw new RuntimeRemoteException(var2);
//        }
//    }
//
//    public final void setMyLocationEnabled(boolean var1) {
//        try {
//            this.a.setMyLocationEnabled(var1);
//        } catch (RemoteException var3) {
//            throw new RuntimeRemoteException(var3);
//        }
//    }
//
//    public final Location getMyLocation() {
//        try {
//            return this.a.getMyLocation();
//        } catch (RemoteException var2) {
//            throw new RuntimeRemoteException(var2);
//        }
//    }
//
//    public final void setLocationSource(LocationSource var1) {
//        try {
//            this.a.setLocationSource(var1);
//        } catch (RemoteException var3) {
//            throw new RuntimeRemoteException(var3);
//        }
//    }
//
//    public final void setMyLocationStyle(MyLocationStyle var1) {
//        try {
//            this.a.setMyLocationStyle(var1);
//        } catch (RemoteException var3) {
//            throw new RuntimeRemoteException(var3);
//        }
//    }
//
//    public final void setMyLocationType(int var1) {
//        try {
//            this.a.setMyLocationType(var1);
//        } catch (RemoteException var3) {
//            throw new RuntimeRemoteException(var3);
//        }
//    }
//
//    public final void setMyLocationRotateAngle(float var1) {
//        try {
//            this.a.setMyLocationRotateAngle(var1);
//        } catch (RemoteException var3) {
//            throw new RuntimeRemoteException(var3);
//        }
//    }
//
//    public final UiSettings getUiSettings() {
//        try {
//            if(this.b == null) {
//                this.b = new UiSettings(this.a.getUiSettings());
//            }
//
//            return this.b;
//        } catch (RemoteException var2) {
//            throw new RuntimeRemoteException(var2);
//        }
//    }
//
//    public final Projection getProjection() {
//        try {
//            if(this.c == null) {
//                this.c = new Projection(this.a.getProjection());
//            }
//
//            return this.c;
//        } catch (RemoteException var2) {
//            throw new RuntimeRemoteException(var2);
//        }
//    }
//
//    public final void setOnCameraChangeListener(AMap.OnCameraChangeListener var1) {
//        try {
//            this.a.setOnCameraChangeListener(var1);
//        } catch (RemoteException var3) {
//            throw new RuntimeRemoteException(var3);
//        }
//    }
//
//    public final void setOnMapClickListener(AMap.OnMapClickListener var1) {
//        try {
//            this.a.setOnMapClickListener(var1);
//        } catch (RemoteException var3) {
//            throw new RuntimeRemoteException(var3);
//        }
//    }
//
//    public final void setOnMapTouchListener(AMap.OnMapTouchListener var1) {
//        try {
//            this.a.setOnMapTouchListener(var1);
//        } catch (RemoteException var3) {
//            throw new RuntimeRemoteException(var3);
//        }
//    }
//
//    public final void setOnPOIClickListener(AMap.OnPOIClickListener var1) {
//        try {
//            this.a.setOnPOIClickListener(var1);
//        } catch (RemoteException var3) {
//            throw new RuntimeRemoteException(var3);
//        }
//    }
//
//    public final void setOnMyLocationChangeListener(AMap.OnMyLocationChangeListener var1) {
//        try {
//            this.a.setOnMyLocationChangeListener(var1);
//        } catch (RemoteException var3) {
//            throw new RuntimeRemoteException(var3);
//        }
//    }
//
//    public final void setOnMapLongClickListener(AMap.OnMapLongClickListener var1) {
//        try {
//            this.a.setOnMapLongClickListener(var1);
//        } catch (RemoteException var3) {
//            throw new RuntimeRemoteException(var3);
//        }
//    }
//
//    public final void setOnMarkerClickListener(AMap.OnMarkerClickListener var1) {
//        try {
//            this.a.setOnMarkerClickListener(var1);
//        } catch (RemoteException var3) {
//            throw new RuntimeRemoteException(var3);
//        }
//    }
//
//    public final void setOnPolylineClickListener(AMap.OnPolylineClickListener var1) {
//        try {
//            this.a.setOnPolylineClickListener(var1);
//        } catch (RemoteException var3) {
//            throw new RuntimeRemoteException(var3);
//        }
//    }
//
//    public final void setOnMarkerDragListener(AMap.OnMarkerDragListener var1) {
//        try {
//            this.a.setOnMarkerDragListener(var1);
//        } catch (RemoteException var3) {
//            throw new RuntimeRemoteException(var3);
//        }
//    }
//
//    public final void setOnInfoWindowClickListener(AMap.OnInfoWindowClickListener var1) {
//        try {
//            this.a.setOnInfoWindowClickListener(var1);
//        } catch (RemoteException var3) {
//            throw new RuntimeRemoteException(var3);
//        }
//    }
//
//    public final void setInfoWindowAdapter(AMap.InfoWindowAdapter var1) {
//        try {
//            this.a.setInfoWindowAdapter(var1);
//        } catch (RemoteException var3) {
//            throw new RuntimeRemoteException(var3);
//        }
//    }
//
//    public final void setOnMapLoadedListener(AMap.OnMapLoadedListener var1) {
//        try {
//            this.a.setOnMaploadedListener(var1);
//        } catch (RemoteException var3) {
//            throw new RuntimeRemoteException(var3);
//        }
//    }
//
//    public final void setOnIndoorBuildingActiveListener(AMap.OnIndoorBuildingActiveListener var1) {
//        try {
//            this.a.setOnIndoorBuildingActiveListener(var1);
//        } catch (RemoteException var3) {
//            throw new RuntimeRemoteException(var3);
//        }
//    }
//
//    /** @deprecated */
//    public void getMapPrintScreen(AMap.onMapPrintScreenListener var1) {
//        this.a.getMapPrintScreen(var1);
//    }
//
//    public void getMapScreenShot(AMap.OnMapScreenShotListener var1) {
//        this.a.getMapScreenShot(var1);
//    }
//
//    public float getScalePerPixel() {
//        try {
//            return this.a.getScalePerPixel();
//        } catch (RemoteException var2) {
//            throw new RuntimeRemoteException(var2);
//        }
//    }
//
//    public void runOnDrawFrame() {
//        this.a.setRunLowFrame(false);
//    }
//
//    public void removecache() {
//        try {
//            this.a.removecache();
//        } catch (RemoteException var2) {
//            throw new RuntimeRemoteException(var2);
//        }
//    }
//
//    public void removecache(AMap.OnCacheRemoveListener var1) {
//        try {
//            this.a.removecache(var1);
//        } catch (RemoteException var3) {
//            throw new RuntimeRemoteException(var3);
//        }
//    }
//
//    public void setCustomRenderer(CustomRenderer var1) {
//        try {
//            this.a.setCustomRenderer(var1);
//        } catch (RemoteException var3) {
//            throw new RuntimeRemoteException(var3);
//        }
//    }
//
//    public void setPointToCenter(int var1, int var2) {
//        try {
//            this.a.setCenterToPixel(var1, var2);
//        } catch (RemoteException var4) {
//            throw new RuntimeRemoteException(var4);
//        }
//    }
//
//    public final void setMapTextZIndex(int var1) {
//        try {
//            this.a.setMapTextZIndex(var1);
//        } catch (RemoteException var3) {
//            throw new RuntimeRemoteException(var3);
//        }
//    }
//
//    public final void setLoadOfflineData(boolean var1) {
//        try {
//            this.a.setLoadOfflineData(var1);
//        } catch (RemoteException var3) {
//            throw new RuntimeRemoteException(var3);
//        }
//    }
//
//    public final int getMapTextZIndex() {
//        try {
//            return this.a.getMapTextZIndex();
//        } catch (RemoteException var2) {
//            throw new RuntimeRemoteException(var2);
//        }
//    }
//
//    /** @deprecated */
//    @Deprecated
//    public static String getVersion() {
//        return "3.3.3";
//    }
//
//    public void reloadMap() {
//        this.a.reloadMap();
//    }
//
//    public void setRenderFps(int var1) {
//        this.a.setRenderFps(var1);
//    }
//
//    public void setIndoorBuildingInfo(IndoorBuildingInfo var1) {
//        try {
//            this.a.setIndoorBuildingInfo((IndoorBuilding)var1);
//        } catch (RemoteException var3) {
//            throw new RuntimeRemoteException(var3);
//        }
//    }
//
//public interface OnMapScreenShotListener {
//    void onMapScreenShot(Bitmap var1);
//
//    void onMapScreenShot(Bitmap var1, int var2);
//}
//
///** @deprecated */
//public interface onMapPrintScreenListener {
//    void onMapPrint(Drawable var1);
//}
//
//public interface OnCacheRemoveListener {
//    void onRemoveCacheFinish(boolean var1);
//}
//
//public interface OnIndoorBuildingActiveListener {
//    void OnIndoorBuilding(IndoorBuildingInfo var1);
//}
//
//public interface OnPOIClickListener {
//    void onPOIClick(Poi var1);
//}
//
//public interface OnMapLoadedListener {
//    void onMapLoaded();
//}
//
//public interface OnMapTouchListener {
//    void onTouch(MotionEvent var1);
//}
//
//public interface OnMapClickListener {
//    void onMapClick(LatLng var1);
//}
//
//public interface OnMapLongClickListener {
//    void onMapLongClick(LatLng var1);
//}
//
//public interface OnCameraChangeListener {
//    void onCameraChange(CameraPosition var1);
//
//    void onCameraChangeFinish(CameraPosition var1);
//}
//
//public interface OnMarkerClickListener {
//    boolean onMarkerClick(Marker var1);
//}
//
//public interface OnPolylineClickListener {
//    void onPolylineClick(Polyline var1);
//}
//
//public interface OnMarkerDragListener {
//    void onMarkerDragStart(Marker var1);
//
//    void onMarkerDrag(Marker var1);
//
//    void onMarkerDragEnd(Marker var1);
//}
//
//public interface OnInfoWindowClickListener {
//    void onInfoWindowClick(Marker var1);
//}
//
//public interface CancelableCallback {
//    void onFinish();
//
//    void onCancel();
//}
//
//public interface OnMyLocationChangeListener {
//    void onMyLocationChange(Location var1);
//}
//
//public interface InfoWindowAdapter {
//    View getInfoWindow(Marker var1);
//
//    View getInfoContents(Marker var1);
//}
}
