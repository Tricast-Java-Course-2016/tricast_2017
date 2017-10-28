package com.tricast.controllers.responses;

import java.util.Date;
import java.util.List;

public class LotteryTicketDetailsResponse { // Ticket ID & 5 vagy 1 hetes

    private Date createDate; // from lotterTickets
    private List<String> selection; // from singleSelections
    private int stake; // from lotteryTickets
    private int totalPrice;
    private int winningAmount; // from singleSelections
    private int ticketId;
    private boolean oneWeek;
    public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<String> getSelection() {
        return selection;
    }

    public void setSelection(List<String> selection) {
        this.selection = selection;
    }
    public int getStake() {
        return stake;
    }
    public void setStake(int stake) {
        this.stake = stake;
    }
    public int getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
    public int getWinningAmount() {
        return winningAmount;
    }
    public void setWinningAmount(int winningAmount) {
        this.winningAmount = winningAmount;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
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
        result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
        result = prime * result + (oneWeek ? 1231 : 1237);
        result = prime * result + ((selection == null) ? 0 : selection.hashCode());
        result = prime * result + stake;
        result = prime * result + ticketId;
        result = prime * result + totalPrice;
        result = prime * result + winningAmount;
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
        LotteryTicketDetailsResponse other = (LotteryTicketDetailsResponse) obj;
        if (createDate == null) {
            if (other.createDate != null) {
                return false;
            }
        } else if (!createDate.equals(other.createDate)) {
            return false;
        }
        if (oneWeek != other.oneWeek) {
            return false;
        }
        if (selection == null) {
            if (other.selection != null) {
                return false;
            }
        } else if (!selection.equals(other.selection)) {
            return false;
        }
        if (stake != other.stake) {
            return false;
        }
        if (ticketId != other.ticketId) {
            return false;
        }
        if (totalPrice != other.totalPrice) {
            return false;
        }
        if (winningAmount != other.winningAmount) {
            return false;
        }
        return true;
    }


}
