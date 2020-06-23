package com.stark.mark2.util;

import android.content.Context;
import android.os.Build;
import android.util.Log;

import androidx.core.content.ContextCompat;

import com.stark.mark2.R;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    private static final String TAG = "矩衡党务";

    public static int getColor(Context context, int r) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return context.getResources().getColor(r, null);
        } else {

            return ContextCompat.getColor(context, r);
        }
    }

    public static List<Integer> getBannerList() {
        List<Integer> list = new ArrayList<>();
        list.add(R.mipmap.banner_1);
        list.add(R.mipmap.banner_2);
        list.add(R.mipmap.banner_3);
        list.add(R.mipmap.banner_4);
        list.add(R.mipmap.banner_5);
        return list;

    }



    public static void LogE(String content) {
        Log.e(TAG, "" + content);
    }
}
