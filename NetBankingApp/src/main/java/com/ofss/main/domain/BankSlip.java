package com.ofss.main.domain;

import java.math.BigDecimal;
import java.sql.Date;

public class BankSlip {
    private int slipId;
    private Date slipDate;
    private int accountId;
    private int chequeNo;
    private Date chequeDate;
    private String payerBank;
    private BigDecimal amount;
    private String status;

    // Constructors
    public BankSlip() {
    }

    public BankSlip(int slipId, Date slipDate, int accountId, int chequeNo, Date chequeDate, String payerBank, BigDecimal amount, String status) {
        this.slipId = slipId;
        this.slipDate = slipDate;
        this.accountId = accountId;
        this.chequeNo = chequeNo;
        this.chequeDate = chequeDate;
        this.payerBank = payerBank;
        this.amount = amount;
        this.status = status;
    }

    // Getters and setters
    public int getSlipId() {
        return slipId;
    }

    public void setSlipId(int slipId) {
        this.slipId = slipId;
    }

    public Date getSlipDate() {
        return slipDate;
    }

    public void setSlipDate(Date slipDate) {
        this.slipDate = slipDate;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getChequeNo() {
        return chequeNo;
    }

    public void setChequeNo(int chequeNo) {
        this.chequeNo = chequeNo;
    }

    public Date getChequeDate() {
        return chequeDate;
    }

    public void setChequeDate(Date chequeDate) {
        this.chequeDate = chequeDate;
    }

    public String getPayerBank() {
        return payerBank;
    }

    public void setPayerBank(String payerBank) {
        this.payerBank = payerBank;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Override toString method for debugging purposes
    @Override
    public String toString() {
        return "BankSlip [slipId=" + slipId + ", slipDate=" + slipDate + ", accountId=" + accountId
                + ", chequeNo=" + chequeNo + ", chequeDate=" + chequeDate + ", payerBank=" + payerBank
                + ", amount=" + amount + ", status=" + status + "]";
    }
}
