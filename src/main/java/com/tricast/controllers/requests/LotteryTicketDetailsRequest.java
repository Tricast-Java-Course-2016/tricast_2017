package com.tricast.controllers.requests;

public class LotteryTicketDetailsRequest {

    private int lotteryTicketId; // from lotteryTickets


    public int getLotteryTicketId() {
        return lotteryTicketId;
    }

    public void setLotteryTicketId(int lotteryTicketId) {
        this.lotteryTicketId = lotteryTicketId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
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
        if (lotteryTicketId != other.lotteryTicketId) {
            return false;
        }
        return true;
    }


}
