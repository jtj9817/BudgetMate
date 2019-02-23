package com.example.budgetmate;

import java.util.Date;

public class Debts {
    public String getDebtName() {
        return DebtName;
    }

    public void setDebtName(String debtName) {
        DebtName = debtName;
    }

    private String DebtName;

    public Double getDebtinitial() {
        return debtInitial;
    }

    public void setdebtInitial(Double debtInitial) {
        this.debtInitial = debtInitial;
    }

    private Double debtInitial;

    public Double getDebtCurrent() {
        return debtCurrent;
    }

    public void setDebtCurrent(Double debtCurrent) {
        this.debtCurrent = debtCurrent;
    }

    private Double debtCurrent;

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    private Double interestRate;

    public Integer getCompoundFrequency() {
        return compoundFrequency;
    }

    public void setCompoundFrequency(Integer compoundFrequency) {
        this.compoundFrequency = compoundFrequency;
    }

    private Integer compoundFrequency;

    public Double getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(Double totalPaid) {
        this.totalPaid = totalPaid;
    }

    private Double totalPaid;

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    private Date dateAdded;

    public Date getDateFinished() {
        return dateFinished;
    }

    public void setDateFinished(Date dateFinished) {
        this.dateFinished = dateFinished;
    }

    private Date dateFinished;

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    private boolean isActive;

    public Date getInterestLastApplied() {
        return interestLastApplied;
    }

    public void setInterestLastApplied(Date interestLastApplied) {
        this.interestLastApplied = interestLastApplied;
    }

    private Date interestLastApplied;

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    private Date lastUpdated;
}
