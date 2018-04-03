package com.space.understandandroidopensource.utils;

import android.app.Activity;
import android.util.DisplayMetrics;

/**
 * Created by space on 2017/5/16.
 * Desc:获取屏幕宽度高度密度等。。。。
 */

public class ScreenUtils {

    /**
     * 获取屏幕宽度
     *
     * @param activity
     * @return
     */
    public static int getWidthPixels(Activity activity) {

        DisplayMetrics metric = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metric);
        return metric.widthPixels;
    }

    /**
     * 获取屏幕高度
     *
     * @param activity
     * @return
     */
    public static int getHeightPixels(Activity activity) {

        DisplayMetrics metric = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metric);
        return metric.heightPixels;
    }

    /**
     * 获取屏幕密度
     *
     * @param activity
     * @return
     */
    public static float getDensity(Activity activity) {

        DisplayMetrics metric = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metric);
        return metric.density;
    }

    /**
     * 获取屏幕密度dpi
     *
     * @param activity
     * @return
     */
    public static int getDensityDpi(Activity activity) {

        DisplayMetrics metric = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metric);
        return metric.densityDpi;
    }
}
