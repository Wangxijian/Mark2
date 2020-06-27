package com.stark.mark2;

import android.app.Application;

import com.shuyu.gsyvideoplayer.player.PlayerFactory;
import com.shuyu.gsyvideoplayer.player.SystemPlayerManager;
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

        PlayerFactory.setPlayManager(SystemPlayerManager.class);

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "mark2-db");
        Database db = helper.getWritableDb();
        DaoSession daoSession = new DaoMaster(db).newSession();
        NewsDao newsDao = daoSession.getNewsDao();
        newsDao.deleteAll();
        newsDao.insertInTx(DAOUtils.generateHomeNewsData1());
        newsDao.insertInTx(DAOUtils.generateHomeNewsData2());
        newsDao.insertInTx(DAOUtils.generateHomeNewsData3());
        newsDao.insertInTx(DAOUtils.generateHomeNewsData4());

        newsDao.insertInTx(DAOUtils.generatePartyBuildingNewsData1());
        newsDao.insertInTx(DAOUtils.generatePartyBuildingNewsData2());

        newsDao.insertInTx(DAOUtils.generateStudyNewsData1());
        newsDao.insertInTx(DAOUtils.generateStudyNewsData2());
        newsDao.insertInTx(DAOUtils.generateStudyNewsData3());


        newsDao.insertInTx(DAOUtils.generateManagementNewsData1());

        newsDao.insertInTx(DAOUtils.generateVideo());

        MemberDao memberDao = daoSession.getMemberDao();
        memberDao.deleteAll();
        memberDao.insertInTx(DAOUtils.generateMemberList());

    }


}
