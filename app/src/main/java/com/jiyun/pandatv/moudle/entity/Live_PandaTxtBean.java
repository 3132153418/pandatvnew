package com.jiyun.pandatv.moudle.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lenovo on 2017/7/15.
 */
public class Live_PandaTxtBean implements Serializable{

    private static final long serialVersionUID = 7547178462986423296L;
    /**
     * videoset : {"0":{"vsid":"VSET100340574858","name":"熊猫档案","img":"http://p1.img.cctvpic.com/photoAlbum/vms/standard/img/2017/5/10/VSETVFWrHiS4RXSTWVVVFmDV170510.jpg","enname":"其他","url":"http://tv.cntv.cn/videoset/VSET100340574858","cd":"","zy":"","bj":"","dy":"","js":"","nf":"","yz":"","fl":"熊猫直播","sbsj":"","sbpd":"其他","desc":"请你现在开始做到牢记五大认猫大法，每周跟着熊猫档案潜心学习，留心观察，融会贯通。说不定哪一天，你就能在茫茫熊海中focus你的心上熊。","playdesc":"","zcr":"","fcl":""},"count":"10"}
     * video : [{"vsid":"VSET100340574858","order":"10","vid":"19e07c13e3b8463399a5c10b132f090b","t":"《熊猫档案》 20170713 他因爆料太多网红黑料，竟荣登当红节目主角","url":"http://tv.cntv.cn/video/VSET100340574858/19e07c13e3b8463399a5c10b132f090b","ptime":"2017-07-13 18:15:28","img":"http://p2.img.cctvpic.com/fmspic/2017/07/13/19e07c13e3b8463399a5c10b132f090b-69.jpg?p=2&h=120","len":"00:03:25","em":"CM01"},{"vsid":"VSET100340574858","order":"9","vid":"24a1ae38737c44a2a211babb3c6dee3d","t":"《熊猫档案》 20170706 成长外挂第四期：文文演技爆发 实力演绎\u201c双面男神\u201d","url":"http://tv.cntv.cn/video/VSET100340574858/24a1ae38737c44a2a211babb3c6dee3d","ptime":"2017-07-06 15:19:04","img":"http://p3.img.cctvpic.com/fmspic/2017/07/06/24a1ae38737c44a2a211babb3c6dee3d-189.jpg?p=2&h=120","len":"00:05:36","em":"CM01"},{"vsid":"VSET100340574858","order":"8","vid":"c675df403f964fd3a01c66993281ca91","t":"《熊猫档案》 20170629 认猫插件第四期：是他，把众鲜肉秒帅成渣","url":"http://tv.cntv.cn/video/VSET100340574858/c675df403f964fd3a01c66993281ca91","ptime":"2017-06-29 15:05:16","img":"http://p4.img.cctvpic.com/fmspic/2017/06/29/c675df403f964fd3a01c66993281ca91-129.jpg?p=2&h=120","len":"00:05:11","em":"CM01"},{"vsid":"VSET100340574858","order":"7","vid":"2698634a7a9445a9977b73f92d371e33","t":"《熊猫档案》 20170615 成长外挂第三期：有一种爱叫做\u201c奉黄传奇\u201d","url":"http://tv.cntv.cn/video/VSET100340574858/2698634a7a9445a9977b73f92d371e33","ptime":"2017-06-15 16:19:03","img":"http://p4.img.cctvpic.com/fmspic/2017/06/15/2698634a7a9445a9977b73f92d371e33-129.jpg","len":"00:05:22","em":"CM01"},{"vsid":"VSET100340574858","order":"6","vid":"6160fa931c26446c99a4309bf8b66fb7","t":"《熊猫档案》 20170608 认猫插件第三期：教你以正确的姿势品鉴梅菜扣肉","url":"http://tv.cntv.cn/video/VSET100340574858/6160fa931c26446c99a4309bf8b66fb7","ptime":"2017-06-08 12:42:09","img":"http://p4.img.cctvpic.com/fmspic/2017/06/08/6160fa931c26446c99a4309bf8b66fb7-129.jpg","len":"00:05:22","em":"CM01"},{"vsid":"VSET100340574858","order":"5","vid":"3c48ab5014b245babaab0a285f6346b4","t":"《熊猫档案》 20170601 成长外挂第二期：一个被大侠梦耽误的文学青年","url":"http://tv.cntv.cn/video/VSET100340574858/3c48ab5014b245babaab0a285f6346b4","ptime":"2017-06-01 17:22:45","img":"http://p2.img.cctvpic.com/fmspic/2017/06/01/3c48ab5014b245babaab0a285f6346b4-95.jpg","len":"00:02:50","em":"CM01"},{"vsid":"VSET100340574858","order":"4","vid":"9d8cf7b2fc67428187bbd9cb46df747c","t":"《熊猫档案》 20170525 认猫插件第二期：天生忧郁气质的诗人","url":"http://tv.cntv.cn/video/VSET100340574858/9d8cf7b2fc67428187bbd9cb46df747c","ptime":"2017-05-25 17:02:13","img":"http://p1.img.cctvpic.com/fmspic/2017/05/25/9d8cf7b2fc67428187bbd9cb46df747c-129.jpg","len":"00:04:06","em":"CM01"}]
     */

    private VideosetBean videoset;
    private List<VideoBean> video;

    public VideosetBean getVideoset() {
        return videoset;
    }

    public void setVideoset(VideosetBean videoset) {
        this.videoset = videoset;
    }

    public List<VideoBean> getVideo() {
        return video;
    }

