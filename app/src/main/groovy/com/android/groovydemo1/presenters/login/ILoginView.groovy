package com.android.groovydemo1.presenters.login

import com.android.groovydemo1.presenters.base.IBaseView

public interface ILoginView extends IBaseView {
    def getUsername()
    def getPassword()
    def onLoginSuccess(userBean)
    def onLoginFailed()
}