// TODO: Parameter validation

// Retrieves all debts for the given user
function retrieveDebts(token) {
  try {
    var userData = validateToken(token);
    var userEmail = userData.email;
    var fetchQuery = 'SELECT * FROM Debts WHERE email=?;';
    var parameters = [userEmail];
    var res = executeGetQuery(fetchQuery, parameters);
    var debtsObj = {};
    debtsObj.debtsArr = [];
    while (res.next()) {
      var newDebt = {};
      newDebt.debtID = res.getString("debtID");
      newDebt.debtName = res.getString("debtName");
      newDebt.debtInitial = res.getString("debtInitial");
      newDebt.debtCurrent = res.getString("debtCurrent");
      newDebt.interestRate = res.getString("interestRate");
      newDebt.compoundFrequency = res.getString("compoundFrequency");
      newDebt.totalPaid = res.getString("totalPaid");
      newDebt.dateAdded = convertDate(res.getString("dateAdded"));
      newDebt.dateFinished = convertDate(res.getString("dateFinished"));
      newDebt.active = res.getString("active");
      newDebt.interestLastApplied = convertDate(res.getString("interestLastApplied"));
      newDebt.lastUpdated = convertDate(res.getString("lastUpdated"));
      debtsObj.debtsArr.push(newDebt);
    }
    debtsObj.count = debtsObj.debtsArr.length;
    return debtsObj;
  }
  catch (err) {
    throw new Error( "Error retrieving debts!" );
  }
}

// Retrieves the debt for the given user and debtID
function retrieveDebtByID(token, debtID) {
  try {
    var userData = validateToken(token);
    var userEmail = userData.email;
    var fetchQuery = 'SELECT * FROM Debts WHERE email=? AND debtID=?;';
    var parameters = [userEmail, debtID];
    var res = executeGetQuery(fetchQuery, parameters);
    var debtObj = {};
    if (res.next()) {
      debtObj.debtID = res.getString("debtID");
      debtObj.debtName = res.getString("debtName");
      debtObj.debtInitial = res.getString("debtInitial");
      debtObj.debtCurrent = res.getString("debtCurrent");
      debtObj.interestRate = res.getString("interestRate");
      debtObj.compoundFrequency = res.getString("compoundFrequency");
      debtObj.totalPaid = res.getString("totalPaid");
      debtObj.dateAdded = convertDate(res.getString("dateAdded"));
      debtObj.dateFinished = convertDate(res.getString("dateFinished"));
      debtObj.active = res.getString("active");
      debtObj.interestLastApplied = convertDate(res.getString("interestLastApplied"));
      debtObj.lastUpdated = convertDate(res.getString("lastUpdated"));
    }
    else {
      throw new Error( "No such debt found!" );
    }
    return debtObj;
  }
  catch (err) {
    throw new Error( "Error retrieving debt!" );
  }
}

// Create a new debt in the database for the given user
function createNewDebt(token, debtName, debtInitial, debtCurrent, interestRate, compoundFrequency, totalPaid) {
  
  try {
    var userData = validateToken(token);
    var userEmail = userData.email;
    var debtID = Math.floor((new Date().getTime()/1000)).toString() + getGuid();
    var createQuery = 'INSERT INTO Debts (email, debtID, debtName, debtInitial, debtCurrent, interestRate, compoundFrequency, totalPaid, dateAdded, dateFinished, active, interestLastApplied, lastUpdated) VALUES (?, ?, ?, ?, ?, ?, ?, ?, CURDATE(), NULL, 1, CURDATE(), CURRENT_TIMESTAMP);';
    var parameters = [userEmail, debtID, debtName, debtInitial, debtCurrent, interestRate, compoundFrequency, totalPaid];
    executeManipulationQuery(createQuery, parameters);
    return retrieveDebtByID(token, debtID);
  }
  catch (err) {
    throw new Error( "Error creating this debt!" );
  }
}

// Delete a debt from the database
function deleteDebtByID(token, debtID) {
  try {
    var userData = validateToken(token);
    var userEmail = userData.email;
    var createQuery = 'DELETE FROM Debts WHERE email=? AND debtID=?;';
    var parameters = [userEmail, debtID];
    executeManipulationQuery(createQuery, parameters);
    return "Success";
  }
  catch (err) {
    throw new Error( "Error deleting debt!" );
  }
}

// Update the debt name in the database
function updateDebtName(token, debtID, newDebtName) {
  try {
    var userData = validateToken(token);
    var userEmail = userData.email;
    var updateQuery = 'UPDATE Debts SET debtName=?, lastUpdated=CURRENT_TIMESTAMP WHERE email=? AND debtID=?;';
    var parameters = [newDebtName, userEmail, debtID];
    executeManipulationQuery(updateQuery, parameters);
    return "Success";
  }
  catch (err) {
    throw new Error( "Error modifying debts!" );
  }
}

