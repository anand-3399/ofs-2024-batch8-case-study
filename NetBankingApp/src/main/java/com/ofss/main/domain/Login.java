package com.ofss.main.domain;

import java.sql.Timestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "login_details")
public class Login {

    @Id
    @Column(name = "login_id")
    private String loginId;

    @Column(name = "password")
    private String password;

    @Column(name = "counter")
    private int loginAttempts = -1;

    @Column(name = "status")
    private String loginStatus;

    @Column(name = "login_time")
    private Timestamp loginTime;

    // Constructors
    public Login() {
    }

    public Login(String loginId, String password, int loginAttempts, String loginStatus, Timestamp loginTime) {
        this.loginId = loginId;
        this.password = password;
        this.loginAttempts = loginAttempts;
        this.loginStatus = loginStatus;
        this.loginTime = loginTime;
    }

    // Getters and setters
    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLoginAttempts() {
        return loginAttempts;
    }

    public void setLoginAttempts(int loginAttempts) {
        this.loginAttempts = loginAttempts;
    }

    public String getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(String loginStatus) {
        this.loginStatus = loginStatus;
    }

    public Timestamp getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Timestamp loginTime) {
        this.loginTime = loginTime;
    }

    // Override toString method for debugging purposes
    @Override
    public String toString() {
        return "Login [loginId=" + loginId + ", password=" + password + ", loginAttempts=" + loginAttempts
                + ", loginStatus=" + loginStatus + ", loginTime=" + loginTime + "]";
    }
}
