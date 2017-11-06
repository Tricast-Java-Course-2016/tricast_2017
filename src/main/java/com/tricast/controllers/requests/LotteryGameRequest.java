package com.tricast.controllers.requests;

public class LotteryGameRequest {

	private Long id;
	private String description;
	private Integer baseStake;
	private Integer gridSize;
	private Integer numbersDrawn;
	private Integer nrOfGrids;
	private Integer minNrOfFix;
	private Integer maxNrOfFix;
	private Integer maxNrOfCombination;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Integer getMinNrOfFix() {
		return minNrOfFix;
	}

	public void setMinNrOfFix(Integer minNrOfFox) {
		this.minNrOfFix = minNrOfFox;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((baseStake == null) ? 0 : baseStake.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((gridSize == null) ? 0 : gridSize.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((maxNrOfCombination == null) ? 0 : maxNrOfCombination.hashCode());
		result = prime * result + ((maxNrOfFix == null) ? 0 : maxNrOfFix.hashCode());
		result = prime * result + ((minNrOfFix == null) ? 0 : minNrOfFix.hashCode());
		result = prime * result + ((nrOfGrids == null) ? 0 : nrOfGrids.hashCode());
		result = prime * result + ((numbersDrawn == null) ? 0 : numbersDrawn.hashCode());
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
		LotteryGameRequest other = (LotteryGameRequest) obj;
		if (baseStake == null) {
			if (other.baseStake != null) {
				return false;
			}
		} else if (!baseStake.equals(other.baseStake)) {
			return false;
		}
		if (description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!description.equals(other.description)) {
			return false;
		}
		if (gridSize == null) {
			if (other.gridSize != null) {
				return false;
			}
		} else if (!gridSize.equals(other.gridSize)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (maxNrOfCombination == null) {
			if (other.maxNrOfCombination != null) {
				return false;
			}
		} else if (!maxNrOfCombination.equals(other.maxNrOfCombination)) {
			return false;
		}
		if (maxNrOfFix == null) {
			if (other.maxNrOfFix != null) {
				return false;
			}
		} else if (!maxNrOfFix.equals(other.maxNrOfFix)) {
			return false;
		}
		if (minNrOfFix == null) {
			if (other.minNrOfFix != null) {
				return false;
			}
		} else if (!minNrOfFix.equals(other.minNrOfFix)) {
			return false;
		}
		if (nrOfGrids == null) {
			if (other.nrOfGrids != null) {
				return false;
			}
		} else if (!nrOfGrids.equals(other.nrOfGrids)) {
			return false;
		}
		if (numbersDrawn == null) {
			if (other.numbersDrawn != null) {
				return false;
			}
		} else if (!numbersDrawn.equals(other.numbersDrawn)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "LotteryGame [id=" + id + ", description=" + description + ", baseStake=" + baseStake + ", gridSize="
				+ gridSize + ", numbersDrawn=" + numbersDrawn + ", nrOfGrids=" + nrOfGrids + ", minNrOfFox="
				+ minNrOfFix + ", maxNrOfFix=" + maxNrOfFix + ", maxNrOfCombination=" + maxNrOfCombination + "]";
	}

}
