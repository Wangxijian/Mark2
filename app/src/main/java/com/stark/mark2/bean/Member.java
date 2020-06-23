package com.stark.mark2.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Member {

    @org.greenrobot.greendao.annotation.Id
    private Long Id;
    private int Icon;
    private String Name;
    private String Organization;
    private String Position;
    @Generated(hash = 1375214891)
    public Member(Long Id, int Icon, String Name, String Organization,
            String Position) {
        this.Id = Id;
        this.Icon = Icon;
        this.Name = Name;
        this.Organization = Organization;
        this.Position = Position;
    }
    @Generated(hash = 367284327)
    public Member() {
    }
    public Long getId() {
        return this.Id;
    }
    public void setId(Long Id) {
        this.Id = Id;
    }
    public int getIcon() {
        return this.Icon;
    }
    public void setIcon(int Icon) {
        this.Icon = Icon;
    }
    public String getName() {
        return this.Name;
    }
    public void setName(String Name) {
        this.Name = Name;
    }
    public String getPosition() {
        return this.Position;
    }
    public void setPosition(String Position) {
        this.Position = Position;
    }
    public String getOrganization() {
        return this.Organization;
    }
    public void setOrganization(String Organization) {
        this.Organization = Organization;
    }

}
