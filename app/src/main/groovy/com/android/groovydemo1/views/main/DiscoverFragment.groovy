package com.android.groovydemo1.views.main

import android.os.Bundle
import android.support.annotation.Nullable
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.android.groovydemo1.R

public class DiscoverFragment extends Fragment {
    @Override
    View onCreateView(LayoutInflater inflater,
                      @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        def v = inflater.inflate(R.layout.fragment_discover, null);
        def txtContent = (TextView) v.findViewById(R.id.txt_content)
        txtContent.setText("Hello, discover fragment.");
        return v;
    }
}