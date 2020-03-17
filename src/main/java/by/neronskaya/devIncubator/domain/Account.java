package by.neronskaya.devIncubator.domain;

import java.sql.Date;

public class Account implements Identifier {

    private int accountID;
    private Integer userID;
    private String accountCurrency;
    private String type;
    private String status;
    private int cashback;
    private boolean isRefundable;
    private int credit;
    private Date dateOfCreation;
    private int dateOfExpiration;
    private int balance;

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    @Override
    public Integer getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getAccountCurrency() {
        return accountCurrency;
    }

    public void setAccountCurrency(String accountCurrency) {
        this.accountCurrency = accountCurrency;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCashback() {
        return cashback;
    }

    public void setCashback(int cashback) {
        this.cashback = cashback;
    }

    public boolean isRefundable() {
        return isRefundable;
    }

    public void setRefundable(boolean refundable) {
        isRefundable = refundable;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public int getDateOfExpiration() {
        return dateOfExpiration;
    }

    public void setDateOfExpiration(int dateOfExpiration) {
        this.dateOfExpiration = dateOfExpiration;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountID=" + accountID +
                ", userID=" + userID +
                ", accountCurrency='" + accountCurrency + '\'' +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", cashback=" + cashback +
                ", isRefundable='" + isRefundable + '\'' +
                ", credit=" + credit +
                ", dateOfCreation='" + dateOfCreation + '\'' +
                ", dateOfExpiration=" + dateOfExpiration +
                ", balance=" + balance +
                '}';
    }
}
