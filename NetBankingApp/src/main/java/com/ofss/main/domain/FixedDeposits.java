package com.ofss.main.domain;

import java.math.BigDecimal;
import java.sql.Date;

public class FixedDeposits {
    private int accountId;
    private Date maturityDate;
    private BigDecimal amount;
    private BigDecimal interestPercentage;

    // Constructors
    public FixedDeposits() {
    }

    public FixedDeposits(int accountId, Date maturityDate, BigDecimal amount, BigDecimal interestPercentage) {
        this.accountId = accountId;
        this.maturityDate = maturityDate;
        this.amount = amount;
        this.interestPercentage = interestPercentage;
    }

    // Getters and setters
    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public Date getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(Date maturityDate) {
        this.maturityDate = maturityDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getInterestPercentage() {
        return interestPercentage;
    }

    public void setInterestPercentage(BigDecimal interestPercentage) {
        this.interestPercentage = interestPercentage;
    }

    // Override toString method for debugging purposes
    @Override
    public String toString() {
        return "FixedDeposits [accountId=" + accountId + ", maturityDate=" + maturityDate + ", amount=" + amount
                + ", interestPercentage=" + interestPercentage + "]";
    }
}
