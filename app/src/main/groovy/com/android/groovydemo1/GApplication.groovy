package com.android.groovydemo1

import android.app.Activity
import android.app.Application
import android.content.Intent
import android.os.Bundle
import com.android.groovydemo1.utils.ToastUtil

public class GApplication extends Application implements Application.ActivityLifecycleCallbacks{

    def activities
    def isForeground
    def foregroundCount

    @Override
    void onCreate() {
        super.onCreate()
        if(activities == null) activities = []
        foregroundCount = 0
        registerActivityLifecycleCallbacks(this)
    }

    @Override
    void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        activities << activity
    }

    @Override
    void onActivityStarted(Activity activity) {

    }

    @Override
    void onActivityResumed(Activity activity) {
        foregroundCount++
        if(foregroundCount == 1)
        {
            isForeground = true
            ToastUtil.showShort(this, "enter foreground")
        }
    }

    @Override
    void onActivityPaused(Activity activity) {

    }

    @Override
    void onActivityStopped(Activity activity) {
        foregroundCount--
        if(foregroundCount == 0) {
            isForeground = false
            ToastUtil.showShort(this, "exit foreground")
        }
    }

    @Override
    void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    void onActivityDestroyed(Activity activity) {
        activities -= [activity]
    }

    def enterBackground() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);// 注意
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
    }

    def exit() {
        if(activities != null) {
            for(activity in activities) {
                activity?.finish()
            }
        }
    }
}