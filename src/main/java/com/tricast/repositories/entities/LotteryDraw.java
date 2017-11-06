package com.tricast.repositories.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "lotterydraws")
public class LotteryDraw implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 6652648022347822854L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "basestake")
	private Integer baseStake;

	@Column(name = "gridsize")
	private Integer gridSize;

	@Column(name = "numbersdrawn")
	private Integer numbersDrawn;

	@Column(name = "nrofgrids")
	private Integer nrOfGrids;

	@Column(name = "minnroffox")
	private Integer minNrOfFox;

	@Column(name = "maxnroffix")
	private Integer maxNrOfFix;

	@Column(name = "maxnrofcombination")
	private Integer maxNrOfCombination;

	@Column(name = "year")
	private String year;

	@Column(name = "week")
	private String week;

	@Column(name = "status")
	private String status;

	@Column(name = "winningnumbers")
	private String winningNumbers;

	@ManyToOne
	@JoinColumn(name = "lotterygameid")
	private LotteryGame lotteryGame;

	@Column(name = "createddate")
	private Date createdDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getBaseStake() {
		return baseStake;
	}

	public void setBaseStake(Integer baseStake) {
		this.baseStake = baseStake;
	}

	public Integer getGridSize() {
		return gridSize;
	}

	public void setGridSize(Integer gridSize) {
		this.gridSize = gridSize;
	}

	public Integer getNumbersDrawn() {
		return numbersDrawn;
	}

	public void setNumbersDrawn(Integer numbersDrawn) {
		this.numbersDrawn = numbersDrawn;
	}

	public Integer getNrOfGrids() {
		return nrOfGrids;
	}

	public void setNrOfGrids(Integer nrOfGrids) {
		this.nrOfGrids = nrOfGrids;
	}

	public Integer getMinNrOfFox() {
		return minNrOfFox;
	}

	public void setMinNrOfFox(Integer minNrOfFox) {
		this.minNrOfFox = minNrOfFox;
	}

	public Integer getMaxNrOfFix() {
		return maxNrOfFix;
	}

	public void setMaxNrOfFix(Integer maxNrOfFix) {
		this.maxNrOfFix = maxNrOfFix;
	}

	public Integer getMaxNrOfCombination() {
		return maxNrOfCombination;
	}

	public void setMaxNrOfCombination(Integer maxNrOfCombination) {
		this.maxNrOfCombination = maxNrOfCombination;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getWinningNumbers() {
		return winningNumbers;
	}

	public void setWinningNumbers(String winningNumbers) {
		this.winningNumbers = winningNumbers;
	}

	public LotteryGame getLotteryGame() {
		return lotteryGame;
	}

	public void setLotteryGame(LotteryGame lotteryGame) {
		this.lotteryGame = lotteryGame;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((baseStake == null) ? 0 : baseStake.hashCode());
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + ((gridSize == null) ? 0 : gridSize.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lotteryGame == null) ? 0 : lotteryGame.hashCode());
		result = prime * result + ((maxNrOfCombination == null) ? 0 : maxNrOfCombination.hashCode());
		result = prime * result + ((maxNrOfFix == null) ? 0 : maxNrOfFix.hashCode());
		result = prime * result + ((minNrOfFox == null) ? 0 : minNrOfFox.hashCode());
		result = prime * result + ((nrOfGrids == null) ? 0 : nrOfGrids.hashCode());
		result = prime * result + ((numbersDrawn == null) ? 0 : numbersDrawn.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((week == null) ? 0 : week.hashCode());
		result = prime * result + ((winningNumbers == null) ? 0 : winningNumbers.hashCode());
		result = prime * result + ((year == null) ? 0 : year.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LotteryDraw other = (LotteryDraw) obj;
		if (baseStake == null) {
			if (other.baseStake != null)
				return false;
		} else if (!baseStake.equals(other.baseStake))
			return false;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (gridSize == null) {
			if (other.gridSize != null)
				return false;
		} else if (!gridSize.equals(other.gridSize))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lotteryGame == null) {
			if (other.lotteryGame != null)
				return false;
		} else if (!lotteryGame.equals(other.lotteryGame))
			return false;
		if (maxNrOfCombination == null) {
			if (other.maxNrOfCombination != null)
				return false;
		} else if (!maxNrOfCombination.equals(other.maxNrOfCombination))
			return false;
		if (maxNrOfFix == null) {
			if (other.maxNrOfFix != null)
				return false;
		} else if (!maxNrOfFix.equals(other.maxNrOfFix))
			return false;
		if (minNrOfFox == null) {
			if (other.minNrOfFox != null)
				return false;
		} else if (!minNrOfFox.equals(other.minNrOfFox))
			return false;
		if (nrOfGrids == null) {
			if (other.nrOfGrids != null)
				return false;
		} else if (!nrOfGrids.equals(other.nrOfGrids))
			return false;
		if (numbersDrawn == null) {
			if (other.numbersDrawn != null)
				return false;
		} else if (!numbersDrawn.equals(other.numbersDrawn))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (week == null) {
			if (other.week != null)
				return false;
		} else if (!week.equals(other.week))
			return false;
		if (winningNumbers == null) {
			if (other.winningNumbers != null)
				return false;
		} else if (!winningNumbers.equals(other.winningNumbers))
			return false;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LotteryDraw [id=" + id + ", baseStake=" + baseStake + ", gridSize=" + gridSize + ", numbersDrawn="
				+ numbersDrawn + ", nrOfGrids=" + nrOfGrids + ", minNrOfFox=" + minNrOfFox + ", maxNrOfFix="
				+ maxNrOfFix + ", maxNrOfCombination=" + maxNrOfCombination + ", year=" + year + ", week=" + week
				+ ", status=" + status + ", winningNumbers=" + winningNumbers + ", lotteryGame=" + lotteryGame
				+ ", createdDate=" + createdDate + "]";
	}

}
