//import express library
const express = require("express");
//create express object
var app = express();

//define middleware---middlewares are the functions which you want to execute
//for every request, It is common functionality for all urls
//it will generate a object by name query in req object if method is get
//it will generate object by name body in req object if the method is post
app.use((req, resp, next) => {  //request may come from any url, so for any url -> use app.use() else app.get or app.post
  console.log("this is the first middleware");
  console.log("url : " + req.url);
  next(); //go to next middleware
});

app.use((req, resp, next) => {
  console.log("this is second middlewaree");
  console.log("url : " + req.url);
  next(); 
});
//router modules
app.get("/home", (req, resp) => {
  resp.send("<h1> this is Home page</h1>");
});

app.get("/aboutus", (req, resp) => {
  var str = "<h1>this is About us page</h1>";
  str += "<h2> content goes heree</h2>";
  resp.send(str);
});

app.listen(9090, () => {
  console.log("server listening on port 9090");
});
