Hosted on Google Apps Script Web App
https://script.google.com/macros/s/AKfycbxtoBjl9VmuRsInYbCEcGHOve9y2aMbD8BFd6Lpkl__BVVLFFU/exec

This web app handles the server side requests and connects to the MySQL database hosted on Google Cloud Platform (jdbc:google:mysql://affable-operand-232600:us-central1:htv-3-project/HTV3_DB)

It handles POST requests with JSON data containing the requested action to perform, a Google token, and any other requested parameters

It validates the Google token to retrieve user info or create a new user on the database or perform the requesting action like creating, updating or deleting user goal and debts on the database

It returns a JSON object with fields containing a boolean showing if the operation was successful, an error message that's filled if there was an error, and a results string containing either a success message or a JSON object with the requested data such as user info or goals and debts info.

It also has a testing suite to test all the functions given a oAuth v2 token which can be obtained easily from https://developers.google.com/oauthplayground/