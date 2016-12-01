package com.android.groovydemo1.utils

import android.content.Context
import com.android.groovydemo1.KeysBean

class SharedPreferencesUtil {
    def static getInstance(context) {
        context.getSharedPreferences(KeysBean.SHARED_NAME, Context.MODE_PRIVATE)
    }
}