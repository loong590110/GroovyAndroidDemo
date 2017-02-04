package com.android.groovydemo1.views.main

import android.content.Intent
import android.os.Bundle
import android.support.annotation.Nullable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.android.groovydemo1.KeysBean
import com.android.groovydemo1.R
import com.android.groovydemo1.utils.SharedPreferencesUtil
import com.android.groovydemo1.views.base.BaseFragment
import com.android.groovydemo1.views.login.LoginActivity

public class MineFragment extends BaseFragment {
    @Override
    View onCreateView(LayoutInflater inflater,
                      @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        def v = inflater.inflate(R.layout.fragment_mine, null);
        def txtContent = (TextView) v.findViewById(R.id.txt_content)
        txtContent.setText("Hello, mine fragment.");
        //v.findViewById(R.id.btn_update).onClickListener = {}
        v.findViewById(R.id.btn_logout).onClickListener = {
            SharedPreferencesUtil.getInstance(getContext()).edit().putBoolean(KeysBean.LOGIN, false).commit()
            startActivity(new Intent(getContext(), LoginActivity.class))
        }
        return v;
    }

}