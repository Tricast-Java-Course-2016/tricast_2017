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
@Table(name = "LotteryGames")
public class LotteryGame implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 6652648022347822854L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

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

    @Column(name = "createddate")
    private Date createdDate;

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
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((gridSize == null) ? 0 : gridSize.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((maxNrOfCombination == null) ? 0 : maxNrOfCombination.hashCode());
        result = prime * result + ((maxNrOfFix == null) ? 0 : maxNrOfFix.hashCode());
        result = prime * result + ((minNrOfFox == null) ? 0 : minNrOfFox.hashCode());
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
        LotteryGame other = (LotteryGame) obj;
        if (baseStake == null) {
            if (other.baseStake != null) {
                return false;
            }
        } else if (!baseStake.equals(other.baseStake)) {
            return false;
        }
        if (createdDate == null) {
            if (other.createdDate != null) {
                return false;
            }
        } else if (!createdDate.equals(other.createdDate)) {
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
        if (minNrOfFox == null) {
            if (other.minNrOfFox != null) {
                return false;
            }
        } else if (!minNrOfFox.equals(other.minNrOfFox)) {
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
                + minNrOfFox + ", maxNrOfFix=" + maxNrOfFix + ", maxNrOfCombination=" + maxNrOfCombination
                + ", createdDate=" + createdDate + "]";
    }


}
