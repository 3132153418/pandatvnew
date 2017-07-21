package com.jiyun.pandatv.moudle.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lenovo on 2017/7/14.
 */

public class Paper_DataBean implements Serializable{

    private static final long serialVersionUID = 620885294629714755L;
    /**
     * total : 1397
     * list : [{"num":1,"datatype":"video","id":"VIDE3nvhC9JsVSQRD5GB8z7H170713","title":"三伏天大熊猫怎么过？ \u201c水果冰\u201d来帮忙","videolength":"00:00:46","guid":"34727fc62dcb40a8ad1b3463ab23d69e","picurl":"http://p1.img.cctvpic.com/fmspic/2017/07/13/8d2c9797a19647f7a9c14db6201362e0-46.jpg?p=2&h=120","picurl2":"http://p1.img.cctvpic.com/fmspic/2017/07/13/8d2c9797a19647f7a9c14db6201362e0-46.jpg?p=2&h=120","picurl3":"http://p1.img.cctvpic.com/fmspic/2017/07/13/8d2c9797a19647f7a9c14db6201362e0-33.jpg?p=2&h=120","url":"http://panview.ipanda.com/2017/07/13/VIDE3nvhC9JsVSQRD5GB8z7H170713.shtml","focus_date":1499911023000},{"num":2,"datatype":"video","id":"VIDEWCOTf7E0UKQftwkS4xVk170712","title":"海归大熊猫\u201c泰山\u201d迎来12岁生日","videolength":"00:01:11","guid":"a918c3a443754c23b670cbea98c8a17b","picurl":"http://p4.img.cctvpic.com/fmspic/2017/07/11/b5a10100139c4b70b104f41ff4355afb-71.jpg?p=2&h=120","picurl2":"http://p3.img.cctvpic.com/fmspic/2017/07/11/b5a10100139c4b70b104f41ff4355afb-19.jpg?p=2&h=120","picurl3":"http://p4.img.cctvpic.com/fmspic/2017/07/11/b5a10100139c4b70b104f41ff4355afb-71.jpg?p=2&h=120","url":"http://panview.ipanda.com/2017/07/12/VIDEWCOTf7E0UKQftwkS4xVk170712.shtml","focus_date":1499822583000},{"num":3,"datatype":"video","id":"VIDECQ2RllONuFb1G3II7uwV170712","title":"重庆大熊猫龙凤胎周岁 双胞胎宝宝祝贺生日","videolength":"00:00:57","guid":"8eae800e06f948778263603a7225fc5e","picurl":"http://p4.img.cctvpic.com/fmspic/2017/07/11/21185c2426763de2868d29630a4e5c44-57.jpg?p=2&h=120","picurl2":"http://p4.img.cctvpic.com/fmspic/2017/07/11/21185c2426763de2868d29630a4e5c44-57.jpg?p=2&h=120","picurl3":"http://p2.img.cctvpic.com/fmspic/2017/07/11/21185c2426763de2868d29630a4e5c44-19.jpg?p=2&h=120","url":"http://panview.ipanda.com/2017/07/12/VIDECQ2RllONuFb1G3II7uwV170712.shtml","focus_date":1499822582000},{"num":4,"datatype":"video","id":"VIDEoI3rPh15MbpWJZgMNaXC170711","title":"山东青岛\u201c脱毛裤\u201d大熊猫成\u201c网红\u201d","videolength":"00:02:16","guid":"7736c7d1ea864ba8b7a23ae0946069c3","picurl":"http://p4.img.cctvpic.com/fmspic/2017/07/10/1562d428616c4f489c56101b17659f05-136.jpg?p=2&h=120","picurl2":"http://p2.img.cctvpic.com/fmspic/2017/07/10/1562d428616c4f489c56101b17659f05-20.jpg?p=2&h=120","picurl3":"http://p4.img.cctvpic.com/fmspic/2017/07/10/1562d428616c4f489c56101b17659f05-136.jpg?p=2&h=120","url":"http://panview.ipanda.com/2017/07/11/VIDEoI3rPh15MbpWJZgMNaXC170711.shtml","focus_date":1499736183000},{"num":5,"datatype":"video","id":"VIDEmS6EB1xaQq8Hm8CGnYT6170707","title":"在台大熊猫圆仔4岁啦","videolength":"00:01:31","guid":"94717a13991f42a18f02255552688440","picurl":"http://p2.img.cctvpic.com/fmspic/2017/07/07/1bd191d3511b4c7689e6dd8eda945235-50.jpg?p=2&h=120","picurl2":"http://p2.img.cctvpic.com/fmspic/2017/07/07/1bd191d3511b4c7689e6dd8eda945235-91.jpg?p=2&h=120","picurl3":"http://p2.img.cctvpic.com/fmspic/2017/07/07/1bd191d3511b4c7689e6dd8eda945235-50.jpg?p=2&h=120","url":"http://panview.ipanda.com/2017/07/07/VIDEmS6EB1xaQq8Hm8CGnYT6170707.shtml","focus_date":1499421898000},{"num":6,"datatype":"video","id":"VIDEOkAIB9KCE1zTjcFzbpnM170707","title":"赠台大熊猫后代\u201c圆仔\u201d迎来四岁生日","videolength":"00:01:50","guid":"a29167b25acd45189201d07a9637248e","picurl":"http://p3.img.cctvpic.com/fmspic/2017/07/06/351ea24222a43de2868d29630a4e5c44-112.jpg?p=2&h=120","picurl2":"http://p3.img.cctvpic.com/fmspic/2017/07/06/351ea24222a43de2868d29630a4e5c44-112.jpg?p=2&h=120","picurl3":"http://p3.img.cctvpic.com/fmspic/2017/07/06/351ea24222a43de2868d29630a4e5c44-72.jpg?p=2&h=120","url":"http://panview.ipanda.com/2017/07/07/VIDEOkAIB9KCE1zTjcFzbpnM170707.shtml","focus_date":1499389018000},{"num":7,"datatype":"video","id":"VIDEhbyl2JRsCgcSCLc2fuZK170707","title":"四川都江堰红外线相机拍到野生大熊猫\u201c圈地\u201d","videolength":"00:00:57","guid":"7934d5458c69415083c3cd1a50478531","picurl":"http://p4.img.cctvpic.com/fmspic/2017/07/06/762e42d977534f7e8cb80be9e2ef8a35-39.jpg?p=2&h=120","picurl2":"http://p4.img.cctvpic.com/fmspic/2017/07/06/762e42d977534f7e8cb80be9e2ef8a35-57.jpg?p=2&h=120","picurl3":"http://p4.img.cctvpic.com/fmspic/2017/07/06/762e42d977534f7e8cb80be9e2ef8a35-39.jpg?p=2&h=120","url":"http://panview.ipanda.com/2017/07/07/VIDEhbyl2JRsCgcSCLc2fuZK170707.shtml","focus_date":1499389018000},{"num":8,"datatype":"video","id":"VIDEAOGMrWPBvl7USdqjDgY4170706","title":"茁壮！旅日大熊猫幼崽体重倍增 黑白分明显萌态","videolength":"00:00:31","guid":"61a52d48526c48b5bd76309dd295de90","picurl":"http://p3.img.cctvpic.com/fmspic/2017/07/05/f1fc961663c944808aa3b025ab88838e-21.jpg?p=2&h=120","picurl2":"http://p3.img.cctvpic.com/fmspic/2017/07/05/f1fc961663c944808aa3b025ab88838e-31.jpg?p=2&h=120","picurl3":"http://p3.img.cctvpic.com/fmspic/2017/07/05/f1fc961663c944808aa3b025ab88838e-21.jpg?p=2&h=120","url":"http://panview.ipanda.com/2017/07/06/VIDEAOGMrWPBvl7USdqjDgY4170706.shtml","focus_date":1499300337000},{"num":9,"datatype":"video","id":"VIDEA4VjyLW9nKnkVctQB9cb170705","title":"赠台大熊猫\u201c圆圆\u201d 出现怀孕迹象 7月中旬再确定","videolength":"00:01:29","guid":"2fb204a514664edf85845a1b336581ce","picurl":"http://p5.img.cctvpic.com/fmspic/2017/07/04/62d2652fbb1049ccb04c2fc8e6e26292-50.jpg?p=2&h=120","picurl2":"http://p5.img.cctvpic.com/fmspic/2017/07/04/62d2652fbb1049ccb04c2fc8e6e26292-89.jpg?p=2&h=120","picurl3":"http://p5.img.cctvpic.com/fmspic/2017/07/04/62d2652fbb1049ccb04c2fc8e6e26292-50.jpg?p=2&h=120","url":"http://panview.ipanda.com/2017/07/05/VIDEA4VjyLW9nKnkVctQB9cb170705.shtml","focus_date":1499218136000},{"num":10,"datatype":"video","id":"VIDESlSEU337fbmXlUuv2je0170704","title":"大熊猫现身四川凉山冕宁 憨态可掬惹人爱","videolength":"00:01:23","guid":"f8baf3eb80dd4de9b238933236c7765c","picurl":"http://p1.img.cctvpic.com/fmspic/2017/07/03/6684f1c15f5a4e5e8191e68974657069-83.jpg?p=2&h=120","picurl2":"http://p1.img.cctvpic.com/fmspic/2017/07/03/6684f1c15f5a4e5e8191e68974657069-83.jpg?p=2&h=120","picurl3":"http://p1.img.cctvpic.com/fmspic/2017/07/03/6684f1c15f5a4e5e8191e68974657069-50.jpg?p=2&h=120","url":"http://panview.ipanda.com/2017/07/04/VIDESlSEU337fbmXlUuv2je0170704.shtml","focus_date":1499134855000},{"num":11,"datatype":"video","id":"VIDEku7z8L1un769i1rCDq5C170630","title":"居港大熊猫的\u201c港漂\u201d生活：懂得三种语言","videolength":"00:00:45","guid":"51fd279f3a514729840e1b8bb513c4e0","picurl":"http://p3.img.cctvpic.com/fmspic/2017/06/23/40cdd42736dc44169a4b1d94d1ecf498-45.jpg?p=2&h=120","picurl2":"http://p3.img.cctvpic.com/fmspic/2017/06/23/40cdd42736dc44169a4b1d94d1ecf498-45.jpg?p=2&h=120","picurl3":"http://p3.img.cctvpic.com/fmspic/2017/06/23/40cdd42736dc44169a4b1d94d1ecf498-32.jpg?p=2&h=120","url":"http://panview.ipanda.com/2017/06/30/VIDEku7z8L1un769i1rCDq5C170630.shtml","focus_date":1498789492000},{"num":12,"datatype":"video","id":"VIDEY7xElimJ9RNCCuUVonep170630","title":"旅德大熊猫日记之\u201c新家五分好评\u201d","videolength":"00:00:44","guid":"f1e853d0686d48b0a47d70b92ae31a1f","picurl":"http://p5.img.cctvpic.com/fmspic/2017/06/29/26bb01cff52e44e5aed91ab648352a7f-32.jpg?p=2&h=120","picurl2":"http://p5.img.cctvpic.com/fmspic/2017/06/29/26bb01cff52e44e5aed91ab648352a7f-44.jpg?p=2&h=120","picurl3":"http://p5.img.cctvpic.com/fmspic/2017/06/29/26bb01cff52e44e5aed91ab648352a7f-32.jpg?p=2&h=120","url":"http://panview.ipanda.com/2017/06/30/VIDEY7xElimJ9RNCCuUVonep170630.shtml","focus_date":1498789132000}]
     */

