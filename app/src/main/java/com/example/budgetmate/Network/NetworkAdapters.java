package com.example.budgetmate.Network;

class postRespObj {
    public Boolean successful;
    public String error;
    public String result;
}

class RetrieveUserObj {
    private String token;
    public String action = "retrieveUser";
    public RetrieveUserObj(String token) {
        this.token = token;
    }
}

class RegisterUserObj {
    private String token;
    private String firstName;
    private String lastName;
    public String action = "registerUser";
    public RegisterUserObj(String token, String firstName, String lastName) {
        this.token = token;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}

class RetrieveGoalsObj {
    private String token;
    public String action = "retrieveGoals";
    public RetrieveGoalsObj(String token) {
        this.token = token;
    }
}

class CreateGoalObj {
    private String token;
    public String action = "createNewGoal";
    private String goalName;
    private Double goalAmount;
    private Double goalAmountSaved;
    public CreateGoalObj(String token, String goalName, Double goalAmount, Double goalAmountSaved) {
        this.token = token;
        this.goalName = goalName;
        this.goalAmount = goalAmount;
        this.goalAmountSaved = goalAmountSaved;
    }
}

class DeleteGoalObj {
    private String token;
    public String action = "deleteGoal";
    private String goalID;
    public DeleteGoalObj(String token, String goalID) {
        this.token = token;
        this.goalID = goalID;
    }
}

class UpdateGoalNameObj {
    private String token;
    public String action = "updateGoalName";
    private String goalID;
    private String goalName;
    public UpdateGoalNameObj(String token, String goalID, String goalName) {
        this.token = token;
        this.goalID = goalID;
        this.goalName = goalName;
    }
}

class UpdateGoalAmountObj {
    private String token;
    public String action = "updateGoalAmount";
    private String goalID;
    private Double goalAmount;
    public UpdateGoalAmountObj(String token, String goalID, Double goalAmount) {
        this.token = token;
        this.goalID = goalID;
        this.goalAmount = goalAmount;
    }
}

class UpdateGoalAmountSavedObj {
    private String token;
    public String action = "updateGoalAmountSaved";
    private String goalID;
    private Double goalAmountSaved;
    public UpdateGoalAmountSavedObj(String token, String goalID, Double goalAmountSaved) {
        this.token = token;
        this.goalID = goalID;
        this.goalAmountSaved = goalAmountSaved;
    }
}

class UpdateGoalFinishedObj {
    private String token;
    public String action = "updateGoalFinished";
    private String goalID;
    public UpdateGoalFinishedObj(String token, String goalID) {
        this.token = token;
        this.goalID = goalID;
    }
}

class ActivateGoalObj {
    private String token;
    public String action = "activateGoal";
    private String goalID;
    public ActivateGoalObj(String token, String goalID) {
        this.token = token;
        this.goalID = goalID;
    }
}

class DisableGoalObj {
    private String token;
    public String action = "disableGoal";
    private String goalID;
    public DisableGoalObj(String token, String goalID) {
        this.token = token;
        this.goalID = goalID;
    }
}

class RetrieveDebtsObj {
    private String token;
    public String action = "retrieveDebts";
    public RetrieveDebtsObj(String token) {
        this.token = token;
    }
}

class CreateDebtObj {
    private String token;
    public String action = "createNewDebt";
    private String debtName;
    private Double debtInitial;
    private Double debtCurrent;
    private Double interestRate;
    private Integer compoundFrequency;
    private Double totalPaid;
    public CreateDebtObj(String token, String debtName, Double debtInitial, Double debtCurrent, Double interestRate, Integer compoundFrequency, Double totalPaid) {
        this.token = token;
        this.debtName = debtName;
        this.debtInitial = debtInitial;
        this.debtCurrent = debtCurrent;
        this.interestRate = interestRate;
        this.compoundFrequency = compoundFrequency;
        this.totalPaid = totalPaid;
    }
}

class DeleteDebtObj {
    private String token;
    public String action = "deleteDebt";
    private String debtID;
    public DeleteDebtObj(String token, String debtID) {
        this.token = token;
        this.debtID = debtID;
    }
}

class UpdateDebtNameObj {
    private String token;
    public String action = "updateDebtName";
    private String debtID;
    private String debtName;
    public UpdateDebtNameObj(String token, String debtID, String debtName) {
        this.token = token;
        this.debtID = debtID;
        this.debtName = debtName;
    }
}

class UpdateDebtInitialObj {
    private String token;
    public String action = "updateDebtInitial";
    private String debtID;
    private Double debtInitial;
    public UpdateDebtInitialObj(String token, String debtID, Double debtInitial) {
        this.token = token;
        this.debtID = debtID;
        this.debtInitial = debtInitial;
    }
}

class UpdateDebtCurrentObj {
    private String token;
    public String action = "updateDebtCurrent";
    private String debtID;
    private Double debtCurrent;
    public UpdateDebtCurrentObj(String token, String debtID, Double debtCurrent) {
        this.token = token;
        this.debtID = debtID;
        this.debtCurrent = debtCurrent;
    }
}

class UpdateDebtInterestRateObj {
    private String token;
    public String action = "updateDebtInterestRate";
    private String debtID;
    private Double debtInterestRate;
    public UpdateDebtInterestRateObj(String token, String debtID, Double debtInterestRate) {
        this.token = token;
        this.debtID = debtID;
        this.debtInterestRate = debtInterestRate;
    }
}

class UpdateDebtCompoundFrequencyObj {
    private String token;
    public String action = "updateDebtCompoundFrequency";
    private String debtID;
    private Integer debtCompoundFrequency;
    public UpdateDebtCompoundFrequencyObj(String token, String debtID, Integer debtCompoundFrequency) {
        this.token = token;
        this.debtID = debtID;
        this.debtCompoundFrequency = debtCompoundFrequency;
    }
}

class UpdateDebtTotalPaidObj {
    private String token;
    public String action = "updateDebtTotalPaid";
    private String debtID;
    private Double debtTotalPaid;
    public UpdateDebtTotalPaidObj(String token, String debtID, Double debtTotalPaid) {
        this.token = token;
        this.debtID = debtID;
        this.debtTotalPaid = debtTotalPaid;
    }
}

class UpdateDebtFinishedObj {
    private String token;
    public String action = "updateDebtFinished";
    private String debtID;
    public UpdateDebtFinishedObj(String token, String debtID) {
        this.token = token;
        this.debtID = debtID;
    }
}

class ActivateDebtObj {
    private String token;
    public String action = "activateDebt";
    private String debtID;
    public ActivateDebtObj(String token, String debtID) {
        this.token = token;
        this.debtID = debtID;
    }
}

class DisableDebtObj {
    private String token;
    public String action = "disableDebt";
    private String debtID;
    public DisableDebtObj(String token, String debtID) {
        this.token = token;
        this.debtID = debtID;
    }
}
