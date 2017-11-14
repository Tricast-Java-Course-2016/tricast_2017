package com.tricast.repositories.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SINGLESELECTIONS")
public class SingleSelection implements Serializable {

    private static final long serialVersionUID = -3370075957769037307L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "winningAmount")
    private Integer winningAmount;

    @Column(name = "selection")
    private String selection;

    @Column(name = "lotteryTicketid")
    private Integer lotteryTicketid;

    @Column(name = "prizeLevelid")
    private Long prizeLevelid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getWinningAmount() {
        return winningAmount;
    }

    public void setWinningAmount(Integer winningAmount) {
        this.winningAmount = winningAmount;
    }

    public String getSelection() {
        return selection;
    }

    public void setSelection(String selection) {
        this.selection = selection;
    }

    public Integer getLotteryTicketid() {
        return lotteryTicketid;
    }

    public void setLotteryTicketid(Integer lotteryTicketid) {
        this.lotteryTicketid = lotteryTicketid;
    }

    public Long getPrizeLevelid() {
        return prizeLevelid;
    }

    public void setPrizeLevelid(Long prizeLevelid) {
        this.prizeLevelid = prizeLevelid;
    }

    @Override
    public String toString() {
        return "SingleSelection [id=" + id + ", winningAmount=" + winningAmount + ", selection=" + selection
                + ", lotteryTicketid=" + lotteryTicketid
                + ", prizeLevelid=" + prizeLevelid + "]";
    }
}