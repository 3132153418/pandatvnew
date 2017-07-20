package com.jiyun.pandatv.moudle.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by lenovo on 2017/7/15.
 */
public class Live_TeBieJieMuBean {
    /**
     * videoset : {"0":{"vsid":"VSET100167308855","name":"熊猫频道-特别节目","img":"http://p1.img.cctvpic.com/fmspic/vms/image/2013/06/21/VSET_1371809044488847.jpg","enname":"其他","url":"http://tv.cntv.cn/videoset/VSET100167308855","cd":"","zy":"","bj":"","dy":"","js":"","nf":"","yz":"","fl":"熊猫直播","sbsj":"2013-05-01","sbpd":"其他","desc":"熊猫频道采访野生动物保护专家、熊猫守护使、到访基地的名人，以人类的角度展现熊猫世界。","playdesc":"","zcr":"","fcl":""},"count":"246"}
     * video : [{"vsid":"VSET100167308855","order":"240","vid":"241dff898424469e98196f8b38fad15a","t":"《萌！遍地\u201c国宝\u201d亮相都江堰巡游》 20170708","url":"http://tv.cntv.cn/video/VSET100167308855/241dff898424469e98196f8b38fad15a","ptime":"2017-07-08 11:22:50","img":"http://p3.img.cctvpic.com/fmspic/2017/07/08/241dff898424469e98196f8b38fad15a-1392.jpg?p=2&h=120","len":"00:46:45","em":"CM01"},{"vsid":"VSET100167308855","order":"239","vid":"7f8bd4ba2a6b4281b364b24b72c4bbc2","t":"《特别节目》 20170706 最萌外交官\u2014\u2014\u201c梦梦\u201d\u201c娇庆\u201d开启新生活","url":"http://tv.cntv.cn/video/VSET100167308855/7f8bd4ba2a6b4281b364b24b72c4bbc2","ptime":"2017-07-06 11:58:05","img":"http://p4.img.cctvpic.com/fmspic/2017/07/06/7f8bd4ba2a6b4281b364b24b72c4bbc2-50.jpg?p=2&h=120","len":"00:01:39","em":"CM01"},{"vsid":"VSET100167308855","order":"238","vid":"259ede2d6f37479c8cb5e66f5cdd24f2","t":"《大熊猫舌尖上的窝窝头》 20170621","url":"http://tv.cntv.cn/video/VSET100167308855/259ede2d6f37479c8cb5e66f5cdd24f2","ptime":"2017-06-21 11:34:15","img":"http://p1.img.cctvpic.com/fmspic/2017/06/21/259ede2d6f37479c8cb5e66f5cdd24f2-2467.jpg?p=2&h=120","len":"00:41:07","em":"CM01"},{"vsid":"VSET100167308855","order":"237","vid":"4a83f88c5c1f4a04a734125955ab8c8c","t":"《熊猫特别节目》 20170606 关注旅日大熊猫回国","url":"http://tv.cntv.cn/video/VSET100167308855/4a83f88c5c1f4a04a734125955ab8c8c","ptime":"2017-06-06 11:19:01","img":"http://p4.img.cctvpic.com/fmspic/2017/06/06/4a83f88c5c1f4a04a734125955ab8c8c-130.jpg","len":"00:05:24","em":"CM01"},{"vsid":"VSET100167308855","order":"236","vid":"3d0d1a5e92a246158a20ab38c3c46290","t":"《在现场》 20170531 海归大熊猫\u201c宝宝\u201d的早晨","url":"http://tv.cntv.cn/video/VSET100167308855/3d0d1a5e92a246158a20ab38c3c46290","ptime":"2017-05-31 11:52:50","img":"http://p3.img.cctvpic.com/fmspic/2017/05/31/3d0d1a5e92a246158a20ab38c3c46290-2497.jpg","len":"00:41:37","em":"CM01"},{"vsid":"VSET100167308855","order":"235","vid":"96f68d3251de48fd9aed2366e88cbe00","t":"《特别节目》 20170530 端午特辑：熊猫三胞胎吃粽子比赛","url":"http://tv.cntv.cn/video/VSET100167308855/96f68d3251de48fd9aed2366e88cbe00","ptime":"2017-05-30 15:09:38","img":"http://p4.img.cctvpic.com/fmspic/2017/05/30/96f68d3251de48fd9aed2366e88cbe00-81.jpg","len":"00:02:21","em":"CM01"},{"vsid":"VSET100167308855","order":"234","vid":"3751a0c5b1fe432a9a10ad77c203d163","t":"《特别节目》 20170523 2017年全球首对圈养大熊猫双胞胎顺利诞生","url":"http://tv.cntv.cn/video/VSET100167308855/3751a0c5b1fe432a9a10ad77c203d163","ptime":"2017-05-23 16:06:49","img":"http://p5.img.cctvpic.com/fmspic/2017/05/23/3751a0c5b1fe432a9a10ad77c203d163-81.jpg","len":"00:02:21","em":"CM01"}]
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
         * 0 : {"vsid":"VSET100167308855","name":"熊猫频道-特别节目","img":"http://p1.img.cctvpic.com/fmspic/vms/image/2013/06/21/VSET_1371809044488847.jpg","enname":"其他","url":"http://tv.cntv.cn/videoset/VSET100167308855","cd":"","zy":"","bj":"","dy":"","js":"","nf":"","yz":"","fl":"熊猫直播","sbsj":"2013-05-01","sbpd":"其他","desc":"熊猫频道采访野生动物保护专家、熊猫守护使、到访基地的名人，以人类的角度展现熊猫世界。","playdesc":"","zcr":"","fcl":""}
         * count : 246
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
             * vsid : VSET100167308855
             * name : 熊猫频道-特别节目
             * img : http://p1.img.cctvpic.com/fmspic/vms/image/2013/06/21/VSET_1371809044488847.jpg
             * enname : 其他
             * url : http://tv.cntv.cn/videoset/VSET100167308855
             * cd :
             * zy :
             * bj :
             * dy :
             * js :
             * nf :
             * yz :
             * fl : 熊猫直播
             * sbsj : 2013-05-01
             * sbpd : 其他
             * desc : 熊猫频道采访野生动物保护专家、熊猫守护使、到访基地的名人，以人类的角度展现熊猫世界。
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
         * vsid : VSET100167308855
         * order : 240
         * vid : 241dff898424469e98196f8b38fad15a
         * t : 《萌！遍地“国宝”亮相都江堰巡游》 20170708
         * url : http://tv.cntv.cn/video/VSET100167308855/241dff898424469e98196f8b38fad15a
         * ptime : 2017-07-08 11:22:50
         * img : http://p3.img.cctvpic.com/fmspic/2017/07/08/241dff898424469e98196f8b38fad15a-1392.jpg?p=2&h=120
         * len : 00:46:45
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
