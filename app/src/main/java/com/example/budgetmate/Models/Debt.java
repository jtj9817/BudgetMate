package com.example.budgetmate.Models;

import java.util.Date;

public class Debt {

    private String debtID;
    private String debtName;
    private Double debtInitial;
    private Double debtCurrent;
    private Double interestRate;
    private Integer compoundFrequency;
    private Double totalPaid;
    private Date dateAdded;
    private Date dateFinished;
    private boolean active;
    private Date interestLastApplied;
    private Date lastUpdated;

    public String getDebtID() {
        return debtID;
    }

    public void setDebtID(String debtID) {
        this.debtID = debtID;
    }

    public String getDebtName() {
        return debtName;
    }

    public void setDebtName(String debtName) {
        this.debtName = debtName;
    }

    public Double getDebtInitial() {
        return debtInitial;
    }

    public void setDebtInitial(Double debtInitial) {
        this.debtInitial = debtInitial;
    }

    public Double getDebtCurrent() {
        return debtCurrent;
    }

    public void setDebtCurrent(Double debtCurrent) {
        this.debtCurrent = debtCurrent;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public Integer getCompoundFrequency() {
        return compoundFrequency;
    }

    public void setCompoundFrequency(Integer compoundFrequency) {
        this.compoundFrequency = compoundFrequency;
    }

    public Double getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(Double totalPaid) {
        this.totalPaid = totalPaid;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Date getDateFinished() {
        return dateFinished;
    }

    public void setDateFinished(Date dateFinished) {
        this.dateFinished = dateFinished;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getInterestLastApplied() {
        return interestLastApplied;
    }

    public void setInterestLastApplied(Date interestLastApplied) {
        this.interestLastApplied = interestLastApplied;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
