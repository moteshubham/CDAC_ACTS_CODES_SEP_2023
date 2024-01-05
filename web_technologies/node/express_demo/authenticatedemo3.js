const express = require("express");
import bodyParser from "body-parser";
var app = express();
const m1 = require("./module1");
//this is middleware which helps to parse the url and separate data from the url
//it will generate object by name query in req object if method is get, POST -> query obj
//it will generate object by name body in req object if the method is post, POST -> body obj
app.use(bodyParser.urlencoded({ extended: false })); //data is always in text format
app.use((req, resp, next) => {
  console.log("first middlewart");
});

app.get("/login", function (req, resp) {
  resp.sendFile("/public/login.html", { root: __dirname });
});

app.post("/validate", function (req, resp) {
  var u = m1.validateUser(req.body.uname, req.body.pass);
  if (u != null) {
    resp.sendFile("/public/form.html", { root: __dirname });
  } else {
    resp.send("<h1>invalid user</h1>");
  }
});

app.get("/calculate", (req, resp) => {
  var num1 = parseInt(req.query.num1);
  var num2 = parseInt(req.query.num2);
  var btn = req.query.btn;
  if (btn == "add") {
    var result = m1.addition(num1, num2)
    if(result){
      resp.send( resp.send("<h1>Addition : "+result+"</h1>" ))
    }
  }else{
    var ans=m1.factorial(num1);
    resp.send("<h1>Factorial : "+result+"</h1>" )
} 
});

app.listen(9090, () => {
  console.log("server started");
});
