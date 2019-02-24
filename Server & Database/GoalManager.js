// TODO: Parameter validation

// Retrieves all goals for the given user
function retrieveGoals(token) {
  try {
    var userData = validateToken(token);
    var userEmail = userData.email;
    var fetchQuery = 'SELECT * FROM Goals WHERE email=?;';
    var parameters = [userEmail];
    var res = executeGetQuery(fetchQuery, parameters);
    var goalsObj = {};
    goalsObj.goalsArr = [];
    while (res.next()) {
      var newGoal = {};
      newGoal.goalID = res.getString("goalID");
      newGoal.goalName = res.getString("goalName");
      newGoal.goalAmount = res.getString("goalAmount");
      newGoal.amountSaved = res.getString("amountSaved");
      newGoal.dateAdded = convertDate(res.getString("dateAdded"));
      newGoal.dateFinished = convertDate(res.getString("dateFinished"));
      newGoal.active = res.getString("active");
      newGoal.lastUpdated = convertDate(res.getString("lastUpdated"));
      goalsObj.goalsArr.push(newGoal);
    }
    goalsObj.count = goalsObj.goalsArr.length;
    return goalsObj;
  }
  catch (err) {
    var t = err.message;
    throw new Error( "Error retrieving goals!" );
  }
}

// Retrieves the goal for the given user and goalID
function retrieveGoalByID(token, goalID) {
  try {
    var userData = validateToken(token);
    var userEmail = userData.email;
    var fetchQuery = 'SELECT * FROM Goals WHERE email=? AND goalID=?;';
    var parameters = [userEmail, goalID];
    var res = executeGetQuery(fetchQuery, parameters);
    var goalObj = {};
    if (res.next()) {
      goalObj.goalID = res.getString("goalID");
      goalObj.goalName = res.getString("goalName");
      goalObj.goalAmount = res.getString("goalAmount");
      goalObj.amountSaved = res.getString("amountSaved");
      goalObj.dateAdded = convertDate(res.getString("dateAdded"));
      goalObj.dateFinished = convertDate(res.getString("dateFinished"));
      goalObj.active = res.getString("active");
      goalObj.lastUpdated = convertDate(res.getString("lastUpdated"));
    }
    else {
      throw new Error( "No such goal found!" );
    }
    return goalObj;
  }
  catch (err) {
    throw new Error( "Error retrieving goal!" );
  }
}

// Create a new goal in the database for the given user
function createNewGoal(token, goalName, goalAmount, amountSaved) {
  
  try {
    var userData = validateToken(token);
    var userEmail = userData.email;
    var goalID = Math.floor((new Date().getTime()/1000)).toString() + getGuid();
    var createQuery = 'INSERT INTO Goals (email, goalID, goalName, goalAmount, amountSaved, dateAdded, dateFinished, active, lastUpdated) VALUES (?, ?, ?, ?, ?, CURDATE(), NULL, 1, CURRENT_TIMESTAMP);';
    var parameters = [userEmail, goalID, goalName, goalAmount, amountSaved];
    executeManipulationQuery(createQuery, parameters);
    return retrieveGoalByID(token, goalID);
  }
  catch (err) {
    throw new Error( "Error creating this goal!" );
  }
}

// Delete a goal from the database
function deleteGoalByID(token, goalID) {
  try {
    var userData = validateToken(token);
    var userEmail = userData.email;
    var createQuery = 'DELETE FROM Goals WHERE email=? AND goalID=?;';
    var parameters = [userEmail, goalID];
    executeManipulationQuery(createQuery, parameters);
    return "Success";
  }
  catch (err) {
    throw new Error( "Error deleting goal!" );
  }
}

// Update the goal name in the database
function updateGoalName(token, goalID, newGoalName) {
  try {
    var userData = validateToken(token);
    var userEmail = userData.email;
    var updateQuery = 'UPDATE Goals SET goalName=?, lastUpdated=CURRENT_TIMESTAMP WHERE email=? AND goalID=?;';
    var parameters = [newGoalName, userEmail, goalID];
    executeManipulationQuery(updateQuery, parameters);
    return "Success";
  }
  catch (err) {
    throw new Error( "Error modifying goals!" );
  }
}

// Update the goal amount in the database
function updateGoalAmount(token, goalID, newGoalAmount) {
  try {
    var userData = validateToken(token);
    var userEmail = userData.email;
    var updateQuery = 'UPDATE Goals SET goalAmount=?, lastUpdated=CURRENT_TIMESTAMP WHERE email=? AND goalID=?;';
    var parameters = [newGoalAmount, userEmail, goalID];
    executeManipulationQuery(updateQuery, parameters);
    return "Success";
  }
  catch (err) {
    throw new Error( "Error modifying goals!" );
  }
}

// Update the goal amount saved in the database
function updateGoalAmountSaved(token, goalID, newAmountSaved) {
  try {
    var userData = validateToken(token);
    var userEmail = userData.email;
    var updateQuery = 'UPDATE Goals SET amountSaved=?, lastUpdated=CURRENT_TIMESTAMP WHERE email=? AND goalID=?;';
    var parameters = [newAmountSaved, userEmail, goalID];
    executeManipulationQuery(updateQuery, parameters);
    return "Success";
  }
  catch (err) {
    throw new Error( "Error modifying goals!" );
  }
}

// Update the goal to finished on the current date in the database
function updateGoalFinished(token, goalID) {
  try {
    var userData = validateToken(token);
    var userEmail = userData.email;
    var updateQuery = 'UPDATE Goals SET dateFinished=CURDATE(), lastUpdated=CURRENT_TIMESTAMP WHERE email=? AND goalID=?;';
    var parameters = [userEmail, goalID];
    executeManipulationQuery(updateQuery, parameters);
    return "Success";
  }
  catch (err) {
    throw new Error( "Error modifying goals!" );
  }
}

// Activate a goal
function activateGoal(token, goalID) {
  try {
    var userData = validateToken(token);
    var userEmail = userData.email;
    var updateQuery = 'UPDATE Goals SET active=1, lastUpdated=CURRENT_TIMESTAMP WHERE email=? AND goalID=?;';
    var parameters = [userEmail, goalID];
    executeManipulationQuery(updateQuery, parameters);
    return "Success";
  }
  catch (err) {
    throw new Error( "Error modifying goals!" );
  }
}

// Disable a goal
function disableGoal(token, goalID) {
  try {
    var userData = validateToken(token);
    var userEmail = userData.email;
    var updateQuery = 'UPDATE Goals SET active=0, lastUpdated=CURRENT_TIMESTAMP WHERE email=? AND goalID=?;';
    var parameters = [userEmail, goalID];
    executeManipulationQuery(updateQuery, parameters);
    return "Success";
  }
  catch (err) {
    throw new Error( "Error modifying goals!" );
  }
}
