package com.stark.mark2.util;

import android.content.Context;
import android.os.Build;
import android.util.Log;

import androidx.core.content.ContextCompat;

import com.stark.mark2.R;
import com.stark.mark2.bean.News;

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
    public static List<News> generateNewsData(){
        List<News> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            News news1 = new News();
            news1.setId(i);
            news1.setNewsType(News.TYPE_NORMAL);
            news1.setNewsTitle("爱意抵达彼岸·我们并肩前行 矩衡律师与您一起战“疫”");
            news1.setNewsSource("矩衡党支部");
            news1.setNewsDate("2020年2月28日");
            news1.setNewsImage(R.mipmap.img_news_1);
            news1.setNewsContent("http://www.baidu.com");
            list.add(news1);
        }
        News news = new News();
        news.setId(5);
        news.setNewsType(News.TYPE_NO_IMAGE);
        news.setNewsTitle("矩衡党支部积极开展法治体检活动");
        news.setNewsSource("矩衡党支部");
        news.setNewsDate("2020年2月28日");
        news.setNewsContent("http://www.baidu.com");
        list.add(news);

        return list;
    }


    public static void LogE(String content) {
        Log.e(TAG, "" + content);
    }
}
