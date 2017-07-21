package com.jiyun.pandatv.moudle.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lenovo on 2017/7/14.
 */

public class Live_JianJieBean implements Serializable{

    private static final long serialVersionUID = -3643645311105202156L;
    /**
     * live : [{"title":"成都基地高清精切线路","brief":"翻身、吃饭、睡觉、喝奶、打闹、攀爬\u2026\u2026这里是成都大熊猫繁育研究基地，24小时高清直播大熊猫生活实况的地方。成年园、幼年园、幼儿园、母子园、一号别墅，11路直播信号28个摄像头，让你零距离了解国宝们的日常起居。","image":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/1/5/1451989464985_497.jpg","id":"ipanda","isshow":"true","url":"http://live.ipanda.com/stream/"}]
     * bookmark : {"multiple":[{"title":"多视角直播","url":"http://www.ipanda.com/kehuduan/PAGE14501769230331752/PAGE14501787896813312/index.json","order":"1"}],"watchTalk":[{"title":"边看边聊","url":"zhiboye_chat","order":"1"}]}
     */

    private BookmarkBean bookmark;
    private List<LiveBean> live;

    public BookmarkBean getBookmark() {
        return bookmark;
    }

    public void setBookmark(BookmarkBean bookmark) {
        this.bookmark = bookmark;
    }

    public List<LiveBean> getLive() {
        return live;
    }

    public void setLive(List<LiveBean> live) {
        this.live = live;
    }

    public static class BookmarkBean implements Serializable{
        private static final long serialVersionUID = 4132024185788743689L;
        private List<MultipleBean> multiple;
        private List<WatchTalkBean> watchTalk;

        public List<MultipleBean> getMultiple() {
            return multiple;
        }

        public void setMultiple(List<MultipleBean> multiple) {
            this.multiple = multiple;
        }

        public List<WatchTalkBean> getWatchTalk() {
            return watchTalk;
        }

        public void setWatchTalk(List<WatchTalkBean> watchTalk) {
            this.watchTalk = watchTalk;
        }

        public static class MultipleBean implements Serializable{
            private static final long serialVersionUID = -8197320812863734386L;
            /**
             * title : 多视角直播
             * url : http://www.ipanda.com/kehuduan/PAGE14501769230331752/PAGE14501787896813312/index.json
             * order : 1
             */

            private String title;
            private String url;
            private String order;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getOrder() {
                return order;
            }

            public void setOrder(String order) {
                this.order = order;
            }
        }

        public static class WatchTalkBean implements Serializable{
            private static final long serialVersionUID = -178311961557133766L;
            /**
             * title : 边看边聊
             * url : zhiboye_chat
             * order : 1
             */

            private String title;
            private String url;
            private String order;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getOrder() {
                return order;
            }

            public void setOrder(String order) {
                this.order = order;
            }
        }
    }

    public static class LiveBean implements Serializable{
        private static final long serialVersionUID = -5105458410679432460L;
        /**
         * title : 成都基地高清精切线路
         * brief : 翻身、吃饭、睡觉、喝奶、打闹、攀爬……这里是成都大熊猫繁育研究基地，24小时高清直播大熊猫生活实况的地方。成年园、幼年园、幼儿园、母子园、一号别墅，11路直播信号28个摄像头，让你零距离了解国宝们的日常起居。
         * image : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/1/5/1451989464985_497.jpg
         * id : ipanda
         * isshow : true
         * url : http://live.ipanda.com/stream/
         */

        private String title;
        private String brief;
        private String image;
        private String id;
        private String isshow;
        private String url;

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

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getIsshow() {
            return isshow;
        }

        public void setIsshow(String isshow) {
            this.isshow = isshow;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
