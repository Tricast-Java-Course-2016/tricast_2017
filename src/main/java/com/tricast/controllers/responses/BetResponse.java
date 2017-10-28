package com.tricast.controllers.responses;

public class BetResponse { // átnevezni

    private int lotteryGameId; // from lottery games
    private int lotteryDrawId; // from lottery draws
    private String description; // from lottery games
    private int baseStake; // from lottery games
    private int gridSize; // from lottery games
    private int numbersDrawn; // from lottery games
    private int nrOfGrids; // from lottery games
    private int minNrOfFox; // from lottery games
    private int maxNrOfFix; // from lottery games
    private int maxNrOfCombination; // from lottery games
    private String year; // from lottery draws
    private String week; // from lottery draws
    public int getLotteryGameId() {
        return lotteryGameId;
    }
    public void setLotteryGameId(int lotteryGameId) {
        this.lotteryGameId = lotteryGameId;
    }
    public int getLotteryDrawId() {
        return lotteryDrawId;
    }
    public void setLotteryDrawId(int lotteryDrawId) {
        this.lotteryDrawId = lotteryDrawId;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public int getBaseStake() {
        return baseStake;
    }

    public void setBaseStake(int baseStake) {
        this.baseStake = baseStake;
    }

    public int getGridSize() {
        return gridSize;
    }

    public void setGridSize(int gridSize) {
        this.gridSize = gridSize;
    }

    public int getNumbersDrawn() {
        return numbersDrawn;
    }

    public void setNumbersDrawn(int numbersDrawn) {
        this.numbersDrawn = numbersDrawn;
    }

    public int getNrOfGrids() {
        return nrOfGrids;
    }

    public void setNrOfGrids(int nrOfGrids) {
        this.nrOfGrids = nrOfGrids;
    }

    public int getMinNrOfFox() {
        return minNrOfFox;
    }

    public void setMinNrOfFox(int minNrOfFox) {
        this.minNrOfFox = minNrOfFox;
    }

    public int getMaxNrOfFix() {
        return maxNrOfFix;
    }

    public void setMaxNrOfFix(int maxNrOfFix) {
        this.maxNrOfFix = maxNrOfFix;
    }

    public int getMaxNrOfCombination() {
        return maxNrOfCombination;
    }

    public void setMaxNrOfCombination(int maxNrOfCombination) {
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
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + baseStake;
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + gridSize;
        result = prime * result + lotteryDrawId;
        result = prime * result + lotteryGameId;
        result = prime * result + maxNrOfCombination;
        result = prime * result + maxNrOfFix;
        result = prime * result + minNrOfFox;
        result = prime * result + nrOfGrids;
        result = prime * result + numbersDrawn;
        result = prime * result + ((week == null) ? 0 : week.hashCode());
        result = prime * result + ((year == null) ? 0 : year.hashCode());
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
        BetResponse other = (BetResponse) obj;
        if (baseStake != other.baseStake) {
            return false;
        }
        if (description == null) {
            if (other.description != null) {
                return false;
            }
        } else if (!description.equals(other.description)) {
            return false;
        }
        if (gridSize != other.gridSize) {
            return false;
        }
        if (lotteryDrawId != other.lotteryDrawId) {
            return false;
        }
        if (lotteryGameId != other.lotteryGameId) {
            return false;
        }
        if (maxNrOfCombination != other.maxNrOfCombination) {
            return false;
        }
        if (maxNrOfFix != other.maxNrOfFix) {
            return false;
        }
        if (minNrOfFox != other.minNrOfFox) {
            return false;
        }
        if (nrOfGrids != other.nrOfGrids) {
            return false;
        }
        if (numbersDrawn != other.numbersDrawn) {
            return false;
        }
        if (week == null) {
            if (other.week != null) {
                return false;
            }
        } else if (!week.equals(other.week)) {
            return false;
        }
        if (year == null) {
            if (other.year != null) {
                return false;
            }
        } else if (!year.equals(other.year)) {
            return false;
        }
        return true;
    }



}
