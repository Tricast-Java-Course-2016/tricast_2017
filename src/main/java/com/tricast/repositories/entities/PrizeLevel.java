package com.tricast.repositories.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRIZELEVELS")
public class PrizeLevel implements Serializable, Comparable<PrizeLevel> {

    private static final long serialVersionUID = -3370075957769037307L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "lotterydrawid")
    Integer lotterydrawid;

    @Column(name = "winningpercentage")
    Integer winningpercentage;

    @Column(name = "level")
    Integer level;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLotterydrawid() {
        return lotterydrawid;
    }

    public void setLotterydrawid(Integer lotterydrawid) {
        this.lotterydrawid = lotterydrawid;
    }

    public Integer getWinningpercentage() {
        return winningpercentage;
    }

    public void setWinningpercentage(Integer winningpercentage) {
        this.winningpercentage = winningpercentage;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "PrizeLevel [id=" + id + ", lotterydrawid=" + lotterydrawid + ", winningpercentage=" + winningpercentage
                + ", level=" + level + "]";
    }

    @Override
    public int compareTo(PrizeLevel o) {
        return this.getLevel().compareTo(o.getLevel());
    }

}
