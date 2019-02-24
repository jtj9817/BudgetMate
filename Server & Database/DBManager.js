var dbConfig = {
  connStr: "jdbc:google:mysql://affable-operand-232600:us-central1:htv-3-project/HTV3_DB",
  user: "root",
  pass: "Dyoo7BNJ7zmHpaK5"  
}

// Connects to the database
function obtainConnection() {
  return Jdbc.getCloudSqlConnection(dbConfig.connStr, dbConfig.user, dbConfig.pass);
}

// Executes a query that retrieves info from the database and returns a JdbcResultSet
function executeGetQuery(query, parameters) {
  var conn = obtainConnection();
  
  // Using prepared statements to prevent SQL injection
  var stmt = conn.prepareStatement(query);
  for (var i = 0; i < parameters.length; i++) {
    if (!isNaN(parameters[i])) {
      stmt.setInt(i+1, parameters[i]);
    }
    else {
      stmt.setString(i+1, parameters[i]);
    }
  }
  
  var result = stmt.executeQuery();
  return result;
}

// Executes a query that manipulates the database
function executeManipulationQuery(query, parameters) {
  var conn = obtainConnection();
  
  // Using prepared statements to prevent SQL injection
  var stmt = conn.prepareStatement(query);
  for (var i = 0; i < parameters.length; i++) {
    if (!isNaN(parameters[i])) {
      stmt.setInt(i+1, parameters[i]);
    }
    else {
      stmt.setString(i+1, parameters[i]);
    }
  }

  var result = stmt.execute();
  stmt.close();
  conn.close();
}
