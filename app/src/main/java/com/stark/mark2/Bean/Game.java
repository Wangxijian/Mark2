package com.stark.mark2.Bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class Game {

    @Generated(hash = 55394116)
    public Game(long Id, String GameName) {
        this.Id = Id;
        this.GameName = GameName;
    }
    @Generated(hash = 380959371)
    public Game() {
    }
    public long getId() {
        return this.Id;
    }
    public void setId(long Id) {
        this.Id = Id;
    }
    public String getGameName() {
        return this.GameName;
    }
    public void setGameName(String GameName) {
        this.GameName = GameName;
    }

    @Id
    private long Id;
    private String GameName;

}
