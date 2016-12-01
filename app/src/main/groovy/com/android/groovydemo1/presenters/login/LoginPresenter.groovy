package com.android.groovydemo1.presenters.login

import com.android.groovydemo1.models.UserBean
import com.android.groovydemo1.presenters.base.BasePresenter

public class LoginPresenter extends BasePresenter {

    def loginView

    def login() {
        def username = loginView.getUsername()
        def password = loginView.getPassword()
        loginView.onLoginSuccess(new UserBean(username: username, password: password))
    }
}