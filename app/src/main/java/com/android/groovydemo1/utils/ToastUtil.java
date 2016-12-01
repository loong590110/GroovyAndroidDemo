package com.android.groovydemo1.utils;


import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ToastUtil
{
    private static Toast toast;

    public static void showLong(Context context, String str)
    {
        cancel();
        (toast = Toast.makeText(context, str, Toast.LENGTH_LONG)).show();
    }

    public static void showLong(Context context, int str)
    {
        cancel();
        (toast = Toast.makeText(context, str, Toast.LENGTH_LONG)).show();
    }

    public static void showShort(Context context, String str)
    {
        cancel();
        (toast = Toast.makeText(context, str, Toast.LENGTH_SHORT)).show();
    }

    public static void showShort(Context context, int str)
    {
        cancel();
        (toast = Toast.makeText(context, str, Toast.LENGTH_SHORT)).show();
    }

    /**
     * 弹出自定义Toast，自定义图片+string
     */
    public static void showCustomToast(Context mContext, int layoutResId, int imgViewResId, int imgResId, int txtViewResId, String str)
    {
        cancel();
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View layout = inflater.inflate(layoutResId, null);
        ImageView image = (ImageView) layout.findViewById(imgViewResId);
        image.setImageResource(imgResId);
        TextView text = (TextView) layout.findViewById(txtViewResId);
        text.setText(str);
        toast = new Toast(mContext);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }

    private static void cancel()
    {
        if(toast != null) toast.cancel();
    }
}
