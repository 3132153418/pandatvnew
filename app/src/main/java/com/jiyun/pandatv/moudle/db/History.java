package com.jiyun.pandatv.moudle.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by lenovo on 2017/7/22.
 */
@Entity

public class History {
    @Id
    private Long id;

    @Property(nameInDb = "title")
    private String title;

    @Property(nameInDb = "imageUrl")
    private String imageUrl;

    @Property(nameInDb = "voideLength")
    private String voideLength;

    @Property(nameInDb = "dayTime")
    private String dayTime;
    @Property(nameInDb = "flag")
private String flag;
    @Generated(hash = 1528993542)
    public History(Long id, String title, String imageUrl, String voideLength,
            String dayTime, String flag) {
        this.id = id;
        this.title = title;
        this.imageUrl = imageUrl;
        this.voideLength = voideLength;
        this.dayTime = dayTime;
        this.flag = flag;
    }
    @Generated(hash = 869423138)
    public History() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getImageUrl() {
        return this.imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public String getVoideLength() {
        return this.voideLength;
    }
    public void setVoideLength(String voideLength) {
        this.voideLength = voideLength;
    }
    public String getDayTime() {
        return this.dayTime;
    }
    public void setDayTime(String dayTime) {
        this.dayTime = dayTime;
    }
    public String getFlag() {
        return this.flag;
    }
    public void setFlag(String flag) {
        this.flag = flag;
    }

}
