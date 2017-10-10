package com.tricast.repositories.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "LOTTERYTICKETS")
public class LotteryTickets implements Serializable {

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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((combinationNumbers == null) ? 0 : combinationNumbers.hashCode());
        result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
        result = prime * result + ((fixNumbers == null) ? 0 : fixNumbers.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((lotteryDrawid == null) ? 0 : lotteryDrawid.hashCode());
        result = prime * result + ((playerid == null) ? 0 : playerid.hashCode());
        result = prime * result + ((stake == null) ? 0 : stake.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        LotteryTickets other = (LotteryTickets) obj;
        if (combinationNumbers == null) {
            if (other.combinationNumbers != null) {
                return false;
            }
        } else if (!combinationNumbers.equals(other.combinationNumbers)) {
            return false;
        }
        if (createDate == null) {
            if (other.createDate != null) {
                return false;
            }
        } else if (!createDate.equals(other.createDate)) {
            return false;
        }
        if (fixNumbers == null) {
            if (other.fixNumbers != null) {
                return false;
            }
        } else if (!fixNumbers.equals(other.fixNumbers)) {
            return false;
        }
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (lotteryDrawid == null) {
            if (other.lotteryDrawid != null) {
                return false;
            }
        } else if (!lotteryDrawid.equals(other.lotteryDrawid)) {
            return false;
        }
        if (playerid == null) {
            if (other.playerid != null) {
                return false;
            }
        } else if (!playerid.equals(other.playerid)) {
            return false;
        }
        if (stake == null) {
            if (other.stake != null) {
                return false;
            }
        } else if (!stake.equals(other.stake)) {
            return false;
        }
        return true;
    }

    @Override
	public String toString() {
		return "LotteryTickets [id=" + id + ", playerid=" + playerid + ", lotteryDrawid=" + lotteryDrawid + ", stake=" + stake
				+ ", fixNumbers=" + fixNumbers + ", combinationNumbers=" + combinationNumbers + ", createDate=" + createDate +"]";
	}
}