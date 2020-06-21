package com.stark.mark2.util;

import android.content.Context;

import com.stark.mark2.bean.DaoMaster;
import com.stark.mark2.bean.DaoSession;
import com.stark.mark2.bean.News;
import com.stark.mark2.bean.NewsDao;

import org.greenrobot.greendao.database.Database;

import java.util.ArrayList;

public class DAOUtils {
    private static DAOUtils instance;
    private static final String DB_NAME = "mark2-db";


    private DAOUtils() {
    }

    public static DAOUtils getInstance() {
        if (null == instance) {
            instance = new DAOUtils();
        }

        return instance;
    }


    public ArrayList<News> getAllNews(Context context) {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, DB_NAME);
        Database db = helper.getWritableDb();
        DaoSession daoSession = new DaoMaster(db).newSession();
        NewsDao dao = daoSession.getNewsDao();
        ArrayList<News> list = new ArrayList<>(dao.queryBuilder().list());
        db.close();
        return list;
    }

}
