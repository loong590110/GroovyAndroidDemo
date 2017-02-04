package com.android.groovydemo1.views.login

import android.os.Bundle
import android.support.annotation.Nullable
import android.view.KeyEvent
import com.android.groovydemo1.KeysBean
import com.android.groovydemo1.R
import com.android.groovydemo1.presenters.login.ILoginView
import com.android.groovydemo1.presenters.login.LoginPresenter
import com.android.groovydemo1.utils.SharedPreferencesUtil
import com.android.groovydemo1.utils.ToastUtil
import com.android.groovydemo1.views.base.BaseActivity

public class LoginActivity extends BaseActivity {

    def loginPresenter

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState)
        setContentView R.layout.activity_login
        findViewById(R.id.btn_login).onClickListener = { getLoginPresenter()?.login() }

        loginPresenter = new LoginPresenter(loginView: [
                getUsername: { return "zls" },
                getPassword: { return "123456" },
                onLoginSuccess: {
                    userBean ->
                        ToastUtil.showShort(this, "username:" + userBean.username)
                        SharedPreferencesUtil.getInstance(this).edit().putBoolean(KeysBean.LOGIN, true).commit()
                        finish()
                },
                onLoginFailed: {}
        ] as ILoginView)

    }

    @Override
    boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK) {
            ToastUtil.showShort(this, "activities:" + getApplication()?.activities?.getAt(0))
            getApplication()?.exit()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}