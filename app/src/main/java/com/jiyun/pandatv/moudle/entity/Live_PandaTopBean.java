package com.jiyun.pandatv.moudle.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lenovo on 2017/7/15.
 */
public class Live_PandaTopBean implements Serializable{
    private static final long serialVersionUID = 962898188802836531L;
    /**
     * videoset : {"0":{"vsid":"VSET100284428835","name":"熊猫TOP榜","img":"http://p1.img.cctvpic.com/photoAlbum/vms/standard/img/2016/8/5/VSETvxHANBMkCKTqyPatfdBz160805.jpg","enname":"其他","url":"http://tv.cntv.cn/videoset/VSET100284428835","cd":"","zy":"","bj":"","dy":"","js":"","nf":"","yz":"","fl":"","sbsj":"","sbpd":"其他","desc":"这是一档每周五更新的盘点类节目，每周盘点近期最萌、最酷、最搞笑的直播精彩画面","playdesc":"","zcr":"","fcl":""},"count":"55"}
     * video : [{"vsid":"VSET100284428835","order":"55","vid":"9a29f4991e7a48469729026e18ed9de1","t":"《熊猫TOP榜》 20170710 第二季第5期：煤炭兄妹的日常之你抢我抢","url":"http://tv.cntv.cn/video/VSET100284428835/9a29f4991e7a48469729026e18ed9de1","ptime":"2017-07-10 13:53:27","img":"http://p5.img.cctvpic.com/fmspic/2017/07/10/9a29f4991e7a48469729026e18ed9de1-129.jpg?p=2&h=120","len":"00:04:55","em":"CM01"},{"vsid":"VSET100284428835","order":"54","vid":"45f281a7e16540fd8823d67c75149d92","t":"《熊猫TOP榜》 20170703 第二季第四期：滚滚造型大赛","url":"http://tv.cntv.cn/video/VSET100284428835/45f281a7e16540fd8823d67c75149d92","ptime":"2017-07-03 14:43:25","img":"http://p5.img.cctvpic.com/fmspic/2017/07/03/45f281a7e16540fd8823d67c75149d92-129.jpg?p=2&h=120","len":"00:03:59","em":"CM01"},{"vsid":"VSET100284428835","order":"53","vid":"3998ae8b8a764b8e88e7dc7d75f331e4","t":"《熊猫TOP榜》 20170626 第二季第3期.这是一个神奇的院子","url":"http://tv.cntv.cn/video/VSET100284428835/3998ae8b8a764b8e88e7dc7d75f331e4","ptime":"2017-06-26 16:23:08","img":"http://p3.img.cctvpic.com/fmspic/2017/06/26/3998ae8b8a764b8e88e7dc7d75f331e4-129.jpg?p=2&h=120","len":"00:04:42","em":"CM01"},{"vsid":"VSET100284428835","order":"52","vid":"99fd0bb05e1d49d999048c20dc7b49b9","t":"《熊猫TOP榜》 20170619 第二季.第2期.夏天和泡澡更配哦(成片)","url":"http://tv.cntv.cn/video/VSET100284428835/99fd0bb05e1d49d999048c20dc7b49b9","ptime":"2017-06-19 14:47:12","img":"http://p4.img.cctvpic.com/fmspic/2017/06/19/99fd0bb05e1d49d999048c20dc7b49b9-129.jpg","len":"00:03:32","em":"CM01"},{"vsid":"VSET100284428835","order":"51","vid":"06ab416eb6a04d03848bb2a4bd4e6d52","t":"《熊猫TOP榜》 20170612 第二季第一期：窝头窝头请赐予我力量吧","url":"http://tv.cntv.cn/video/VSET100284428835/06ab416eb6a04d03848bb2a4bd4e6d52","ptime":"2017-06-12 15:47:04","img":"http://p1.img.cctvpic.com/fmspic/2017/06/12/06ab416eb6a04d03848bb2a4bd4e6d52-129.jpg","len":"00:04:41","em":"CM01"},{"vsid":"VSET100284428835","order":"50","vid":"2e246a096bb544d8a923c41b063c7a71","t":"《熊猫TOP榜》 20170605 第五十期 吃粽子、过儿童节 这样的熊生 巴适","url":"http://tv.cntv.cn/video/VSET100284428835/2e246a096bb544d8a923c41b063c7a71","ptime":"2017-06-05 15:39:11","img":"http://p2.img.cctvpic.com/fmspic/2017/06/05/2e246a096bb544d8a923c41b063c7a71-129.jpg","len":"00:04:40","em":"CM01"},{"vsid":"VSET100284428835","order":"49","vid":"66b6a588989a4ee7affe9f61202925f0","t":"《熊猫TOP榜》 20170529 第四十九期：卖萌和才华于一身的功夫熊猫","url":"http://tv.cntv.cn/video/VSET100284428835/66b6a588989a4ee7affe9f61202925f0","ptime":"2017-05-29 13:47:33","img":"http://p4.img.cctvpic.com/fmspic/2017/05/29/66b6a588989a4ee7affe9f61202925f0-129.jpg","len":"00:03:49","em":"CM01"}]
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
        private static final long serialVersionUID = -7906351036452243806L;
        /**
         * 0 : {"vsid":"VSET100284428835","name":"熊猫TOP榜","img":"http://p1.img.cctvpic.com/photoAlbum/vms/standard/img/2016/8/5/VSETvxHANBMkCKTqyPatfdBz160805.jpg","enname":"其他","url":"http://tv.cntv.cn/videoset/VSET100284428835","cd":"","zy":"","bj":"","dy":"","js":"","nf":"","yz":"","fl":"","sbsj":"","sbpd":"其他","desc":"这是一档每周五更新的盘点类节目，每周盘点近期最萌、最酷、最搞笑的直播精彩画面","playdesc":"","zcr":"","fcl":""}
         * count : 55
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
            private static final long serialVersionUID = 5988136547665523075L;
            /**
             * vsid : VSET100284428835
             * name : 熊猫TOP榜
             * img : http://p1.img.cctvpic.com/photoAlbum/vms/standard/img/2016/8/5/VSETvxHANBMkCKTqyPatfdBz160805.jpg
             * enname : 其他
             * url : http://tv.cntv.cn/videoset/VSET100284428835
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
             * desc : 这是一档每周五更新的盘点类节目，每周盘点近期最萌、最酷、最搞笑的直播精彩画面
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
        private static final long serialVersionUID = 961545908515414563L;
        /**
         * vsid : VSET100284428835
         * order : 55
         * vid : 9a29f4991e7a48469729026e18ed9de1
         * t : 《熊猫TOP榜》 20170710 第二季第5期：煤炭兄妹的日常之你抢我抢
         * url : http://tv.cntv.cn/video/VSET100284428835/9a29f4991e7a48469729026e18ed9de1
         * ptime : 2017-07-10 13:53:27
         * img : http://p5.img.cctvpic.com/fmspic/2017/07/10/9a29f4991e7a48469729026e18ed9de1-129.jpg?p=2&h=120
         * len : 00:04:55
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
