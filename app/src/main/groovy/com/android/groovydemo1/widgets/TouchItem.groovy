package com.android.groovydemo1.widgets

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Color
import android.util.AttributeSet
import android.view.Gravity
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.android.groovydemo1.R

class TouchItem extends RelativeLayout {

    def private key
    def private value
    def private icon
    def final txtKeyId = 100
    def final txtValueId = 101
    def final imgIconId = 102

    TouchItem(Context context, AttributeSet attrs) {
        this(context, attrs, 0)
    }

    TouchItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr)
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TouchItem, defStyleAttr, 0);
        try {
            key = a.getString(R.styleable.TouchItem_key)
            value = a.getString(R.styleable.TouchItem_value)
            icon = a.getDrawable(R.styleable.TouchItem_icon)
            if(icon == null) icon = context.getDrawable(R.drawable.ic_chevron_right_gray_24dp)
        } finally {
            a.recycle();
        }
        initView()
    }

    def initView()
    {
        def density = context.getResources().getDisplayMetrics().density
        def padding = (int)(15 * density)
        def paddingLeft = padding, paddingTop = 0, paddingRight = padding - (int)(5 * density), paddingBottom = 0
        //if(getPaddingLeft() > 0) paddingLeft = getPaddingLeft()
        //if(getPaddingTop() > 0) paddingTop = getPaddingTop()
        //if(getPaddingRight() > 0) paddingRight = getPaddingRight()
        //if(getPaddingBottom() > 0) paddingBottom = getPaddingBottom()
        setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom)
        setMinimumHeight((int)(45 * density))
        def txtKey = new TextView(context)
        def txtValue = new TextView(context)
        def imgIcon = new ImageView(context)
        txtKey.setId(txtKeyId)
        txtValue.setId(txtValueId)
        imgIcon.setId(imgIconId)
        addView(txtKey)
        addView(txtValue)
        addView(imgIcon)
        def txtKeyParams = txtKey.getLayoutParams() as RelativeLayout.LayoutParams
        def txtValueParams = txtValue.getLayoutParams() as RelativeLayout.LayoutParams
        def imgIconParams = imgIcon.getLayoutParams() as RelativeLayout.LayoutParams
        txtKeyParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT)
        txtKeyParams.addRule(RelativeLayout.CENTER_VERTICAL)
        txtKey.setLayoutParams(txtKeyParams)
        txtValueParams.addRule(RelativeLayout.CENTER_VERTICAL)
        txtValueParams.addRule(RelativeLayout.LEFT_OF, imgIconId)
        txtValueParams.addRule(RelativeLayout.RIGHT_OF, txtKeyId)
        txtValueParams.leftMargin = 5 * density
        txtValueParams.rightMargin = 5 * density
        imgIconParams.addRule(RelativeLayout.CENTER_VERTICAL)
        imgIconParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT)
        imgIconParams.width = 18 * density
        imgIconParams.height = 18 * density
        imgIcon.setLayoutParams(imgIconParams)
        txtKey.setTextColor(Color.parseColor("#232323"))
        txtKey.setTextSize(15)
        txtKey.setText(key)
        txtValue.setTextColor(Color.parseColor("#CCCCCC"))
        txtValue.setTextSize(15)
        txtValue.setGravity(Gravity.RIGHT)
        txtValue.setText(value)
        imgIcon.setImageDrawable(icon)
    }

}