package com.jiyun.pandatv.moudle.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/7/20.
 */

public class GGliveBean implements Serializable{

    private List<BigImgBean> bigImg;
    private List<ListBean> list;

    public List<BigImgBean> getBigImg() {
        return bigImg;
    }

    public void setBigImg(List<BigImgBean> bigImg) {
        this.bigImg = bigImg;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class BigImgBean implements Serializable{
        /**
         * url : http://culture.ipanda.com/2017/05/23/ARTILBLSMq3qlVgygrUMJEG2170523.shtml
         * image : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2017/5/23/1495533604076_403.jpg
         * title : 一碗简单的热干面，吃的也是仪式感
         * id : ARTILBLSMq3qlVgygrUMJEG2170523
         * type : 5
         * stype :
         * pid :
         * vid :
         * order : 1
         */

        private String url;
        private String image;
        private String title;
        private String id;
        private String type;
        private String stype;
        private String pid;
        private String vid;
        private String order;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getStype() {
            return stype;
        }

        public void setStype(String stype) {
            this.stype = stype;
        }

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public String getVid() {
            return vid;
        }

        public void setVid(String vid) {
            this.vid = vid;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }
    }

    public static class ListBean implements Serializable{
        /**
         * url :
         * image : http://p5.img.cctvpic.com/fmspic/2016/10/19/84f27011346547c595d78b47a48eb6de-129.jpg
         * title : 戏曲动画路《牡丹亭路惊梦》
         * brief : 本期节目主要内容：    因教书先生教授了《诗经》中“关关雎鸠，在河之洲；窈窕淑女，君子好逑。”之词
         * type : 2
         * videoLength : 03:33
         * id : VSET100311356635
         * order : 1
         */

        private String url;
        private String image;
        private String title;
        private String brief;
        private String type;
        private String videoLength;
        private String id;
        private String order;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getBrief() {
            return brief;
        }

        public void setBrief(String brief) {
            this.brief = brief;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getVideoLength() {
            return videoLength;
        }

        public void setVideoLength(String videoLength) {
            this.videoLength = videoLength;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }
    }
}
