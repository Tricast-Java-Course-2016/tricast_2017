package com.tricast.controllers.requests;

import java.util.List;

public class BetRequest {

    private int lotteryDrawId;
    private int playerId;
    private List<Integer> fixNumbers;
    private List<Integer> combinationNumbers;
    private boolean oneWeek;
    public int getLotteryDrawId() {
        return lotteryDrawId;
    }
    public void setLotteryDrawId(int lotteryDrawId) {
        this.lotteryDrawId = lotteryDrawId;
    }
    public int getPlayerId() {
        return playerId;
    }
    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public List<Integer> getFixNumbers() {
        return fixNumbers;
    }

    public void setFixNumbers(List<Integer> fixNumbers) {
        this.fixNumbers = fixNumbers;
    }

    public List<Integer> getCombinationNumbers() {
        return combinationNumbers;
    }

    public void setCombinationNumbers(List<Integer> combinationNumbers) {
        this.combinationNumbers = combinationNumbers;
    }
    public boolean isOneWeek() {
        return oneWeek;
    }
    public void setOneWeek(boolean oneWeek) {
        this.oneWeek = oneWeek;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((combinationNumbers == null) ? 0 : combinationNumbers.hashCode());
        result = prime * result + ((fixNumbers == null) ? 0 : fixNumbers.hashCode());
        result = prime * result + lotteryDrawId;
        result = prime * result + (oneWeek ? 1231 : 1237);
        result = prime * result + playerId;
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
        BetRequest other = (BetRequest) obj;
        if (combinationNumbers == null) {
            if (other.combinationNumbers != null) {
                return false;
            }
        } else if (!combinationNumbers.equals(other.combinationNumbers)) {
            return false;
        }
        if (fixNumbers == null) {
            if (other.fixNumbers != null) {
                return false;
            }
        } else if (!fixNumbers.equals(other.fixNumbers)) {
            return false;
        }
        if (lotteryDrawId != other.lotteryDrawId) {
            return false;
        }
        if (oneWeek != other.oneWeek) {
            return false;
        }
        if (playerId != other.playerId) {
            return false;
        }
        return true;
    }



}