    public void setVideo(List<VideoBean> video) {
        this.video = video;
    }

    public static class VideosetBean implements Serializable{
        private static final long serialVersionUID = -8067587391021915399L;
        /**
         * 0 : {"vsid":"VSET100340574858","name":"熊猫档案","img":"http://p1.img.cctvpic.com/photoAlbum/vms/standard/img/2017/5/10/VSETVFWrHiS4RXSTWVVVFmDV170510.jpg","enname":"其他","url":"http://tv.cntv.cn/videoset/VSET100340574858","cd":"","zy":"","bj":"","dy":"","js":"","nf":"","yz":"","fl":"熊猫直播","sbsj":"","sbpd":"其他","desc":"请你现在开始做到牢记五大认猫大法，每周跟着熊猫档案潜心学习，留心观察，融会贯通。说不定哪一天，你就能在茫茫熊海中focus你的心上熊。","playdesc":"","zcr":"","fcl":""}
         * count : 10
         */

        @SerializedName("0")
        private _$0Bean _$0;
        private String count;

        public _$0Bean get_$0() {
            return _$0;
        }

        public void set_$0(_$0Bean _$0) {
            this._$0 = _$0;
        }

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }

        public static class _$0Bean implements Serializable{
            private static final long serialVersionUID = 6473934841536528457L;
            /**
             * vsid : VSET100340574858
             * name : 熊猫档案
             * img : http://p1.img.cctvpic.com/photoAlbum/vms/standard/img/2017/5/10/VSETVFWrHiS4RXSTWVVVFmDV170510.jpg
             * enname : 其他
             * url : http://tv.cntv.cn/videoset/VSET100340574858
             * cd :
             * zy :
             * bj :
             * dy :
             * js :
             * nf :
             * yz :
             * fl : 熊猫直播
             * sbsj :
             * sbpd : 其他
             * desc : 请你现在开始做到牢记五大认猫大法，每周跟着熊猫档案潜心学习，留心观察，融会贯通。说不定哪一天，你就能在茫茫熊海中focus你的心上熊。
             * playdesc :
             * zcr :
             * fcl :
             */

            private String vsid;
            private String name;
            private String img;
            private String enname;
            private String url;
            private String cd;
            private String zy;
            private String bj;
            private String dy;
            private String js;
            private String nf;
            private String yz;
            private String fl;
            private String sbsj;
            private String sbpd;
            private String desc;
            private String playdesc;
            private String zcr;
            private String fcl;

            public String getVsid() {
                return vsid;
            }

            public void setVsid(String vsid) {
                this.vsid = vsid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getEnname() {
                return enname;
            }

            public void setEnname(String enname) {
                this.enname = enname;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getCd() {
                return cd;
            }

            public void setCd(String cd) {
                this.cd = cd;
            }

            public String getZy() {
                return zy;
            }

            public void setZy(String zy) {
                this.zy = zy;
            }

            public String getBj() {
                return bj;
            }

            public void setBj(String bj) {
                this.bj = bj;
            }

            public String getDy() {
                return dy;
            }

            public void setDy(String dy) {
                this.dy = dy;
            }

            public String getJs() {
                return js;
            }

            public void setJs(String js) {
                this.js = js;
            }

            public String getNf() {
                return nf;
            }

            public void setNf(String nf) {
                this.nf = nf;
            }

            public String getYz() {
                return yz;
            }

            public void setYz(String yz) {
                this.yz = yz;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getSbsj() {
                return sbsj;
            }

            public void setSbsj(String sbsj) {
                this.sbsj = sbsj;
            }

            public String getSbpd() {
                return sbpd;
            }

            public void setSbpd(String sbpd) {
                this.sbpd = sbpd;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getPlaydesc() {
                return playdesc;
            }

            public void setPlaydesc(String playdesc) {
                this.playdesc = playdesc;
            }

            public String getZcr() {
                return zcr;
            }

            public void setZcr(String zcr) {
                this.zcr = zcr;
            }

            public String getFcl() {
                return fcl;
            }

            public void setFcl(String fcl) {
                this.fcl = fcl;
            }
        }
    }

    public static class VideoBean implements Serializable{
        private static final long serialVersionUID = -7449972592255203576L;
        /**
         * vsid : VSET100340574858
         * order : 10
         * vid : 19e07c13e3b8463399a5c10b132f090b
         * t : 《熊猫档案》 20170713 他因爆料太多网红黑料，竟荣登当红节目主角
         * url : http://tv.cntv.cn/video/VSET100340574858/19e07c13e3b8463399a5c10b132f090b
         * ptime : 2017-07-13 18:15:28
         * img : http://p2.img.cctvpic.com/fmspic/2017/07/13/19e07c13e3b8463399a5c10b132f090b-69.jpg?p=2&h=120
         * len : 00:03:25
         * em : CM01
         */

        private String vsid;
        private String order;
        private String vid;
        private String t;
        private String url;
        private String ptime;
        private String img;
        private String len;
        private String em;

        public String getVsid() {
            return vsid;
        }

        public void setVsid(String vsid) {
            this.vsid = vsid;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }

        public String getVid() {
            return vid;
        }

        public void setVid(String vid) {
            this.vid = vid;
        }

        public String getT() {
            return t;
        }

        public void setT(String t) {
            this.t = t;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPtime() {
            return ptime;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getLen() {
            return len;
        }

        public void setLen(String len) {
            this.len = len;
        }

        public String getEm() {
            return em;
        }

        public void setEm(String em) {
            this.em = em;
        }
    }
}
