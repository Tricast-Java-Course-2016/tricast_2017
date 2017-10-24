package com.tricast.controllers.responses;

import java.util.Date;

public class TransactionLotteryTicketResponse {

    private Date createdate; // from transaction
    private String description; // from lotteryGames
    private int amount; // from transaction
    private String state; // from lotteryDraws

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + amount;
        result = prime * result + ((createdate == null) ? 0 : createdate.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((state == null) ? 0 : state.hashCode());
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
        TransactionLotteryTicketResponse other = (TransactionLotteryTicketResponse) obj;
        if (amount != other.amount) {
            return false;
        }
        if (createdate == null) {
            if (other.createdate != null) {
                return false;
            }
        } else if (!createdate.equals(other.createdate)) {
            return false;
        }
        if (description == null) {
            if (other.description != null) {
                return false;
            }
        } else if (!description.equals(other.description)) {
            return false;
        }
        if (state == null) {
            if (other.state != null) {
                return false;
            }
        } else if (!state.equals(other.state)) {
            return false;
        }
        return true;
    }

}
