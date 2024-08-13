package com.ofss.main.domain;
import java.sql.Timestamp;

public class Transaction {
    private int transactionId;
    private int accountId;
    private Timestamp transactionTime;
    private int receiver;
    private int sender;
    private double amount;
    private double balanceAmount;

    // Constructors
    public Transaction() {
    }

    public Transaction(int transactionId, int accountId, Timestamp transactionTime,
            int receiver, int sender, double amount, double balanceAmount) {
        this.transactionId = transactionId;
        this.accountId = accountId;
        this.transactionTime = transactionTime;
        this.receiver = receiver;
        this.sender = sender;
        this.amount = amount;
        this.balanceAmount = balanceAmount;
    }

    // Getters and setters
    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public Timestamp getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(Timestamp transactionTime) {
        this.transactionTime = transactionTime;
    }

    public int getReceiver() {
        return receiver;
    }

    public void setReceiver(int receiver) {
        this.receiver = receiver;
    }

    public int getSender() {
        return sender;
    }

    public void setSender(int sender) {
        this.sender = sender;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getbalanceAmount() {
        return balanceAmount;
    }

    public void setbalanceAmount(double balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    // Override toString method for debugging purposes

    @Override
    public String toString() {
        return "Transaction [transactionId=" + transactionId + ", accountId=" + accountId + ", transactionTime="
                + transactionTime + ", receiver=" + receiver + ", sender=" + sender + ", amount=" + amount
                + ", balanceAmount=" + balanceAmount + "]";
    }

    
}
