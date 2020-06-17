package com.stark.mark2.Bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class News {

    @Generated(hash = 2002126488)
    public News(long Id, String NewsName) {
        this.Id = Id;
        this.NewsName = NewsName;
    }

    @Generated(hash = 1579685679)
    public News() {
    }

    public long getId() {
        return this.Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public String getNewsName() {
        return this.NewsName;
    }

    public void setNewsName(String NewsName) {
        this.NewsName = NewsName;
    }

    @Id
    private long Id;

    private String NewsName;
}
