// Validates the given token and if valid, return the user's info
function validateToken(token) {
  var URL = "https://www.googleapis.com/oauth2/v1/tokeninfo?access_token="+token;
  var response = UrlFetchApp.fetch(URL);
  return JSON.parse(response.getContentText());
}

// Generates a random guid
function getGuid() {
  var guid = 'xxxxxxxxxxxxxxxx'.replace(/[xy]/g,
      function(c) {
        var r = Math.random() * 16 | 0, v = c == 'x' ? r : (r & 0x3 | 0x8);
        return v.toString(16);
      });
  return guid;
}

function convertDate(dateStr) {
  if (dateStr == null) {
    return null;
  }
  else {
    return moment(dateStr).toISOString();
  }
}
