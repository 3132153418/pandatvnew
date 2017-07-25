package com.jiyun.com.day07_greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by lenovo on 2017/7/24.
 */
@Entity
public class VideoCollectBean {
    @Id
    private Long _id;

    @Property(nameInDb = "title")
    private String  title;

    @Property(nameInDb = "url")
    private String url;

    @Property(nameInDb = "urltwo")
    private String urltwo;

    @Property(nameInDb = "time")
    private String time;


    @Property(nameInDb = "img")
    private String img;


    @Property(nameInDb = "bb")
    private boolean bb;



    @Property(nameInDb = "rb")
    private boolean rb;



    @Generated(hash = 506302103)
    public VideoCollectBean(Long _id, String title, String url, String urltwo,
            String time, String img, boolean bb, boolean rb) {
        this._id = _id;
        this.title = title;
        this.url = url;
        this.urltwo = urltwo;
        this.time = time;
        this.img = img;
        this.bb = bb;
        this.rb = rb;
    }



    @Generated(hash = 905393942)
    public VideoCollectBean() {
    }



    public Long get_id() {
        return this._id;
    }



    public void set_id(Long _id) {
        this._id = _id;
    }



    public String getTitle() {
        return this.title;
    }



    public void setTitle(String title) {
        this.title = title;
    }



    public String getUrl() {
        return this.url;
    }



    public void setUrl(String url) {
        this.url = url;
    }



    public String getUrltwo() {
        return this.urltwo;
    }



    public void setUrltwo(String urltwo) {
        this.urltwo = urltwo;
    }



    public String getTime() {
        return this.time;
    }



    public void setTime(String time) {
        this.time = time;
    }



    public String getImg() {
        return this.img;
    }



    public void setImg(String img) {
        this.img = img;
    }



    public boolean getBb() {
        return this.bb;
    }



    public void setBb(boolean bb) {
        this.bb = bb;
    }



    public boolean getRb() {
        return this.rb;
    }



    public void setRb(boolean rb) {
        this.rb = rb;
    }




}
