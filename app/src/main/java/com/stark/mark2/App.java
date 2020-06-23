package com.stark.mark2;

import android.app.Application;

import com.stark.mark2.bean.DaoMaster;
import com.stark.mark2.bean.DaoSession;
import com.stark.mark2.bean.MemberDao;
import com.stark.mark2.bean.NewsDao;
import com.stark.mark2.util.DAOUtils;

import org.greenrobot.greendao.database.Database;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "mark2-db");
        Database db = helper.getWritableDb();
        DaoSession daoSession = new DaoMaster(db).newSession();
        NewsDao newsDao = daoSession.getNewsDao();
        newsDao.deleteAll();
        newsDao.insertInTx(DAOUtils.generateHomeNewsData());
        newsDao.insertInTx(DAOUtils.generatePartyBuildingNewsData());

        MemberDao memberDao = daoSession.getMemberDao();
        memberDao.deleteAll();
        memberDao.insertInTx(DAOUtils.generateMemberList());

    }


}
