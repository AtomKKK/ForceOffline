package com.qtking.forceoffline;

import android.app.Activity;

import java.util.ArrayList;

/**
 * Created by Think on 2016/12/14.
 */

public class ActivityCollector {

    private static ArrayList<Activity> sActivityArrayList = new ArrayList<>();

    public static void addActivity(Activity activity) {
        sActivityArrayList.add(activity);
    }

    public static void removeActivity(Activity activity) {
        sActivityArrayList.remove(activity);
    }

    public static void removeAll() {
        for (Activity activity : sActivityArrayList) {

            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }
}
