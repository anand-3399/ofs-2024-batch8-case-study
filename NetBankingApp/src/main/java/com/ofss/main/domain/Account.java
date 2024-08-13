package com.ofss.main.domain;

import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "account_details")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private int accountId;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "opening_date")
    private Date openingDate;

    @Column(name = "minimum_balance")
    private int minimumBalance;

    @Column(name = "rate_of_interest")
    private double rateOfInterest;

    @OneToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customer;

    @Column(name = "account_balance")
    private double accountBalance;

    // Constructors
    public Account() {
    }

    public Account(int accountId, String accountType, Date openingDate, int minimumBalance,
                   double rateOfInterest, Customer customer, double accountBalance) {
        this.accountId = accountId;
        this.accountType = accountType;
        this.openingDate = openingDate;
        this.minimumBalance = minimumBalance;
        this.rateOfInterest = rateOfInterest;
        this.customer = customer;
        this.accountBalance = accountBalance;
    }

    // Getters and setters
    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }

    public int getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(int minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    public double getRateOfInterest() {
        return rateOfInterest;
    }

    public void setRateOfInterest(double rateOfInterest) {
        this.rateOfInterest = rateOfInterest;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    // Override toString method for debugging purposes
    @Override
    public String toString() {
        return "Account [accountId=" + accountId + ", accountType=" + accountType + ", openingDate="
                + openingDate + ", minimumBalance=" + minimumBalance + ", rateOfInterest=" + rateOfInterest
                + ", customer=" + customer + ", accountBalance=" + accountBalance + "]";
    }
}
