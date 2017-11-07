package com.tricast.controllers.responses;

import java.util.List;

public class LotteryDrawResponse {
    public int winningAmount;
    public List<Integer> winningPercentages;
    public List<Integer> winningNumbers;

    public int getWinningAmount() {
        return winningAmount;
    }

    public void setWinningAmount(int winningAmount) {
        this.winningAmount = winningAmount;
    }

    public List<Integer> getWinningPercentages() {
        return winningPercentages;
    }

    public void setWinningPercentages(List<Integer> winningPercentages) {
        this.winningPercentages = winningPercentages;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public void setWinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + winningAmount;
        result = prime * result + ((winningNumbers == null) ? 0 : winningNumbers.hashCode());
        result = prime * result + ((winningPercentages == null) ? 0 : winningPercentages.hashCode());
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
        LotteryDrawResponse other = (LotteryDrawResponse) obj;
        if (winningAmount != other.winningAmount) {
            return false;
        }
        if (winningNumbers == null) {
            if (other.winningNumbers != null) {
                return false;
            }
        } else if (!winningNumbers.equals(other.winningNumbers)) {
            return false;
        }
        if (winningPercentages == null) {
            if (other.winningPercentages != null) {
                return false;
            }
        } else if (!winningPercentages.equals(other.winningPercentages)) {
            return false;
        }
        return true;
    }

}
