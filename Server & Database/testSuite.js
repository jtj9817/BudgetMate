// https://developers.google.com/oauthplayground/
var currToken = "ya29.Glu6Bndke5PjQGcQInwDjkm1W_OjB6SEouyHoecU5TDGYgrTDXsRQr_SOQmKAzDenqsf9eBpGfm_Osa0_C2_LXdwGLGkWb5V4gcjrnQ7BR-Zc1NoSHoFGc_mOcSJ";

function runTest(obj) {
  var content = JSON.parse('{"parameter":{},"contextPath":"","contentLength":51,"queryString":"","parameters":{},"postData":{"type":"text/plain","length":51,"contents":"","name":"postData"}}');
  content.postData.contents = JSON.stringify(obj);
  return doPost(content);
}

// ========================== //
// ========== User ========== //
// ========================== //

function testRetrieveUser() {
  var obj = {
	"action":"retrieveUser",
	"token":currToken
  }
  var result = runTest(obj);
  var t = 0;
}

function testRegisterUser() {
  var obj = {
	"action":"registerUser",
	"token":currToken
  }
  var result = runTest(obj);
  var t = 0;
}



// ========================== //
// ========== Goal ========== //
// ========================== //

function testRetrieveGoals() {
  var obj = {
	"action":"retrieveGoals",
	"token":currToken
  }
  var result = runTest(obj);
  var t = 0;
}

function testCreateGoal() {
  var obj = {
	"action":"createNewGoal",
	"token":currToken,
    "goalName":"New PC",
    "goalAmount":2500,
    "goalAmountSaved":500
  }
  var result = runTest(obj);
  var t = 0;
}

function testDeleteGoal() {
  var obj = {
	"action":"deleteGoal",
	"token":currToken,
    "goalID":"1550922975d4fe0b11fcda6960",
  }
  var result = runTest(obj);
  var t = 0;
}

function testUpdateGoalName() {
  var obj = {
	"action":"updateGoalName",
	"token":currToken,
    "goalID":"goal1",
    "goalName":"Fancy new car"
  }
  var result = runTest(obj);
  var t = 0;
}

function testUpdateGoalAmount() {
  var obj = {
	"action":"updateGoalAmount",
	"token":currToken,
    "goalID":"goal1",
    "goalAmount":12000
  }
  var result = runTest(obj);
  var t = 0;
}

function updateGoalAmountSaved() {
  var obj = {
	"action":"updateGoalAmountSaved",
	"token":currToken,
    "goalID":"goal1",
    "goalAmountSaved":6000
  }
  var result = runTest(obj);
  var t = 0;
}

function testUpdateGoalFinished() {
  var obj = {
	"action":"updateGoalFinished",
	"token":currToken,
    "goalID":"goal1"
  }
  var result = runTest(obj);
  var t = 0;
}

function testActivateGoal() {
  var obj = {
	"action":"activateGoal",
	"token":currToken,
    "goalID":"goal1"
  }
  var result = runTest(obj);
  var t = 0;
}

function testDisableGoal() {
  var obj = {
	"action":"disableGoal",
	"token":currToken,
    "goalID":"goal1"
  }
  var result = runTest(obj);
  var t = 0;
}



// ========================== //
// ========== Debt ========== //
// ========================== //

function testRetrieveDebts() {
  var obj = {
	"action":"retrieveDebts",
	"token":currToken
  }
  var result = runTest(obj);
  var t = 0;
}

function testCreateDebt() {
  var obj = {
	"action":"createNewDebt",
	"token":currToken,
    "debtName":"Furniture",
    "debtInitial":1200,
    "debtCurrent":700,
    "interestRate":0.035,
    "compoundFrequency":30,
    "totalPaid":550
  }
  var result = runTest(obj);
  var t = 0;
}

function testDeleteDebt() {
  var obj = {
	"action":"deleteDebt",
	"token":currToken,
    "debtID":"15509212628044bb7abd934f22",
  }
  var result = runTest(obj);
  var t = 0;
}

function testUpdateDebtName() {
  var obj = {
	"action":"updateDebtName",
	"token":currToken,
    "debtID":"debt1",
    "debtName":"Debt Name 2"
  }
  var result = runTest(obj);
  var t = 0;
}

function testUpdateDebtInitial() {
  var obj = {
	"action":"updateDebtInitial",
	"token":currToken,
    "debtID":"debt1",
    "debtInitial":1600
  }
  var result = runTest(obj);
  var t = 0;
}

function testUpdateDebtCurrent() {
  var obj = {
	"action":"updateDebtCurrent",
	"token":currToken,
    "debtID":"debt1",
    "debtCurrent":900
  }
  var result = runTest(obj);
  var t = 0;
}

function testUpdateDebtInterestRate() {
  var obj = {
	"action":"updateDebtInterestRate",
	"token":currToken,
    "debtID":"debt1",
    "debtInterestRate":0.04
  }
  var result = runTest(obj);
  var t = 0;
}

function testUpdateDebtCompoundFrequency() {
  var obj = {
	"action":"updateDebtCompoundFrequency",
	"token":currToken,
    "debtID":"debt1",
    "debtCompoundFrequency":60
  }
  var result = runTest(obj);
  var t = 0;
}

function testUpdateDebtTotalPaid() {
  var obj = {
	"action":"updateDebtTotalPaid",
	"token":currToken,
    "debtID":"debt1",
    "debtTotalPaid":750
  }
  var result = runTest(obj);
  var t = 0;
}

function testUpdateDebtFinished() {
  var obj = {
	"action":"updateDebtFinished",
	"token":currToken,
    "debtID":"debt1"
  }
  var result = runTest(obj);
  var t = 0;
}

function testActivateDebt() {
  var obj = {
	"action":"activateDebt",
	"token":currToken,
    "debtID":"debt1"
  }
  var result = runTest(obj);
  var t = 0;
}

function testDisableDebt() {
  var obj = {
	"action":"disableDebt",
	"token":currToken,
    "debtID":"debt1"
  }
  var result = runTest(obj);
  var t = 0;
}
