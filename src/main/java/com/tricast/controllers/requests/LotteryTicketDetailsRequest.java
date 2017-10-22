package com.tricast.controllers.requests;

public class LotteryTicketDetailsRequest {

    private int lotteryTicketId; // from lotteryTickets
    private int lotteryDrawId; // from lotteryDraws
    private int SingleSelectionId; // from singleSelections

    public int getLotteryTicketId() {
        return lotteryTicketId;
    }

    public void setLotteryTicketId(int lotteryTicketId) {
        this.lotteryTicketId = lotteryTicketId;
    }

    public int getLotteryDrawId() {
        return lotteryDrawId;
    }

    public void setLotteryDrawId(int lotteryDrawId) {
        this.lotteryDrawId = lotteryDrawId;
    }

    public int getSingleSelectionId() {
        return SingleSelectionId;
    }

    public void setSingleSelectionId(int singleSelectionId) {
        SingleSelectionId = singleSelectionId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + SingleSelectionId;
        result = prime * result + lotteryDrawId;
        result = prime * result + lotteryTicketId;
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
        LotteryTicketDetailsRequest other = (LotteryTicketDetailsRequest) obj;
        if (SingleSelectionId != other.SingleSelectionId) {
            return false;
        }
        if (lotteryDrawId != other.lotteryDrawId) {
            return false;
        }
        if (lotteryTicketId != other.lotteryTicketId) {
            return false;
        }
        return true;
    }

}
