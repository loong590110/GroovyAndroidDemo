package com.android.groovydemo1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.android.groovydemo1.views.main.GMainActivity;

/**
 * Created by Administrator on 2016/11/23 0023.
 */

public class JSplashActivity extends Activity
{
    @Override
    protected void onCreate( Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                startActivity(new Intent(JSplashActivity.this, GMainActivity.class));
                finish();
            }
        }, 1000);
    }
}
