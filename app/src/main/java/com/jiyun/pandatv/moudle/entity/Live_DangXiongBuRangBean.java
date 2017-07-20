package com.jiyun.pandatv.moudle.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by lenovo on 2017/7/15.
 */
public class Live_DangXiongBuRangBean {

    /**
     * videoset : {"0":{"vsid":"VSET100332640004","name":"当熊不让","img":"http://p1.img.cctvpic.com/photoAlbum/vms/standard/img/2017/3/15/VSETgpbnd9sJ0BP2qfKq00j2170315.jpg","enname":"其他","url":"http://tv.cntv.cn/videoset/VSET100332640004","cd":"","zy":"","bj":"","dy":"","js":"","nf":"","yz":"","fl":"熊猫直播","sbsj":"","sbpd":"其他","desc":"新节目《当熊不让》上线啦！每周五盘点当周最火视频和图片，让你一次看遍人气熊猫！","playdesc":"","zcr":"","fcl":""},"count":"19"}
     * video : [{"vsid":"VSET100332640004","order":"19","vid":"77ee585276254a8d920114ce312f87d1","t":"《当熊不让》 20170714 第十九期：热在三伏天，不服都不行","url":"http://tv.cntv.cn/video/VSET100332640004/77ee585276254a8d920114ce312f87d1","ptime":"2017-07-14 13:19:43","img":"http://p1.img.cctvpic.com/fmspic/2017/07/14/77ee585276254a8d920114ce312f87d1-79.jpg?p=2&h=120","len":"00:02:18","em":"CM01"},{"vsid":"VSET100332640004","order":"18","vid":"19852d41dcc74d4dadcc66b91c6d258d","t":"《当熊不让》 20170707 第十八期：想要伺候\u201c灰大王\u201d，得先练有个好手艺！","url":"http://tv.cntv.cn/video/VSET100332640004/19852d41dcc74d4dadcc66b91c6d258d","ptime":"2017-07-07 15:06:35","img":"http://p3.img.cctvpic.com/fmspic/2017/07/07/19852d41dcc74d4dadcc66b91c6d258d-70.jpg?p=2&h=120","len":"00:01:59","em":"CM01"},{"vsid":"VSET100332640004","order":"17","vid":"4f1486bb2e9c4a4a895c07d1c0d88540","t":"《当熊不让》 20170630 第十七期：想要得第一，头上带点绿","url":"http://tv.cntv.cn/video/VSET100332640004/4f1486bb2e9c4a4a895c07d1c0d88540","ptime":"2017-06-30 14:23:28","img":"http://p4.img.cctvpic.com/fmspic/2017/06/30/4f1486bb2e9c4a4a895c07d1c0d88540-95.jpg?p=2&h=120","len":"00:02:49","em":"CM01"},{"vsid":"VSET100332640004","order":"16","vid":"6b7df4639d864e789215ba1c32228e0c","t":"《当熊不让》 20170623 第十六期：熊猫言情剧之爱如潮水","url":"http://tv.cntv.cn/video/VSET100332640004/6b7df4639d864e789215ba1c32228e0c","ptime":"2017-06-23 16:12:27","img":"http://p1.img.cctvpic.com/fmspic/2017/06/23/6b7df4639d864e789215ba1c32228e0c-69.jpg?p=2&h=120","len":"00:01:54","em":"CM01"},{"vsid":"VSET100332640004","order":"15","vid":"b0c23c639d9c464ea26690be3e7e1068","t":"《当熊不让》 20170616 第十五期：\u201c奇一\u201d黑历史带动打榜新方式","url":"http://tv.cntv.cn/video/VSET100332640004/b0c23c639d9c464ea26690be3e7e1068","ptime":"2017-06-16 13:26:36","img":"http://p3.img.cctvpic.com/fmspic/2017/06/16/b0c23c639d9c464ea26690be3e7e1068-69.jpg","len":"00:01:52","em":"CM01"},{"vsid":"VSET100332640004","order":"14","vid":"f447f02add4e431290c4eb9ccbb08617","t":"《当熊不让》 20170609 第十四期：除了熊孩子，连\u201c沈王爷\u201d也上榜了！","url":"http://tv.cntv.cn/video/VSET100332640004/f447f02add4e431290c4eb9ccbb08617","ptime":"2017-06-09 11:00:26","img":"http://p3.img.cctvpic.com/fmspic/2017/06/09/f447f02add4e431290c4eb9ccbb08617-69.jpg","len":"00:01:59","em":"CM01"},{"vsid":"VSET100332640004","order":"13","vid":"4cb1b4dd83384ab3a30c39c689a404c2","t":"《当熊不让》 20170602 第十三期：宝贝，你造今天是什么日子吗？","url":"http://tv.cntv.cn/video/VSET100332640004/4cb1b4dd83384ab3a30c39c689a404c2","ptime":"2017-06-02 13:25:55","img":"http://p2.img.cctvpic.com/fmspic/2017/06/02/4cb1b4dd83384ab3a30c39c689a404c2-95.jpg","len":"00:02:50","em":"CM01"}]
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

    public static class VideosetBean {
        /**
         * 0 : {"vsid":"VSET100332640004","name":"当熊不让","img":"http://p1.img.cctvpic.com/photoAlbum/vms/standard/img/2017/3/15/VSETgpbnd9sJ0BP2qfKq00j2170315.jpg","enname":"其他","url":"http://tv.cntv.cn/videoset/VSET100332640004","cd":"","zy":"","bj":"","dy":"","js":"","nf":"","yz":"","fl":"熊猫直播","sbsj":"","sbpd":"其他","desc":"新节目《当熊不让》上线啦！每周五盘点当周最火视频和图片，让你一次看遍人气熊猫！","playdesc":"","zcr":"","fcl":""}
         * count : 19
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

        public static class _$0Bean {
            /**
             * vsid : VSET100332640004
             * name : 当熊不让
             * img : http://p1.img.cctvpic.com/photoAlbum/vms/standard/img/2017/3/15/VSETgpbnd9sJ0BP2qfKq00j2170315.jpg
             * enname : 其他
             * url : http://tv.cntv.cn/videoset/VSET100332640004
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
             * desc : 新节目《当熊不让》上线啦！每周五盘点当周最火视频和图片，让你一次看遍人气熊猫！
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

    public static class VideoBean {
        /**
         * vsid : VSET100332640004
         * order : 19
         * vid : 77ee585276254a8d920114ce312f87d1
         * t : 《当熊不让》 20170714 第十九期：热在三伏天，不服都不行
         * url : http://tv.cntv.cn/video/VSET100332640004/77ee585276254a8d920114ce312f87d1
         * ptime : 2017-07-14 13:19:43
         * img : http://p1.img.cctvpic.com/fmspic/2017/07/14/77ee585276254a8d920114ce312f87d1-79.jpg?p=2&h=120
         * len : 00:02:18
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