// Update the debt initial amount in the database
function updateDebtInitial(token, debtID, newDebtInitial) {
  try {
    var userData = validateToken(token);
    var userEmail = userData.email;
    var updateQuery = 'UPDATE Debts SET debtInitial=?, lastUpdated=CURRENT_TIMESTAMP WHERE email=? AND debtID=?;';
    var parameters = [newDebtInitial, userEmail, debtID];
    executeManipulationQuery(updateQuery, parameters);
    return "Success";
  }
  catch (err) {
    throw new Error( "Error modifying debts!" );
  }
}

// Update the debt current amount in the database
function updateDebtCurrent(token, debtID, newDebtCurrent) {
  try {
    var userData = validateToken(token);
    var userEmail = userData.email;
    var updateQuery = 'UPDATE Debts SET debtCurrent=?, lastUpdated=CURRENT_TIMESTAMP WHERE email=? AND debtID=?;';
    var parameters = [newDebtCurrent, userEmail, debtID];
    executeManipulationQuery(updateQuery, parameters);
    return "Success";
  }
  catch (err) {
    throw new Error( "Error modifying debts!" );
  }
}

// Update the debt interest rate in the database
function updateDebtInterestRate(token, debtID, newInterestRate) {
  try {
    var userData = validateToken(token);
    var userEmail = userData.email;
    var updateQuery = 'UPDATE Debts SET interestRate=?, lastUpdated=CURRENT_TIMESTAMP WHERE email=? AND debtID=?;';
    var parameters = [newInterestRate, userEmail, debtID];
    executeManipulationQuery(updateQuery, parameters);
    return "Success";
  }
  catch (err) {
    throw new Error( "Error modifying debts!" );
  }
}

// Update the debt compound frequency in the database
function updateDebtCompoundFrequency(token, debtID, newCompoundFrequency) {
  try {
    var userData = validateToken(token);
    var userEmail = userData.email;
    var updateQuery = 'UPDATE Debts SET compoundFrequency=?, lastUpdated=CURRENT_TIMESTAMP WHERE email=? AND debtID=?;';
    var parameters = [newCompoundFrequency, userEmail, debtID];
    executeManipulationQuery(updateQuery, parameters);
    return "Success";
  }
  catch (err) {
    throw new Error( "Error modifying debts!" );
  }
}

// Update the debt total paid in the database
function updateDebtTotalPaid(token, debtID, newTotalPaid) {
  try {
    var userData = validateToken(token);
    var userEmail = userData.email;
    var updateQuery = 'UPDATE Debts SET totalPaid=?, lastUpdated=CURRENT_TIMESTAMP WHERE email=? AND debtID=?;';
    var parameters = [newTotalPaid, userEmail, debtID];
    executeManipulationQuery(updateQuery, parameters);
    return "Success";
  }
  catch (err) {
    throw new Error( "Error modifying debts!" );
  }
}

// Update the debt to finished on the current date in the database
function updateDebtFinished(token, debtID) {
  try {
    var userData = validateToken(token);
    var userEmail = userData.email;
    var updateQuery = 'UPDATE Debts SET dateFinished=CURDATE(), lastUpdated=CURRENT_TIMESTAMP WHERE email=? AND debtID=?;';
    var parameters = [userEmail, debtID];
    executeManipulationQuery(updateQuery, parameters);
    return "Success";
  }
  catch (err) {
    throw new Error( "Error modifying debts!" );
  }
}

// Activate a debt
function activateDebt(token, debtID) {
  try {
    var userData = validateToken(token);
    var userEmail = userData.email;
    var updateQuery = 'UPDATE Debts SET active=1, lastUpdated=CURRENT_TIMESTAMP WHERE email=? AND debtID=?;';
    var parameters = [userEmail, debtID];
    executeManipulationQuery(updateQuery, parameters);
    return "Success";
  }
  catch (err) {
    throw new Error( "Error modifying debts!" );
  }
}

// Disable a debt
function disableDebt(token, debtID) {
  try {
    var userData = validateToken(token);
    var userEmail = userData.email;
    var updateQuery = 'UPDATE Debts SET active=0, lastUpdated=CURRENT_TIMESTAMP WHERE email=? AND debtID=?;';
    var parameters = [userEmail, debtID];
    executeManipulationQuery(updateQuery, parameters);
    return "Success";
  }
  catch (err) {
    throw new Error( "Error modifying debts!" );
  }
}
