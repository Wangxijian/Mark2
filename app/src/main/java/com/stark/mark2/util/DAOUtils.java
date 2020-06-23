package com.stark.mark2.util;

import android.content.Context;

import com.stark.mark2.R;
import com.stark.mark2.bean.DaoMaster;
import com.stark.mark2.bean.DaoSession;
import com.stark.mark2.bean.Member;
import com.stark.mark2.bean.MemberDao;
import com.stark.mark2.bean.News;
import com.stark.mark2.bean.NewsDao;

import org.greenrobot.greendao.database.Database;

import java.util.ArrayList;
import java.util.List;

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

    public ArrayList<News> getHomeNews(Context context) {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, DB_NAME);
        Database db = helper.getWritableDb();
        DaoSession daoSession = new DaoMaster(db).newSession();
        NewsDao dao = daoSession.getNewsDao();
        ArrayList<News> list = new ArrayList<>(dao.queryBuilder().where(NewsDao.Properties.NewsType.eq(0)).list());
        db.close();
        return list;
    }

    public ArrayList<News> getNewsByType(Context context, int type) {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, DB_NAME);
        Database db = helper.getWritableDb();
        DaoSession daoSession = new DaoMaster(db).newSession();
        NewsDao dao = daoSession.getNewsDao();
        ArrayList<News> list = new ArrayList<>(dao.queryBuilder().where(NewsDao.Properties.NewsType.eq(type)).list());
        db.close();
        return list;
    }


    public ArrayList<Member> getMember(Context context) {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, DB_NAME);
        Database db = helper.getWritableDb();
        DaoSession daoSession = new DaoMaster(db).newSession();
        MemberDao dao = daoSession.getMemberDao();
        ArrayList<Member> list = new ArrayList<>(dao.queryBuilder().list());
        db.close();
        return list;
    }

    public static List<News> generateHomeNewsData() {
        List<News> list = new ArrayList<>();

        News news = new News();
        news.setNewsType(News.TYPE_NEWS_HOME);
        news.setImageType(News.TYPE_IMAGE_NO_IMAGE);
        news.setNewsTitle("矩衡党支部积极开展法治体检活动");
        news.setNewsSource("矩衡党支部");
        news.setNewsDate("2020年2月28日");
        news.setNewsContent("http://112.74.112.46:9999/news_2.html");
        list.add(news);

        News news1 = new News();
        news1.setNewsType(News.TYPE_NEWS_HOME);
        news1.setImageType(News.TYPE_IMAGE_NORMAL);
        news1.setNewsTitle("爱意抵达彼岸·我们并肩前行 矩衡律师与您一起战“疫”");
        news1.setNewsSource("矩衡党支部");
        news1.setNewsDate("2020年2月28日");
        news1.setNewsImage(R.mipmap.img_news_1);
        news1.setNewsContent("http://112.74.112.46:9999/news_2.html");
        list.add(news1);

        News news2 = new News();
        news2.setNewsType(News.TYPE_NEWS_HOME);
        news2.setImageType(News.TYPE_IMAGE_NORMAL);
        news2.setNewsTitle("矩衡党支部开展 “学条例 学讲话 拥抱新时代 争做新青年”主题党日活动");
        news2.setNewsSource("矩衡党支部");
        news2.setNewsDate("2020年2月28日");
        news2.setNewsImage(R.mipmap.news_2);
        news2.setNewsContent("http://112.74.112.46:9999/news_2.html");
        list.add(news2);



        return list;
    }


    public static List<News> generatePartyBuildingNewsData() {
        List<News> list = new ArrayList<>();

        News news = new News();
        news.setNewsType(News.TYPE_NEWS_PARTY_BUILDING);
        news.setImageType(News.TYPE_IMAGE_NO_IMAGE);
        news.setNewsTitle("“党建+”调亮矩衡发展底色");
        news.setNewsSource("矩衡党支部");
        news.setNewsDate("2020年2月28日");
        news.setNewsContent("http://www.baidu.com");
        list.add(news);

        News news1 = new News();
        news1.setNewsType(News.TYPE_NEWS_PARTY_BUILDING);
        news1.setImageType(News.TYPE_IMAGE_NO_IMAGE);
        news1.setNewsTitle("“党建+”催生新业态");
        news1.setNewsSource("矩衡党支部");
        news1.setNewsDate("2020年2月28日");
        news1.setNewsImage(R.mipmap.img_news_1);
        news1.setNewsContent("http://www.baidu.com");
        list.add(news1);

        News news2 = new News();
        news2.setNewsType(News.TYPE_NEWS_PARTY_BUILDING);
        news2.setImageType(News.TYPE_IMAGE_NO_IMAGE);
        news2.setNewsTitle("以“智慧党建”模式提升律师行业党建工作水平");
        news2.setNewsSource("矩衡党支部");
        news2.setNewsDate("2020年2月28日");
        news2.setNewsImage(R.mipmap.img_news_1);
        news2.setNewsContent("http://www.baidu.com");
        list.add(news2);

        News news3 = new News();
        news3.setNewsType(News.TYPE_NEWS_PARTY_BUILDING);
        news3.setImageType(News.TYPE_IMAGE_NO_IMAGE);
        news3.setNewsTitle("党建铸魂，催生律所发展新活力");
        news3.setNewsSource("矩衡党支部");
        news3.setNewsDate("2020年2月28日");
        news3.setNewsImage(R.mipmap.img_news_1);
        news3.setNewsContent("http://www.baidu.com");
        list.add(news3);

        return list;
    }

    public static List<Member> generateMemberList() {
        List<Member> list = new ArrayList<>();
        Member member1 = new Member();
        member1.setName("罗金云");
        member1.setOrganization("四川矩衡律师事务所党支部");
        member1.setPosition("书记");
        member1.setIcon(R.mipmap.member_1);
        list.add(member1);

        Member member2 = new Member();
        member2.setName("温玉婷");
        member2.setOrganization("四川矩衡律师事务所党支部");
        member2.setPosition("副书记");
        member2.setIcon(R.mipmap.member_2);
        list.add(member2);

        Member member3 = new Member();
        member3.setName("魏玥");
        member3.setOrganization("四川矩衡律师事务所党支部");
        member3.setPosition("宣传委员");
        member3.setIcon(R.mipmap.member_3);
        list.add(member3);

        Member member4 = new Member();
        member4.setName("张峻源");
        member4.setOrganization("四川矩衡律师事务所党支部");
        member4.setPosition("组织委员");
        member4.setIcon(R.mipmap.member_4);
        list.add(member4);

        Member member5 = new Member();
        member5.setName("周文娟");
        member5.setOrganization("四川矩衡律师事务所党支部");
        member5.setPosition("纪检委员");
        member5.setIcon(R.mipmap.member_5);
        list.add(member5);

        Member member6 = new Member();
        member6.setName("梁樱子");
        member6.setOrganization("四川矩衡律师事务所党支部");
        member6.setPosition("青年委员");
        member6.setIcon(R.mipmap.member_6);
        list.add(member6);

        return list;
    }


}