    private int total;
    private List<ListBean> list;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean implements Serializable{
        private static final long serialVersionUID = 6514141581131984793L;
        /**
         * num : 1
         * datatype : video
         * id : VIDE3nvhC9JsVSQRD5GB8z7H170713
         * title : 三伏天大熊猫怎么过？ “水果冰”来帮忙
         * videolength : 00:00:46
         * guid : 34727fc62dcb40a8ad1b3463ab23d69e
         * picurl : http://p1.img.cctvpic.com/fmspic/2017/07/13/8d2c9797a19647f7a9c14db6201362e0-46.jpg?p=2&h=120
         * picurl2 : http://p1.img.cctvpic.com/fmspic/2017/07/13/8d2c9797a19647f7a9c14db6201362e0-46.jpg?p=2&h=120
         * picurl3 : http://p1.img.cctvpic.com/fmspic/2017/07/13/8d2c9797a19647f7a9c14db6201362e0-33.jpg?p=2&h=120
         * url : http://panview.ipanda.com/2017/07/13/VIDE3nvhC9JsVSQRD5GB8z7H170713.shtml
         * focus_date : 1499911023000
         */

        private int num;
        private String datatype;
        private String id;
        private String title;
        private String videolength;
        private String guid;
        private String picurl;
        private String picurl2;
        private String picurl3;
        private String url;
        private long focus_date;

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public String getDatatype() {
            return datatype;
        }

        public void setDatatype(String datatype) {
            this.datatype = datatype;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getVideolength() {
            return videolength;
        }

        public void setVideolength(String videolength) {
            this.videolength = videolength;
        }

        public String getGuid() {
            return guid;
        }

        public void setGuid(String guid) {
            this.guid = guid;
        }

        public String getPicurl() {
            return picurl;
        }

        public void setPicurl(String picurl) {
            this.picurl = picurl;
        }

        public String getPicurl2() {
            return picurl2;
        }

        public void setPicurl2(String picurl2) {
            this.picurl2 = picurl2;
        }

        public String getPicurl3() {
            return picurl3;
        }

        public void setPicurl3(String picurl3) {
            this.picurl3 = picurl3;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public long getFocus_date() {
            return focus_date;
        }

        public void setFocus_date(long focus_date) {
            this.focus_date = focus_date;
        }
    }
}
