package com.tricast.controllers.requests;

public class LotteryDrawEditRequest {

    private String winningNumbers;
    private String winningPercentage;
    private int lotteryDrawId;
    
    public String getWinningNumbers() {
        return winningNumbers;
    }
    public void setWinningNumbers(String winningNumbers) {
        this.winningNumbers = winningNumbers;
    }
    public String getWinningPercentage() {
        return winningPercentage;
    }
    public void setWinningPercentage(String winningPercentage) {
        this.winningPercentage = winningPercentage;
    }
    public int getLotteryDrawId() {
        return lotteryDrawId;
    }
    public void setLotteryDrawId(int lotteryDrawId) {
        this.lotteryDrawId = lotteryDrawId;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + lotteryDrawId;
        result = prime * result + ((winningNumbers == null) ? 0 : winningNumbers.hashCode());
        result = prime * result + ((winningPercentage == null) ? 0 : winningPercentage.hashCode());
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
        LotteryDrawEditRequest other = (LotteryDrawEditRequest) obj;
        if (lotteryDrawId != other.lotteryDrawId)
            return false;
        if (winningNumbers == null) {
            if (other.winningNumbers != null)
                return false;
        } else if (!winningNumbers.equals(other.winningNumbers))
            return false;
        if (winningPercentage == null) {
            if (other.winningPercentage != null)
                return false;
        } else if (!winningPercentage.equals(other.winningPercentage))
            return false;
        return true;
    }

   
}
