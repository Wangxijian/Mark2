package com.stark.mark2.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class News implements MultiItemEntity, Parcelable {
    public static final int TYPE_IMAGE_NORMAL = 0;
    public static final int TYPE_IMAGE_NO_IMAGE = 1;

    public static final int TYPE_NEWS_HOME_1 = 0;
    public static final int TYPE_NEWS_HOME_2 = 1;
    public static final int TYPE_NEWS_HOME_3 = 2;
    public static final int TYPE_NEWS_HOME_4 = 3;
    public static final int TYPE_NEWS_PARTY_BUILDING_1 = 4;
    public static final int TYPE_NEWS_PARTY_BUILDING_2 = 5;



    public static final int TYPE_NEWS_STUDY_1 = 6;
    public static final int TYPE_NEWS_STUDY_2 = 7;
    public static final int TYPE_NEWS_STUDY_3 = 8;
    public static final int TYPE_NEWS_MANAGEMENT_1 = 9;
    public static final int TYPE_NEWS_VIDEO = 10;

    @Id
    private Long Id;
    private String NewsTitle;
    private int NewsType;
    private int ImageType;
    private String NewsSource;
    private String NewsDate;
    private String NewsContent;
    private Integer NewsImage;


    protected News(Parcel in) {
        if (in.readByte() == 0) {
            Id = null;
        } else {
            Id = in.readLong();
        }
        NewsTitle = in.readString();
        NewsType = in.readInt();
        ImageType = in.readInt();
        NewsSource = in.readString();
        NewsDate = in.readString();
        NewsContent = in.readString();
        if (in.readByte() == 0) {
            NewsImage = null;
        } else {
            NewsImage = in.readInt();
        }
    }

    @Generated(hash = 1905642235)
    public News(Long Id, String NewsTitle, int NewsType, int ImageType,
                String NewsSource, String NewsDate, String NewsContent,
                Integer NewsImage) {
        this.Id = Id;
        this.NewsTitle = NewsTitle;
        this.NewsType = NewsType;
        this.ImageType = ImageType;
        this.NewsSource = NewsSource;
        this.NewsDate = NewsDate;
        this.NewsContent = NewsContent;
        this.NewsImage = NewsImage;
    }

    @Generated(hash = 1579685679)
    public News() {
    }

    public News( String NewsTitle, int NewsType, int ImageType,
                String NewsSource, String NewsDate, String NewsContent,
                Integer NewsImage) {
        this.NewsTitle = NewsTitle;
        this.NewsType = NewsType;
        this.ImageType = ImageType;
        this.NewsSource = NewsSource;
        this.NewsDate = NewsDate;
        this.NewsContent = NewsContent;
        this.NewsImage = NewsImage;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (Id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(Id);
        }
        dest.writeString(NewsTitle);
        dest.writeInt(NewsType);
        dest.writeInt(ImageType);
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

    @Override
    public int describeContents() {
        return 0;
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

    @Override
    public int getItemType() {
        return ImageType;
    }

    public Long getId() {
        return this.Id;
    }

    public void setId(Long Id) {
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

    public int getImageType() {
        return this.ImageType;
    }

    public void setImageType(int ImageType) {
        this.ImageType = ImageType;
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
}
