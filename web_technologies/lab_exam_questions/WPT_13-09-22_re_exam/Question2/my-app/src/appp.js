let accountArray = [];

function saveInfo() {
  const accountId = $("#accountId").val();
  const accountName = $("#accountName").val();
  const accountType = $("#accountType").val();
  const balance = $("#balance").val();
  const creationDate = $("#creationDate").val();

  // Validate
  if (!accountName || !accountType || !balance || !creationDate) {
    alert("All fields are mandatory.");
    return;
  }

  if (isNaN(balance) || balance < 5000) {
    alert("Balance must be numeric and cannot be below Rs 5000.");
    return;
  }

  const accountInfo = {
    accountId,
    accountName,
    accountType,
    balance,
    creationDate,
  };

  accountArray.push(accountInfo);
  alert("Account information saved successfully!");
}

function displayAccountInfo() {
  console.log("Account Information:");
  console.table(accountArray);
}
// ... other code ...

// ... other code ...

$(document).ready(function () {
  $("#saveInfoButton").click(function () {
    saveInfo();
  });
});

// ... other code ...

// ... other code ...
