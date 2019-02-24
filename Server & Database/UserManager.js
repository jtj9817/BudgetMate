// TODO: Parameter validation

// Retrieves the information of a user
function retrieveUser(token) {
  try {
    var userData = validateToken(token);
    var userEmail = userData.email;
    var fetchQuery = 'SELECT * FROM Users WHERE email=?;';
    var parameters = [userEmail];
    var res = executeGetQuery(fetchQuery, parameters);
    if (res.next()) {
      var userObj = {};
      userObj.email = res.getString("email");
      userObj.firstName = res.getString("firstName");
      userObj.lastName = res.getString("lastName");
      userObj.dateJoined = convertDate(res.getString("dateJoined"));
      userObj.lastConnected = convertDate(res.getString("lastConnected"));
      res.close();
      // TODO: Replace with MySQL trigger or similar
      try {
        var updateQuery = 'UPDATE Users SET lastConnected=CURRENT_TIMESTAMP WHERE email=?;';
        var parameters2 = [userEmail];
        executeManipulationQuery(updateQuery, parameters2);
      } catch (err) {}
      return userObj;
    }
    else {
      throw new Error( "No such user found!" );
    }
  }
  catch (err) {
    var t = err.message;
    throw new Error( "Error retrieving this user!" );
  }
}

// Registers a new user and returns the user info
function registerUser(token, firstName, lastName) {
  
  try {
    var userData = validateToken(token);
    var userEmail = userData.email;
    var createQuery = 'INSERT INTO Users (email, firstName, lastName, dateJoined, lastConnected) VALUES (?, ?, ?, CURDATE(), CURRENT_TIMESTAMP);';
    var parameters = [userEmail, firstName, lastName];
    executeManipulationQuery(createQuery, parameters);
    return retrieveUser(token);
  }
  catch (err) {
    throw new Error( "Error creating this user!" );
  }
}

// Change the user's name
function changeName(token, firstName, lastName) {
  
  // TODO: Implement
}
