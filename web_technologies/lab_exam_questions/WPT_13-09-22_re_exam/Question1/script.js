function saveInfo() {
  // Validate form
  if (validateForm()) {
    // Create JavaScript object with form values
    var accountInfo = {
      accountId: document.getElementById("accountId").value,
      accountName: document.getElementById("accountName").value,
      accountType: document.getElementById("accountType").value,
      balance: parseFloat(document.getElementById("balance").value),
      creationDate: document.getElementById("creationDate").value,
    }

    // Initialize array or use existing one
    var accountArray = JSON.parse(localStorage.getItem("accountArray")) || []

    // Add new account info to array
    accountArray.push(accountInfo)

    // Store updated array in localStorage
    localStorage.setItem("accountArray", JSON.stringify(accountArray))

    alert("Account information saved successfully!")
  }
}

function displayInfo() {
  // Retrieve account information array from localStorage
  var accountArray = JSON.parse(localStorage.getItem("accountArray")) || []

  // Display account information in console
  console.log("Account Information:")
  console.log(accountArray)
}

function validateForm() {
  // Basic form validation
  var isValid = true

  // Check if balance is numeric and above Rs 5000
  var balance = parseFloat(document.getElementById("balance").value)
  if (isNaN(balance) || balance < 5000) {
    alert("Balance must be a numeric value and cannot be below Rs 5000.")
    isValid = false
  }

  return isValid
}
