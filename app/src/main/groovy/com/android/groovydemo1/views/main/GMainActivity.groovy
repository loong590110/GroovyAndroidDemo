package com.android.groovydemo1.views.main

import android.content.Context;
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.widget.TextView
import com.android.groovydemo1.KeysBean
import com.android.groovydemo1.MainActivity
import com.android.groovydemo1.R
import com.android.groovydemo1.views.base.BaseActivity
import com.android.groovydemo1.views.login.LoginActivity

public class GMainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (!getSharedPreferences(KeysBean.SHARED_NAME, Context.MODE_PRIVATE).getBoolean(KeysBean.LOGIN, false)) {
            startActivity(new Intent(this, LoginActivity.class))
        }
        TextView tv = (TextView) findViewById(R.id.sample_text);
        tv.setText(new MainActivity().stringFromJNI());
        ViewPager pager = (ViewPager) findViewById(R.id.view_pager);
        pager.offscreenPageLimit = 3
        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager())
        {
            @Override
            public Fragment getItem(int position) {
                Fragment fragment = null;
                switch (position) {
                    case 0:
                        fragment = new HomeFragment();
                        break;
                    case 1:
                        fragment = new ContactsFragment();
                        break;
                    case 2:
                        fragment = new DiscoverFragment();
                        break;
                    case 3:
                        fragment = new MineFragment();
                        break;
                }
                return fragment;
            }

            @Override
            public int getCount() {
                return 4;
            }
        });
    }

    @Override
    void onBackPressed() {
        //super.onBackPressed()
        getApplication()?.enterBackground()
    }
}
