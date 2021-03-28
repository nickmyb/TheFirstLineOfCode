package com.nickmyb.testactivitylifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseActivity extends AppCompatActivity {
    private static final String TAG = "BaseActivity";

    static class ActivityCollector {
        public static List<Activity> activityList = new ArrayList<>();

        public static boolean addActivity(Activity activity) {
            return activityList.add(activity);
        }

        public static boolean removeActivity(Activity activity) {
            return activityList.remove(activity);
        }

        public static void exit() {
            for (Activity a: activityList) {
                if (!a.isFinishing()) {
                    a.finish();
                }
            }
            activityList.clear();
            Log.i(TAG, "ACTIVE ACTIVITIES = " + ActivityCollector.activityList);
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "CURRENT ACTIVITY = " + getClass().getName());
        ActivityCollector.addActivity(this);
        Log.i(TAG, "ACTIVE ACTIVITIES = " + ActivityCollector.activityList);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
        Log.i(TAG, "ACTIVE ACTIVITIES = " + ActivityCollector.activityList);
    }
}
