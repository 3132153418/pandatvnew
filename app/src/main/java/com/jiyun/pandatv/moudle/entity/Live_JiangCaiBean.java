package com.jiyun.pandatv.moudle.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by lenovo on 2017/7/14.
 */
public class Live_JiangCaiBean {

    /**
     * videoset : {"0":{"vsid":"VSET100167216881","name":"熊猫频道-精彩一刻","img":"http://p5.img.cctvpic.com/fmspic/vms/image/2013/06/21/VSET_1371809214479325.jpg","enname":"其他","url":"http://tv.cntv.cn/videoset/VSET100167216881","cd":"","zy":"","bj":"","dy":"","js":"","nf":"","yz":"","fl":"","sbsj":"2013-05-01","sbpd":"其他","desc":"精彩一刻栏目关注人气较高的熊猫个体，精选每日直播中最吸引人的画面，呈现熊猫生活中最精彩的状态。","playdesc":"","zcr":"","fcl":""},"count":"4420"}
     * video : [{"vsid":"VSET100167216881","order":"4424","vid":"c39ef06c39314cb6a9d6c25f6527c095","t":"《精彩一刻》 20170714 照个证件照，麻烦配合一下","url":"http://tv.cntv.cn/video/VSET100167216881/c39ef06c39314cb6a9d6c25f6527c095","ptime":"2017-07-14 13:18:32","img":"http://p4.img.cctvpic.com/fmspic/2017/07/14/c39ef06c39314cb6a9d6c25f6527c095-20.jpg?p=2&h=120","len":"00:00:20","em":"CM01"},{"vsid":"VSET100167216881","order":"4423","vid":"281b47f7e82a47eba9b2bd4518463d77","t":"《精彩一刻》 20170714 乔伊：这个迪迪我不想要了！","url":"http://tv.cntv.cn/video/VSET100167216881/281b47f7e82a47eba9b2bd4518463d77","ptime":"2017-07-14 13:17:06","img":"http://p3.img.cctvpic.com/fmspic/2017/07/14/281b47f7e82a47eba9b2bd4518463d77-33.jpg?p=2&h=120","len":"00:00:45","em":"CM01"},{"vsid":"VSET100167216881","order":"4422","vid":"2a23a57914234058af994386ab372dc5","t":"《精彩一刻》 20170714 如果开心你就拍拍脚~","url":"http://tv.cntv.cn/video/VSET100167216881/2a23a57914234058af994386ab372dc5","ptime":"2017-07-14 13:16:10","img":"http://p2.img.cctvpic.com/fmspic/2017/07/14/2a23a57914234058af994386ab372dc5-33.jpg?p=2&h=120","len":"00:00:45","em":"CM01"},{"vsid":"VSET100167216881","order":"4421","vid":"bf91f6a26e644ff5b6076efc1a38dcf8","t":"《精彩一刻》 20170714 泰山果果吃竹自带遮阳伞","url":"http://tv.cntv.cn/video/VSET100167216881/bf91f6a26e644ff5b6076efc1a38dcf8","ptime":"2017-07-14 13:15:05","img":"http://p2.img.cctvpic.com/fmspic/2017/07/14/bf91f6a26e644ff5b6076efc1a38dcf8-9.jpg?p=2&h=120","len":"00:00:19","em":"CM01"},{"vsid":"VSET100167216881","order":"4419","vid":"da8b6436ea8749b2992055ebc7f22b73","t":"《精彩一刻》 20170714 总在小事上面证明自己很厉害","url":"http://tv.cntv.cn/video/VSET100167216881/da8b6436ea8749b2992055ebc7f22b73","ptime":"2017-07-14 10:00:23","img":"http://p4.img.cctvpic.com/fmspic/2017/07/14/da8b6436ea8749b2992055ebc7f22b73-50.jpg?p=2&h=120","len":"00:01:23","em":"CM01"},{"vsid":"VSET100167216881","order":"4420","vid":"8e981cf3549342719baee0a0d2ac52b3","t":"《精彩一刻》 20170714 不寻常的路可是走不通滴","url":"http://tv.cntv.cn/video/VSET100167216881/8e981cf3549342719baee0a0d2ac52b3","ptime":"2017-07-14 09:59:26","img":"http://p2.img.cctvpic.com/fmspic/2017/07/14/8e981cf3549342719baee0a0d2ac52b3-33.jpg?p=2&h=120","len":"00:00:45","em":"CM01"},{"vsid":"VSET100167216881","order":"4417","vid":"bbe666e4e7ce48cea2a70822d75aab8d","t":"《精彩一刻》 20170714 就想在浴池里泡上7x24小时","url":"http://tv.cntv.cn/video/VSET100167216881/bbe666e4e7ce48cea2a70822d75aab8d","ptime":"2017-07-14 09:58:16","img":"http://p1.img.cctvpic.com/fmspic/2017/07/14/bbe666e4e7ce48cea2a70822d75aab8d-24.jpg?p=2&h=120","len":"00:00:42","em":"CM01"}]
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
         * 0 : {"vsid":"VSET100167216881","name":"熊猫频道-精彩一刻","img":"http://p5.img.cctvpic.com/fmspic/vms/image/2013/06/21/VSET_1371809214479325.jpg","enname":"其他","url":"http://tv.cntv.cn/videoset/VSET100167216881","cd":"","zy":"","bj":"","dy":"","js":"","nf":"","yz":"","fl":"","sbsj":"2013-05-01","sbpd":"其他","desc":"精彩一刻栏目关注人气较高的熊猫个体，精选每日直播中最吸引人的画面，呈现熊猫生活中最精彩的状态。","playdesc":"","zcr":"","fcl":""}
         * count : 4420
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
             * vsid : VSET100167216881
             * name : 熊猫频道-精彩一刻
             * img : http://p5.img.cctvpic.com/fmspic/vms/image/2013/06/21/VSET_1371809214479325.jpg
             * enname : 其他
             * url : http://tv.cntv.cn/videoset/VSET100167216881
             * cd :
             * zy :
             * bj :
             * dy :
             * js :
             * nf :
             * yz :
             * fl :
             * sbsj : 2013-05-01
             * sbpd : 其他
             * desc : 精彩一刻栏目关注人气较高的熊猫个体，精选每日直播中最吸引人的画面，呈现熊猫生活中最精彩的状态。
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
         * vsid : VSET100167216881
         * order : 4424
         * vid : c39ef06c39314cb6a9d6c25f6527c095
         * t : 《精彩一刻》 20170714 照个证件照，麻烦配合一下
         * url : http://tv.cntv.cn/video/VSET100167216881/c39ef06c39314cb6a9d6c25f6527c095
         * ptime : 2017-07-14 13:18:32
         * img : http://p4.img.cctvpic.com/fmspic/2017/07/14/c39ef06c39314cb6a9d6c25f6527c095-20.jpg?p=2&h=120
         * len : 00:00:20
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
