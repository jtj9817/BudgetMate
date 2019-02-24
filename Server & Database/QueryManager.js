// Handles incoming POST requests
function doPost(e) {
  
  try {
    var JSONData = JSON.parse(e.postData.contents);
    var response = parseCommand(JSONData);
    return ContentService.createTextOutput(JSON.stringify(response));
  }
  catch (err) {
    throw new Error( "Unable to process API contents!" );
  }
}

// Parses the JSONData to determine which function to call and which parameters to use
function parseCommand(JSONData) {
  
  // Initialize the response object
  var response = {};
  response.successful = true;
  response.error = "";
  response.result = "";
  
  try {
    
    // Initialize variables
    var action = JSONData.action;
    var token = JSONData.token;
    var firstName = JSONData.firstName;
    var lastName = JSONData.lastName;
    var goalID = JSONData.goalID;
    var goalName = JSONData.goalName;
    var goalAmount = JSONData.goalAmount;
    var goalAmountSaved = JSONData.goalAmountSaved;
    var debtID = JSONData.debtID;
    var debtName = JSONData.debtName;
    var debtInitial = JSONData.debtInitial;
    var debtCurrent = JSONData.debtCurrent;
    var debtInterestRate = JSONData.debtInterestRate;
    var debtCompoundFrequency = JSONData.debtCompoundFrequency;
    var debtTotalPaid = JSONData.debtTotalPaid;
    
    // Calls the appropriate function using the given action
    // TODO: Determine if it is possible to use URL routes to improve this
    switch (action) {
      case "retrieveUser":
        var result = retrieveUser(token);
        break;
      case "registerUser":
        var result = registerUser(token, firstName, lastName);
        break;
      case "retrieveGoals":
        var result = retrieveGoals(token);
        break;
      case "createNewGoal":
        var result = createNewGoal(token, goalName, goalAmount, goalAmountSaved);
        break;
      case "deleteGoal":
        var result = deleteGoalByID(token, goalID);
        break;
      case "updateGoalName":
        var result = updateGoalName(token, goalID, goalName);
        break;
      case "updateGoalAmount":
        var result = updateGoalAmount(token, goalID, goalAmount);
        break;
      case "updateGoalAmountSaved":
        var result = updateGoalAmountSaved(token, goalID, goalAmountSaved);
        break;
      case "updateGoalFinished":
        var result = updateGoalFinished(token, goalID);
        break;
      case "activateGoal":
        var result = activateGoal(token, goalID);
        break;
      case "disableGoal":
        var result = disableGoal(token, goalID);
        break;
      case "retrieveDebts":
        var result = retrieveDebts(token);
        break;
      case "createNewDebt":
        var result = createNewDebt(token, debtName, debtInitial, debtCurrent, debtInterestRate, debtCompoundFrequency, debtTotalPaid);
        break;
      case "deleteDebt":
        var result = deleteDebtByID(token, debtID);
        break;
      case "updateDebtName":
        var result = updateDebtName(token, debtID, debtName);
        break;
      case "updateDebtInitial":
        var result = updateDebtInitial(token, debtID, debtInitial);
        break;
      case "updateDebtCurrent":
        var result = updateDebtCurrent(token, debtID, debtCurrent);
        break;
      case "updateDebtInterestRate":
        var result = updateDebtInterestRate(token, debtID, debtInterestRate);
        break;
      case "updateDebtCompoundFrequency":
        var result = updateDebtCompoundFrequency(token, debtID, debtCompoundFrequency);
        break;
      case "updateDebtTotalPaid":
        var result = updateDebtTotalPaid(token, debtID, debtTotalPaid);
        break;
      case "updateDebtFinished":
        var result = updateDebtFinished(token, debtID);
        break;
      case "activateDebt":
        var result = activateDebt(token, debtID);
        break;
      case "disableDebt":
        var result = disableDebt(token, debtID);
        break;
      default:
        response.successful = false;
        response.error = "Invalid API call!";
        break;
    }
    // If no error occured, embed the result in the response
    if (response.successful) {
      response.result = JSON.stringify(result);
    }
  }
  catch (err) {
    // Returns the error message if any occured
    response.successful = false;
    response.error = err.message;
  }
  return response;
}
