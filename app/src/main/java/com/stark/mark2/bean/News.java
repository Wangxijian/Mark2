package com.stark.mark2.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class News implements MultiItemEntity , Parcelable {
    public static final int TYPE_NORMAL = 0;
    public static final int TYPE_NO_IMAGE = 1;
    @Id
    private long Id;
    private String NewsTitle;
    private int NewsType;
    private String NewsSource;
    private String NewsDate;
    private String NewsContent;
    private Integer NewsImage;

    @Generated(hash = 1893778754)
    public News(long Id, String NewsTitle, int NewsType, String NewsSource,
            String NewsDate, String NewsContent, Integer NewsImage) {
        this.Id = Id;
        this.NewsTitle = NewsTitle;
        this.NewsType = NewsType;
        this.NewsSource = NewsSource;
        this.NewsDate = NewsDate;
        this.NewsContent = NewsContent;
        this.NewsImage = NewsImage;
    }

    @Generated(hash = 1579685679)
    public News() {
    }

    protected News(Parcel in) {
        Id = in.readLong();
        NewsTitle = in.readString();
        NewsType = in.readInt();
        NewsSource = in.readString();
        NewsDate = in.readString();
        NewsContent = in.readString();
        if (in.readByte() == 0) {
            NewsImage = null;
        } else {
            NewsImage = in.readInt();
        }
    }

    public static final Creator<News> CREATOR = new Creator<News>() {
        @Override
        public News createFromParcel(Parcel in) {
            return new News(in);
        }

        @Override
        public News[] newArray(int size) {
            return new News[size];
        }
    };

    public long getId() {
        return this.Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }


    public String getNewsTitle() {
        return this.NewsTitle;
    }

    public void setNewsTitle(String NewsTitle) {
        this.NewsTitle = NewsTitle;
    }

    public int getNewsType() {
        return this.NewsType;
    }

    public void setNewsType(int NewsType) {
        this.NewsType = NewsType;
    }

    public String getNewsSource() {
        return this.NewsSource;
    }

    public void setNewsSource(String NewsSource) {
        this.NewsSource = NewsSource;
    }

    public String getNewsDate() {
        return this.NewsDate;
    }

    public void setNewsDate(String NewsDate) {
        this.NewsDate = NewsDate;
    }

    public String getNewsContent() {
        return this.NewsContent;
    }

    public void setNewsContent(String NewsContent) {
        this.NewsContent = NewsContent;
    }

    public Integer getNewsImage() {
        return this.NewsImage;
    }

    public void setNewsImage(Integer NewsImage) {
        this.NewsImage = NewsImage;
    }

    @Override
    public int getItemType() {
        return NewsType;
    }

    @Override
    public String toString() {
        return "News{" +
                "Id=" + Id +
                ", NewsTitle='" + NewsTitle + '\'' +
                ", NewsType=" + NewsType +
                ", NewsSource='" + NewsSource + '\'' +
                ", NewsDate='" + NewsDate + '\'' +
                ", NewsContent='" + NewsContent + '\'' +
                ", NewsImage=" + NewsImage +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(Id);
        dest.writeString(NewsTitle);
        dest.writeInt(NewsType);
        dest.writeString(NewsSource);
        dest.writeString(NewsDate);
        dest.writeString(NewsContent);
        if (NewsImage == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(NewsImage);
        }
    }
}
