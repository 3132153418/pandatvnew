package com.jiyun.pandatv.httpadress;


public class Urls {
    //服务器地址
    private static final String BASEURL = "http://www.ipanda.com/kehuduan/";

    //熊猫直播

    public static final String PANDALUNBO = BASEURL+"PAGE14501749764071042/index.json";

    public static final String PANDAORIGINAL = BASEURL+"PAGE14501767715521482/index.json";
    //版本跟新
    public static final String UPDATE_URL = "http://115.182.9.124/index.php?action=release-GetNewVersions&applyName=1426217325";


    /*
    * 熊猫直播z
    * */
    public static final String PANDALIVE = BASEURL + "PAGE14501769230331752/index.json";
    //    熊猫直播
//    直播上拉
    public static final String shangla = BASEURL + "PAGE14501769230331752/index.json";
    //    多视角直播
    public static final String MOREVIEWLIVE = BASEURL + "PAGE14501769230331752/PAGE14501787896813312/index.json";
    //    表看錶聊
    public static final String BIANKANBIANLIAO = "http://newcomment.cntv.cn/comment/list";
    //    精彩一刻after
    public static final String LIVE_BASEURL = "http://api.cntv.cn/video/videolistById";
    //精彩一刻
//    http://api.cntv.cn/video/videolistById?vsid=VSET100167216881&n=7&serviceId=panda&o=desc&of=time&p=1
    //    超萌滚滚秀
//    public static final String QW =http://api.cntv.cn/video/videolistById?vsid=VSET100272959126&n=7&serviceId=panda&o=desc&of=time&p=1;
//    当熊不让（没有）
//    public static final String SD="    http://api.cntv.cn/video/videolistById?vsid=VSET100332640004&n=7&serviceId=panda&o=desc&of=time&p=1";
    //    熊猫TOP榜VSET100237714751
//    public static final String WE = "    http://api.cntv.cn/video/videolistById?vsid=VSET100284428835&n=7&serviceId=panda&o=desc&of=time&p=1 ";
    //    熊猫那些事
//    public static final String QS = "    http://api.cntv.cn/video/videolistById?vsid=&n=7&serviceId=panda&o=desc&of=time&p=1 ";
    //    特别节目
//    public static final String DS = "    http://api.cntv.cn/video/videolistById?vsid=VSET100167308855&n=7&serviceId=panda&o=desc&of=time&p=1 ";
    //    原创新闻
//    public static final String XC = "    http://api.cntv.cn/video/videolistById?vsid=VSET100219009515&n=7&serviceId=panda&o=desc&of=time&p=1 ";
    //    熊猫档案
//    public static final String ZX = "    http://api.cntv.cn/video/videolistById?vsid=VSET100340574858&n=7&serviceId=panda&o=desc&of=time&p=1 ";

    //熊猫播报
//    1.轮播
    public static final String PAPERLUNBO = BASEURL + "PAGE14503485387528442/index.json";
    //    2.数据
    public static final String PAPERLDATA = "http://api.cntv.cn/apicommon/index?path=iphoneInterface/general/getArticleAndVideoListInfo.json&primary_id=PAGE1449807494852603,PAGE1451473625420136,PAGE1449807502866458,PAGE1451473627439140,PAGE1451473547108278,PAGE1451473628934144&serviceId=panda";
    /*
    *
    * 直播中国*/
    public static final String LIVECHINAS=BASEURL+"PAGE14501775094142282/index.json";
//    八达岭
    public static final String BADA="http://www.ipanda.com/kehuduan/liebiao/badaling/index.json";
    //  凤凰
    public static final String FENGHUANG="http://www.ipanda.com/kehuduan/liebiao/fenghuanggucheng/index.json";
    //    黄山
    public static final String HUANGSHAN="http://www.ipanda.com/kehuduan/liebiao/huangshan/index.json";
    //    峨眉山
    public static final String EMEISHAN="http://www.ipanda.com/kehuduan/liebiao/emeishan/index.json";

//视频
    public static final String videourl="http://vdn.apps.cntv.cn/api/getVideoInfoForCBox.do";

    //    个人中心
//注册
    public static final String REGISTER_URL = "https://reg.cntv.cn/api/register.action";
    //    https://reg.cntv.cn/api/register.action?passWd=123456&verificationCode=ukp5&addons=IPanda.Android&verificationCode=nuof&mailAdd=1211039589@qq.com
    //登录
    public static final String LOGIN_URL = "https://reg.cntv.cn/login/login.action";
//    https://reg.cntv.cn/login/login.action?service=client_transactio&username=13522508321&password=123qwe...&from=https://reg.cntv.cn/login/login.action

    //验证码
    public static final String IMAGE_CODE = "http://reg.cntv.cn/simple/verificationCode.action";


}
