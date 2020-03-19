package by.neronskaya.devIncubator.domain;

import java.sql.Date;

public class User implements Identifier {

    private Integer userID;
    private String name;
    private String sureName;
    private Date birthday;
    private int telephone;
    private String countryCode;
    private String email;
    private String addressRegistration;
    private String addressResidence;
    private String passportNo;
    private String nationality;

    @Override
    public Integer getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSureName() {
        return sureName;
    }

    public void setSureName(String sureName) {
        this.sureName = sureName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddressRegistration() {
        return addressRegistration;
    }

    public void setAddressRegistration(String addressRegistration) {
        this.addressRegistration = addressRegistration;
    }

    public String getAddressResidence() {
        return addressResidence;
    }

    public void setAddressResidence(String addressResidence) {
        this.addressResidence = addressResidence;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID = " + userID +
                ", name = '" + name + '\'' +
                ", sureName = '" + sureName + '\'' +
                ", birthday = '" + birthday + '\'' +
                ", telephone = " + telephone +
                ", countryCode = '" + countryCode + '\'' +
                ", email = '" + email + '\'' +
                ", addressRegistration = '" + addressRegistration + '\'' +
                ", addressResidence = '" + addressResidence + '\'' +
                ", passportNo = '" + passportNo + '\'' +
                ", nationality = '" + nationality + '\'' +
                '}';
    }
}


