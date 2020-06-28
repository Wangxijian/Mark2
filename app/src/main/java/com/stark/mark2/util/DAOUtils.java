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

    public static List<News> generateHomeNewsData1() {
        List<News> list = new ArrayList<>();
        list.add(new News("习近平谈实现中华民族伟大复兴的中国梦",
                News.TYPE_NEWS_HOME_1,
                News.TYPE_IMAGE_NO_IMAGE,
                "党建网微平台",
                "2020年06月28日",
                "http://www.dangjian.cn/shouye/dangjianyaowen/202006/t20200628_5688564.shtml",
                0));
        list.add(new News("从民法典观习近平眼中的“中国之治”",
                News.TYPE_NEWS_HOME_1,
                News.TYPE_IMAGE_NO_IMAGE,
                "党建网微平台",
                "2020年06月28日",
                "http://www.dangjian.com/shouye/dangjianyaowen/202006/t20200628_5688412.shtml",
                0));

        list.add(new News("习近平要求全党同志坚持“三个不动摇”",
                News.TYPE_NEWS_HOME_1,
                News.TYPE_IMAGE_NO_IMAGE,
                "党建网微平台",
                "2020年06月24日",
                "http://www.dangjian.com/shouye/dangjianyaowen/202006/t20200624_5685901.shtml",
                0));
        list.add(new News("实施好民法典 习近平总书记提出五个“加强”",
                News.TYPE_NEWS_HOME_1,
                News.TYPE_IMAGE_NO_IMAGE,
                "党建网微平台",
                "2020年06月15日",
                "http://www.qstheory.cn/zhuanqu/tujie/2020-06/15/c_1126117809.htm",
                0));

        list.add(new News("砥砺奋进当鼓“气”",
                News.TYPE_NEWS_HOME_1,
                News.TYPE_IMAGE_NO_IMAGE,
                "党建网微平台",
                "2020年06月28日",
                "http://www.dangjian.cn/shouye/dangjianyaowen/202006/t20200628_5688335.shtml",
                0));

        return list;
    }

    public static List<News> generateHomeNewsData2() {
        List<News> list = new ArrayList<>();

        list.add(new News("强化担当只争朝夕推动各项任务落地见效 为全面建成小康社会夯实法治基础",
                News.TYPE_NEWS_HOME_2,
                News.TYPE_IMAGE_NO_IMAGE,
                "司法部政府网",
                "2020年06月09日",
                "http://112.74.112.46:9999/news_2_1.html",
                0));

        list.add(new News("两会内外，习近平这样谈全面依法治国",
                News.TYPE_NEWS_HOME_2,
                News.TYPE_IMAGE_NO_IMAGE,
                "新华网",
                "2020年05月27日",
                "http://112.74.112.46:9999/news_2_2.html",
                0));
//        list.add(new News("做实“两新”党建，创新方式方法 | 组织部长这样说",
//                News.TYPE_NEWS_HOME_2,
//                News.TYPE_IMAGE_NO_IMAGE,
//                "成都两新党建",
//                "2020年04月02日",
//                "http://112.74.112.46:9999/news_2_3.html",
//                0));


        return list;
    }

    public static List<News> generateHomeNewsData3() {
        List<News> list = new ArrayList<>();

        list.add(new News("矩衡党支部书记罗金云参加省委常委、组织部部长王正谱调研的律师行业党建工作座谈会并作专题汇报发言",
                News.TYPE_NEWS_HOME_3,
                News.TYPE_IMAGE_NORMAL,
                "矩衡党支部",
                "2020年4月21日",
                "http://www.juhenglawfirm.com/contents/84/3460.html",
                R.mipmap.news_1));

        list.add(new News("天使在前 我们同行 ---战“疫”时刻，矩衡党员律师在行动",
                News.TYPE_NEWS_HOME_3,
                News.TYPE_IMAGE_NO_IMAGE,
                "矩衡党支部",
                "2020年4月21日",
                "http://www.juhenglawfirm.com/contents/84/3459.html",
                0));

        list.add(new News("矩衡资讯 | 矩衡党支部荣获五星级“两新”组织党组织称号",
                News.TYPE_NEWS_HOME_3,
                News.TYPE_IMAGE_NORMAL,
                "矩衡党支部",
                "2020年2月12日",
                "http://www.juhenglawfirm.com/contents/84/2658.html",
                R.mipmap.news_3));

        list.add(new News("全国律师行业“不忘初心、牢记使命”主题教育第四巡回指导组一行莅临矩衡律师事务所调研指导工作",
                News.TYPE_NEWS_HOME_3,
                News.TYPE_IMAGE_NO_IMAGE,
                "矩衡党支部",
                "2019年11月05日",
                "http://www.juhenglawfirm.com/contents/84/2656.html",
                0));

        list.add(new News("盛世华诞 | 矩衡律师事务所为祖国母亲献歌贺生",
                News.TYPE_NEWS_HOME_3,
                News.TYPE_IMAGE_NORMAL,
                "矩衡党支部",
                "2019年10月15日",
                "http://www.juhenglawfirm.com/contents/84/2657.html",
                R.mipmap.news_4));


        list.add(new News("矩衡律所党支部宣传委员魏玥律师参加金牛区9月“两新”组织固定党日活动",
                News.TYPE_NEWS_HOME_3,
                News.TYPE_IMAGE_NORMAL,
                "矩衡党支部",
                "2019年10月15日",
                "http://www.juhenglawfirm.com/contents/84/2653.html",
                R.mipmap.news_5));

        list.add(new News("矩衡律师事务所党支部召开“不忘初心、牢记使命”主题教育动员部署会",
                News.TYPE_NEWS_HOME_3,
                News.TYPE_IMAGE_NORMAL,
                "矩衡党支部",
                "2019年09月27日",
                "http://www.juhenglawfirm.com/contents/84/2655.html",
                R.mipmap.news_6));
        ////////////////////////////////////////////

        list.add(new News("矩衡公益 | 大疆有域·爱心无垠，矩衡“以爱之名”第六站之走进白玉县章都乡小学",
                News.TYPE_NEWS_HOME_3,
                News.TYPE_IMAGE_NORMAL,
                "矩衡党支部",
                "2019年11月15日",
                "http://www.juhenglawfirm.com/contents/1093/2650.html",
                R.mipmap.news_7));

        list.add(new News("矩衡公益 | 让我们以“爱”之名行动起来--系列公益活动之走进阿坝 矩衡律师",
                News.TYPE_NEWS_HOME_3,
                News.TYPE_IMAGE_NO_IMAGE,
                "矩衡党支部",
                "2019年10月21日",
                "http://www.juhenglawfirm.com/contents/1093/2637.html",
                0));

        list.add(new News("矩衡公益 | “以爱之名”系列公益活动-爱心永传递！",
                News.TYPE_NEWS_HOME_3,
                News.TYPE_IMAGE_NO_IMAGE,
                "矩衡党支部",
                "2019年10月17日",
                "http://www.juhenglawfirm.com/contents/1093/2640.html",
                0));

        list.add(new News("情系山区贫困学子 传递真情助力成长",
                News.TYPE_NEWS_HOME_3,
                News.TYPE_IMAGE_NO_IMAGE,
                "矩衡党支部",
                "2019年10月17日",
                "http://www.juhenglawfirm.com/contents/1093/2641.html",
                0));

        list.add(new News("矩衡·祥瑞走进吉福社区，开展“ 世界艾滋病日”法律宣传活动",
                News.TYPE_NEWS_HOME_3,
                News.TYPE_IMAGE_NO_IMAGE,
                "矩衡党支部",
                "2019年10月17日",
                "http://www.juhenglawfirm.com/contents/1093/2642.html",
                0));


        list.add(new News("矩衡•祥瑞走进育苗路社区，扎实推进“法律七进”之进社区活动",
                News.TYPE_NEWS_HOME_3,
                News.TYPE_IMAGE_NO_IMAGE,
                "矩衡党支部",
                "2019年10月17日",
                "http://www.juhenglawfirm.com/contents/1093/2643.html",
                0));

        list.add(new News("矩衡•祥瑞走进得胜社区，扎实推进“法律七进”之进社区活动",
                News.TYPE_NEWS_HOME_3,
                News.TYPE_IMAGE_NO_IMAGE,
                "矩衡党支部",
                "2019年10月17日",
                "http://www.juhenglawfirm.com/contents/1093/2644.html",
                0));


/////////////////////////////////////////

        list.add(new News("矩衡资讯 | 矩衡与四川师范大学共建法学实践教学基地，并设立“矩衡律师励志奖学金”",
                News.TYPE_NEWS_HOME_3,
                News.TYPE_IMAGE_NO_IMAGE,
                "矩衡党支部",
                "2020年2月12日",
                "http://www.juhenglawfirm.com/contents/1093/2638.html",
                0));

        list.add(new News("矩衡资讯 | 矩衡律师走进郫县安德镇天主教堂开展普法活动",
                News.TYPE_NEWS_HOME_3,
                News.TYPE_IMAGE_NO_IMAGE,
                "矩衡党支部",
                "2020年2月12日",
                "http://www.juhenglawfirm.com/contents/1093/2639.html",
                0));

        list.add(new News("矩衡资讯 | 白玉无瑕，爱传千里——矩衡公益活动",
                News.TYPE_NEWS_HOME_3,
                News.TYPE_IMAGE_NO_IMAGE,
                "矩衡党支部",
                "2020年2月12日",
                "http://www.juhenglawfirm.com/contents/1093/2648.html",
                0));




        return list;
    }

    public static List<News> generateHomeNewsData4() {
        List<News> list = new ArrayList<>();


        list.add(new News("2020年党建责任清单",
                News.TYPE_NEWS_HOME_4,
                News.TYPE_IMAGE_NO_IMAGE,
                "矩衡党支部",
                "2020年2月12日",
                "http://112.74.112.46:9999/news_4_1.html",
                0));

        list.add(new News("党支部2020工作设想",
                News.TYPE_NEWS_HOME_4,
                News.TYPE_IMAGE_NO_IMAGE,
                "矩衡党支部",
                "2020年2月12日",
                "http://112.74.112.46:9999/news_4_2.html",
                0));

        list.add(new News("矩衡党建工作2020年月安排计划",
                News.TYPE_NEWS_HOME_4,
                News.TYPE_IMAGE_NO_IMAGE,
                "矩衡党支部",
                "2020年2月12日",
                "http://112.74.112.46:9999/news_4_3.html",
                0));

        list.add(new News("中共四川矩衡律师事务所支部委员2020工作安排",
                News.TYPE_NEWS_HOME_4,
                News.TYPE_IMAGE_NO_IMAGE,
                "矩衡党支部",
                "2020年2月12日",
                "http://112.74.112.46:9999/news_4_4.html",
                0));


        return list;
    }


    public static List<News> generatePartyBuildingNewsData1() {
        List<News> list = new ArrayList<>();
        list.add(new News("“党建+”调亮矩衡发展底色",
                News.TYPE_NEWS_PARTY_BUILDING_1,
                News.TYPE_IMAGE_NO_IMAGE,
                "矩衡党支部",
                "2020年2月12日",
                "http://112.74.112.46:9999/party_building/news_1_1.html",
                0));

        list.add(new News("党建+ 催生新业态",
                News.TYPE_NEWS_PARTY_BUILDING_1,
                News.TYPE_IMAGE_NO_IMAGE,
                "矩衡党支部",
                "2020年2月12日",
                "http://112.74.112.46:9999/party_building/news_1_2.html",
                0));

        return list;
    }

    public static List<News> generatePartyBuildingNewsData2() {
        List<News> list = new ArrayList<>();
        list.add(new News("党建铸魂，催生律所发展新活力",
                News.TYPE_NEWS_PARTY_BUILDING_2,
                News.TYPE_IMAGE_NO_IMAGE,
                "矩衡党支部",
                "2020年2月12日",
                "http://112.74.112.46:9999/party_building/news_2_1.html",
                0));

        list.add(new News("矩衡：旧岁亮佳绩，新春展愿景",
                News.TYPE_NEWS_PARTY_BUILDING_2,
                News.TYPE_IMAGE_NO_IMAGE,
                "矩衡党支部",
                "2020年2月12日",
                "http://112.74.112.46:9999/party_building/news_2_2.html",
                0));

        list.add(new News("以“智慧党建”模式提升律师行业党建工作水平",
                News.TYPE_NEWS_PARTY_BUILDING_2,
                News.TYPE_IMAGE_NO_IMAGE,
                "矩衡党支部",
                "2020年2月12日",
                "http://112.74.112.46:9999/party_building/news_2_3.html",
                0));

        return list;
    }

    public static List<News> generateStudyNewsData1() {
        List<News> list = new ArrayList<>();
        list.add(new News("矩衡党支部开展“学条例 学讲话 拥抱新时代 争做新青年”主题党日活动",
                News.TYPE_NEWS_STUDY_1,
                News.TYPE_IMAGE_NO_IMAGE,
                "矩衡党支部",
                "2020年2月12日",
                "http://112.74.112.46:9999/study/news_1_1.html",
                0));

        list.add(new News("党建搭台·产业共促·筑梦金牛——讲好金牛“两新”故事 开启健康发展之旅",
                News.TYPE_NEWS_STUDY_1,
                News.TYPE_IMAGE_NO_IMAGE,
                "矩衡党支部",
                "2020年2月12日",
                "http://112.74.112.46:9999/study/news_1_2.html",
                0));

        list.add(new News("“法企同行”提升民营经济发展法律服务精准度",
                News.TYPE_NEWS_STUDY_1,
                News.TYPE_IMAGE_NO_IMAGE,
                "矩衡党支部",
                "2020年2月12日",
                "http://112.74.112.46:9999/study/news_1_3.html",
                0));

        list.add(new News("党建为律师行业强根铸魂",
                News.TYPE_NEWS_STUDY_1,
                News.TYPE_IMAGE_NO_IMAGE,
                "矩衡党支部",
                "2020年2月12日",
                "http://112.74.112.46:9999/study/news_1_4.html",
                0));

        list.add(new News("农民工劳务品牌、返乡创业培训，强调普法教育",
                News.TYPE_NEWS_STUDY_1,
                News.TYPE_IMAGE_NO_IMAGE,
                "矩衡党支部",
                "2020年2月12日",
                "http://112.74.112.46:9999/study/news_1_5.html",
                0));

        return list;
    }

    public static List<News> generateStudyNewsData2() {
        List<News> list = new ArrayList<>();


        list.add(new News("召开党支部专题学习会议 学习习总书记重要文章《加强党对全面依法治国的领导》",
                News.TYPE_NEWS_STUDY_2,
                News.TYPE_IMAGE_NO_IMAGE,
                "矩衡党支部",
                "2020年2月12日",
                "http://112.74.112.46:9999/study/news_2_1.html",
                0));


        list.add(new News("召开党支部会议 组织党员理论学习和安排近期工作",
                News.TYPE_NEWS_STUDY_2,
                News.TYPE_IMAGE_NO_IMAGE,
                "矩衡党支部",
                "2020年2月12日",
                "http://112.74.112.46:9999/study/news_2_2.html",
                0));

        return list;
    }

    public static List<News> generateStudyNewsData3() {
        List<News> list = new ArrayList<>();


        list.add(new News("中共四川矩衡律师事务所支部委员会关于深入开展“不忘初心、牢记使命”主题教育工作方案",
                News.TYPE_NEWS_STUDY_3,
                News.TYPE_IMAGE_NO_IMAGE,
                "矩衡党支部",
                "2020年2月12日",
                "http://112.74.112.46:9999/study/news_0_1.html",
                0));


        list.add(new News("砥砺前行  不负使命",
                News.TYPE_NEWS_STUDY_3,
                News.TYPE_IMAGE_NO_IMAGE,
                "矩衡党支部",
                "2020年2月12日",
                "http://112.74.112.46:9999/study/news_0_2.html",
                0));

        return list;
    }





    public static List<News> generateManagementNewsData1() {
        List<News> list = new ArrayList<>();
        list.add(new News("党务条例",
                News.TYPE_NEWS_MANAGEMENT_1,
                News.TYPE_IMAGE_NO_IMAGE,
                "矩衡党支部",
                "2020年2月12日",
                "http://112.74.112.46:9999/management/news_1_1.html",
                0));



        return list;
    }


    public static List<News> generateVideo() {
        List<News> list = new ArrayList<>();
        list.add(new News("党建宣传片",
                News.TYPE_NEWS_VIDEO,
                News.TYPE_IMAGE_NORMAL,
                "矩衡党支部",
                "2020年2月12日",
                "android.resource://com.stark.mark2/"+R.raw.video_1,
                R.mipmap.video_img_1));

        list.add(new News("罗金云云支招",
                News.TYPE_NEWS_VIDEO,
                News.TYPE_IMAGE_NORMAL,
                "矩衡党支部",
                "2020年2月12日",
                "android.resource://com.stark.mark2/"+R.raw.video_2,
                R.mipmap.video_img_2));

        list.add(new News("温玉婷云支招 ",
                News.TYPE_NEWS_VIDEO,
                News.TYPE_IMAGE_NORMAL,
                "矩衡党支部",
                "2020年2月12日",
                "android.resource://com.stark.mark2/"+R.raw.video_3,
                R.mipmap.video_img_2));

        list.add(new News("魏玥云支招",
                News.TYPE_NEWS_VIDEO,
                News.TYPE_IMAGE_NORMAL,
                "矩衡党支部",
                "2020年2月12日",
                "android.resource://com.stark.mark2/"+R.raw.video_4,
                R.mipmap.video_img_2));

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
