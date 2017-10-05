package com.tricast.repositories.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "LOTTERYTICKETS")
public class Account implements Serializable {

	private static final long serialVersionUID = -3370075957769037307L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "playerid")
	private Integer playerid;

	@Column(name = "lotteryDrawid")
	private Integer lotteryDrawid;

	@Column(name = "stake")
	private Integer stake;

	@Column(name = "fixNumbers")
	private String fixNumbers;

	@Column(name = "combinationNumbers")
	private String combinationNumbers;
	
	@Column(name = "createDate")
	private Date createDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getPlayerid() {
		return playerid;
	}

	public void setPlayerid(Integer playerid) {
		this.playerid = playerid;
	}

	public Integer getLotteryDrawid() {
		return lotteryDrawid;
	}

	public void setLotteryDrawid(Integer lotteryDrawid) {
		this.lotteryDrawid = lotteryDrawid;
	}

	public Integer getStake() {
		return stake;
	}

	public void setStake(Integer stake) {
		this.stake = stake;
	}

	public String getFixNumbers() {
		return fixNumbers;
	}

	public void setFixNumbers(String fixNumbers) {
		this.fixNumbers = fixNumbers;
	}

	public String getCombinationNumbers() {
		return combinationNumbers;
	}

	public void setCombinationNumbers(String combinationNumbers) {
		this.combinationNumbers = combinationNumbers;
	}
	
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	

	

	@Override
	public String toString() {
		return "LotteryTickets [id=" + id + ", playerid=" + playerid + ", lotteryDrawid=" + lotteryDrawid + ", stake=" + stake
				+ ", fixNumbers=" + fixNumbers + ", combinationNumbers=" + combinationNumbers + ", createDate=" + createDate +"]";
	}
}