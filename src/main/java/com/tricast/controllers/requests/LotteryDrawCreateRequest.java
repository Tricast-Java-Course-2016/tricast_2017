package com.tricast.controllers.requests;

public class LotteryDrawCreateRequest {

    private String winningNumbers;
    private int maxHitPercent;
    private int maxMin1HitPercent;
    private int maxMin2HitPercent;
    private int maxmin3HitPercent;
    private int week;
    private int year;
    private int prize;
    private String gameDescriptons;

    public String getWinningNumbers() {
        return winningNumbers;
    }

    public void setWinningNumbers(String winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public int getMaxHitPercent() {
        return maxHitPercent;
    }

    public void setMaxHitPercent(int maxHitPercent) {
        this.maxHitPercent = maxHitPercent;
    }

    public int getMaxMin1HitPercent() {
        return maxMin1HitPercent;
    }

    public void setMaxMin1HitPercent(int maxMin1HitPercent) {
        this.maxMin1HitPercent = maxMin1HitPercent;
    }

    public int getMaxMin2HitPercent() {
        return maxMin2HitPercent;
    }

    public void setMaxMin2HitPercent(int maxMin2HitPercent) {
        this.maxMin2HitPercent = maxMin2HitPercent;
    }

    public int getMaxmin3HitPercent() {
        return maxmin3HitPercent;
    }

    public void setMaxmin3HitPercent(int maxmin3HitPercent) {
        this.maxmin3HitPercent = maxmin3HitPercent;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPrize() {
        return prize;
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }

    public String getGameDescriptons() {
        return gameDescriptons;
    }

    public void setGameDescriptons(String gameDescriptons) {
        this.gameDescriptons = gameDescriptons;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((gameDescriptons == null) ? 0 : gameDescriptons.hashCode());
        result = prime * result + maxHitPercent;
        result = prime * result + maxMin1HitPercent;
        result = prime * result + maxMin2HitPercent;
        result = prime * result + maxmin3HitPercent;
        result = prime * result + prize;
        result = prime * result + week;
        result = prime * result + ((winningNumbers == null) ? 0 : winningNumbers.hashCode());
        result = prime * result + year;
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
        LotteryDrawCreateRequest other = (LotteryDrawCreateRequest) obj;
        if (gameDescriptons == null) {
            if (other.gameDescriptons != null) {
                return false;
            }
        } else if (!gameDescriptons.equals(other.gameDescriptons)) {
            return false;
        }
        if (maxHitPercent != other.maxHitPercent) {
            return false;
        }
        if (maxMin1HitPercent != other.maxMin1HitPercent) {
            return false;
        }
        if (maxMin2HitPercent != other.maxMin2HitPercent) {
            return false;
        }
        if (maxmin3HitPercent != other.maxmin3HitPercent) {
            return false;
        }
        if (prize != other.prize) {
            return false;
        }
        if (week != other.week) {
            return false;
        }
        if (winningNumbers == null) {
            if (other.winningNumbers != null) {
                return false;
            }
        } else if (!winningNumbers.equals(other.winningNumbers)) {
            return false;
        }
        if (year != other.year) {
            return false;
        }
        return true;
    }

}
