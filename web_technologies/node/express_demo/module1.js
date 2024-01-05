arr = [
  { nm: "user1", passwd: "pass1" },
  { nm: "user2", passwd: "pass2" },
];

exports.validateUser = (uname, pass) => {
  var user = arr.find((obj) => obj.nm === uname && obj.passwd === pass);
  if (user === undefined) {
    arr.push({ nm: uname, passwd: pass });
    console.log(arr);
  }
  return user == undefined ? null : user;
};

exports.addition = (num1, num2) => {
  if (num1 != null && num2 != null) {
    return num1 + num2;
  }
};

exports.factorial = (n) => {
  var f = 1;
  for (var i = 1; i <= n; i++) {
    f = f * i;
  }
  return f;
};
