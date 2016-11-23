package com.story.ppig.Application;

import android.app.Application;
import android.util.DisplayMetrics;


import java.io.File;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;



/**
 * Created by ljc on 2016/9/12.
 */
public class App extends Application {
    private static App instance = null;
    private ActivityManager activityManager;
    private HashMap<String, Object> mCache;
    private float deviceDensity;
    private int deviceWidth;
    private int deviceHeight;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        activityManager = ActivityManager.getInstance();
        mCache = new HashMap<>();
        initDeviceMsg();

        init3Librarys();

    }

    private void init3Librarys() {

//        initImageLoader();
    }

    private void initDeviceMsg() {
        DisplayMetrics dm = getResources().getDisplayMetrics();
        deviceWidth = dm.widthPixels;
        deviceHeight = dm.heightPixels;
        deviceDensity = dm.density;
    }


//
//    private void initImageLoader() {
//        File cacheDir = new File(AppConstants.CACHE_DIR);
//        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
//                this).threadPriority(Thread.NORM_PRIORITY - 2)
//                .denyCacheImageMultipleSizesInMemory()
//                .diskCache(new UnlimitedDiskCache(cacheDir))
//                .diskCacheFileNameGenerator(new Md5FileNameGenerator())
//                .tasksProcessingOrder(QueueProcessingType.LIFO)// Not
//                .build();
//        ImageLoader.getInstance().init(config);
//    }

    public static App getInstance() {
        return instance;
    }

    public ActivityManager getActivityManager() {
        return activityManager;
    }

    public float getDeviceDensity() {
        return deviceDensity;
    }

    public int getDeviceWidth() {
        return deviceWidth;
    }

    public int getDeviceHeight() {
        return deviceHeight;
    }

    public void cache(String key, Object value) {
        mCache.put(key, value);
    }

    public Object getCache(String key) {
        return mCache.get(key);
    }

    public void removeCache(String key) {
        mCache.remove(key);
    }

    public void clearCache() {
        mCache.clear();
        Runtime.getRuntime().gc();
    }
}
