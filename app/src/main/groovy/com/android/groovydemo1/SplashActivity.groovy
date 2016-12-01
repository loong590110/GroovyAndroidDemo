package com.android.groovydemo1

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.annotation.Nullable
import com.android.groovydemo1.views.base.BaseActivity
import com.android.groovydemo1.views.main.GMainActivity

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState)
        setContentView R.layout.activity_splash
        new Handler().postDelayed ({
            startActivity(new Intent(this, GMainActivity.class))
            finish()
        }, 1000)
    }

}