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






