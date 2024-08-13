package com.ofss.main.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Cheque {
    private int chequeNo;
    private BigDecimal amount;
    private String sender;
    private String receiver;
    private Timestamp chequeTime;
    private int accountId;

    // Constructors
    public Cheque() {
    }

    public Cheque(int chequeNo, BigDecimal amount, String sender, String receiver, Timestamp chequeTime, int accountId) {
        this.chequeNo = chequeNo;
        this.amount = amount;
        this.sender = sender;
        this.receiver = receiver;
        this.chequeTime = chequeTime;
        this.accountId = accountId;
    }

    // Getters and setters
    public int getChequeNo() {
        return chequeNo;
    }

    public void setChequeNo(int chequeNo) {
        this.chequeNo = chequeNo;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public Timestamp getChequeTime() {
        return chequeTime;
    }

    public void setChequeTime(Timestamp chequeTime) {
        this.chequeTime = chequeTime;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    // Override toString method for debugging purposes
    @Override
    public String toString() {
        return "Cheque [chequeNo=" + chequeNo + ", amount=" + amount + ", sender=" + sender
                + ", receiver=" + receiver + ", chequeTime=" + chequeTime + ", accountId=" + accountId + "]";
    }
}
