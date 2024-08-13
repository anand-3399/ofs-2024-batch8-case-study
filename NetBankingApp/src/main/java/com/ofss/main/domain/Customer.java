package com.ofss.main.domain;

import org.apache.commons.logging.Log;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer_details")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
    
    @Column(name = "age")
    private int age;
    
    @Column(name = "gender")
    private String gender;

    @Column(name = "mobile")
    private long mobile;
    
    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;
    
    @Column(name = "pan")
    private String pan;
    
    @Column(name = "aadhar")
    private long aadhar;

    @OneToOne
    @JoinColumn(name = "login_id", referencedColumnName = "login_id")
    private Login login;

    // Constructors
    public Customer() {
    }

    public Customer(int customerId, String firstName, String lastName, int age, String gender, long mobile,
                    String email, String address, String pan, long aadhar, Login login) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.mobile = mobile;
        this.email = email;
        this.address = address;
        this.pan = pan;
        this.aadhar = aadhar;
        this.login = login;
    }

    // Getters and setters
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public long getAadhar() {
        return aadhar;
    }

    public void setAadhar(long aadhar) {
        this.aadhar = aadhar;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    // Override toString method for debugging purposes
    @Override
    public String toString() {
        return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
                + ", age=" + age + ", gender=" + gender + ", mobile=" + mobile + ", email=" + email + ", address="
                + address + ", pan=" + pan + ", aadhar=" + aadhar + ", login=" + login + "]";
    }
}
