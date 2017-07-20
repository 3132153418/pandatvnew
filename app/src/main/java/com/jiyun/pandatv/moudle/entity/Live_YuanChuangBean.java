package com.jiyun.pandatv.moudle.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by lenovo on 2017/7/15.
 */
public class Live_YuanChuangBean {
    /**
     * videoset : {"0":{"vsid":"VSET100219009515","name":"熊猫频道-原创新闻（高清）","img":"http://p1.img.cctvpic.com/photoAlbum/vms/standard/img/2016/7/4/VSETAjD49Q4i15Vr2gXZdlwh160704.jpg","enname":"其他","url":"http://tv.cntv.cn/videoset/VSET100219009515","cd":"","zy":"","bj":"","dy":"","js":"","nf":"","yz":"","fl":"","sbsj":"","sbpd":"其他","desc":"熊猫频道原创新闻高清内容。","playdesc":"","zcr":"","fcl":""},"count":"543"}
     * video : [{"vsid":"VSET100219009515","order":"544","vid":"2cc9ad105fb6444fa49f2f3af4507411","t":"《原创新闻》 20170711 海归大熊猫\u201c泰山\u201d12岁庆生","url":"http://tv.cntv.cn/video/VSET100219009515/2cc9ad105fb6444fa49f2f3af4507411","ptime":"2017-07-11 16:20:20","img":"http://p5.img.cctvpic.com/fmspic/2017/07/11/2cc9ad105fb6444fa49f2f3af4507411-50.jpg?p=2&h=120","len":"00:01:19","em":"CM01"},{"vsid":"VSET100219009515","order":"543","vid":"03ddb4c26db24aa7bce27368bb64e838","t":"《特别节目》 20170511 中国大熊猫保护研究\u201c九寨\u201d杯国际摄影大赛开赛","url":"http://tv.cntv.cn/video/VSET100219009515/03ddb4c26db24aa7bce27368bb64e838","ptime":"2017-05-11 16:50:16","img":"http://p5.img.cctvpic.com/fmspic/2017/05/11/03ddb4c26db24aa7bce27368bb64e838-50.jpg","len":"00:01:21","em":"CM01"},{"vsid":"VSET100219009515","order":"542","vid":"45104f84f3084adb89d7381cec35ca3e","t":"《原创新闻》 20170425 熊猫快讯：揭秘大熊猫野外引种试验的主角--大熊猫\u201c草草\u201d","url":"http://tv.cntv.cn/video/VSET100219009515/45104f84f3084adb89d7381cec35ca3e","ptime":"2017-04-25 15:46:35","img":"http://p5.img.cctvpic.com/fmspic/2017/04/25/45104f84f3084adb89d7381cec35ca3e-99.jpg","len":"00:02:57","em":"CM01"},{"vsid":"VSET100219009515","order":"541","vid":"b9c08bc697cc46d3bfe88be25038d61c","t":"《原创新闻》 20170424 熊猫快讯：揭秘大熊猫野外引种实验的主角--大熊猫\u201c草草\u201d","url":"http://tv.cntv.cn/video/VSET100219009515/b9c08bc697cc46d3bfe88be25038d61c","ptime":"2017-04-24 17:41:23","img":"http://p2.img.cctvpic.com/fmspic/2017/04/24/b9c08bc697cc46d3bfe88be25038d61c-99.jpg","len":"00:02:57","em":"CM01"},{"vsid":"VSET100219009515","order":"540","vid":"cf45853a519e4479918b8e37c898613b","t":"《原创新闻》 20170424 熊猫快讯：我国首次大熊猫野外引种试验取得初步成效","url":"http://tv.cntv.cn/video/VSET100219009515/cf45853a519e4479918b8e37c898613b","ptime":"2017-04-24 17:40:02","img":"http://p5.img.cctvpic.com/fmspic/2017/04/24/cf45853a519e4479918b8e37c898613b-69.jpg","len":"00:01:53","em":"CM01"},{"vsid":"VSET100219009515","order":"539","vid":"6ea9d70751294e778eab22fc145b62b4","t":"《原创新闻》 20170412 熊猫快讯：大熊猫\u201c武雯\u201d\u201c星雅\u201d开启荷兰之旅","url":"http://tv.cntv.cn/video/VSET100219009515/6ea9d70751294e778eab22fc145b62b4","ptime":"2017-04-12 18:43:01","img":"http://p4.img.cctvpic.com/fmspic/2017/04/12/6ea9d70751294e778eab22fc145b62b4-80.jpg","len":"00:02:19","em":"CM01"},{"vsid":"VSET100219009515","order":"538","vid":"21140ae508ad4043aefd8b90d31af358","t":"《原创新闻》 20170325 熊猫快讯：大熊猫\u201c宝宝\u201d入住新家","url":"http://tv.cntv.cn/video/VSET100219009515/21140ae508ad4043aefd8b90d31af358","ptime":"2017-03-25 15:41:42","img":"http://p4.img.cctvpic.com/fmspic/2017/03/25/21140ae508ad4043aefd8b90d31af358-50.jpg","len":"00:01:27","em":"CM01"}]
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
         * 0 : {"vsid":"VSET100219009515","name":"熊猫频道-原创新闻（高清）","img":"http://p1.img.cctvpic.com/photoAlbum/vms/standard/img/2016/7/4/VSETAjD49Q4i15Vr2gXZdlwh160704.jpg","enname":"其他","url":"http://tv.cntv.cn/videoset/VSET100219009515","cd":"","zy":"","bj":"","dy":"","js":"","nf":"","yz":"","fl":"","sbsj":"","sbpd":"其他","desc":"熊猫频道原创新闻高清内容。","playdesc":"","zcr":"","fcl":""}
         * count : 543
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
             * vsid : VSET100219009515
             * name : 熊猫频道-原创新闻（高清）
             * img : http://p1.img.cctvpic.com/photoAlbum/vms/standard/img/2016/7/4/VSETAjD49Q4i15Vr2gXZdlwh160704.jpg
             * enname : 其他
             * url : http://tv.cntv.cn/videoset/VSET100219009515
             * cd :
             * zy :
             * bj :
             * dy :
             * js :
             * nf :
             * yz :
             * fl :
             * sbsj :
             * sbpd : 其他
             * desc : 熊猫频道原创新闻高清内容。
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
         * vsid : VSET100219009515
         * order : 544
         * vid : 2cc9ad105fb6444fa49f2f3af4507411
         * t : 《原创新闻》 20170711 海归大熊猫“泰山”12岁庆生
         * url : http://tv.cntv.cn/video/VSET100219009515/2cc9ad105fb6444fa49f2f3af4507411
         * ptime : 2017-07-11 16:20:20
         * img : http://p5.img.cctvpic.com/fmspic/2017/07/11/2cc9ad105fb6444fa49f2f3af4507411-50.jpg?p=2&h=120
         * len : 00:01:19
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
