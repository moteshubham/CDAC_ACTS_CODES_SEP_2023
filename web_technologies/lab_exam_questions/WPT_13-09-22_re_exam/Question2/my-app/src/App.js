import React from "react";
import AccountComponent from "./AccountComponent";

const App = () => {
  const accountArray = [
    {
      accountId: 101,
      accountName: "A R Patil",
      accountType: "Savings",
      balance: 75000,
      creationDate: "2021-02-19",
    },
    {
      accountId: 102,
      accountName: "Manisha Singh",
      accountType: "Savings",
      balance: 35000,
      creationDate: "2021-01-01",
    },
    {
      accountId: 103,
      accountName: "Pawan Kumar",
      accountType: "Current",
      balance: 5000,
      creationDate: "2021-02-10",
    },
  ];

  return (
    <div>
      <h2>Account Information</h2>
      {accountArray.map((account) => (
        <AccountComponent key={account.accountId} account={account} />
      ))}
    </div>
  );
};

export default App;
