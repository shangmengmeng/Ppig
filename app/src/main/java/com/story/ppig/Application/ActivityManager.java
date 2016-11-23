package com.story.ppig.Application;

import android.app.Activity;



import java.util.Stack;

/**
 * Created by ljc on 2016/9/13.
 */
public class ActivityManager {
    private static ActivityManager activityManager;
    private Stack<Activity> activityTask;

    private void ActivityManager() {
    }

    public static synchronized ActivityManager getInstance() {
        if (activityManager == null) {
            activityManager = new ActivityManager();
        }
        return activityManager;
    }



    public void pushOutActivity(Activity activity) {
        if (activityTask != null && activityTask.size() > 0) {
            if (activity != null) {
                activityTask.remove(activity);
                activity = null;
            }
        }
    }

    private Activity getLastActivity() {
        return activityTask.lastElement();
    }

    public void finishAllExcept(Activity ExceptActivity) {
        if (activityTask != null) {
            while (activityTask.size() > 1) {
                Activity activity = getLastActivity();
                if (activity == null)
                    break;
                if (activity != ExceptActivity)
                    pushOutActivity(activity);
            }
        }
    }

    public void finishAll() {
        if (activityTask != null) {
            while (activityTask.size() > 0) {
                Activity activity = getLastActivity();
                if (activity == null)
                    break;
                pushOutActivity(activity);
            }
        }
    }
}

