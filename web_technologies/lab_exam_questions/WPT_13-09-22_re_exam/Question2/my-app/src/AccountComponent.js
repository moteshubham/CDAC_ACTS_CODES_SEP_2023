// AccountComponent.js
import React from "react";

const AccountComponent = ({ account }) => {
  return (
    <table className="table">
      <thead>
        <tr>
          <th>Account ID</th>
          <th>Account Name</th>
          <th>Account Type</th>
          <th>Balance</th>
          <th>Creation Date</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>{account.accountId}</td>
          <td>{account.accountName}</td>
          <td>{account.accountType}</td>
          <td>{account.balance}</td>
          <td>{account.creationDate}</td>
        </tr>
      </tbody>
    </table>
  );
};

export default AccountComponent;
