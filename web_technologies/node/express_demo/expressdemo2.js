const express = require("express");
const bodyParser = require("body-parser");

var app = express();

app.use((req, resp, next) => {
  console.log("first middlware");
  next();
});

app.get("/home", (req, resp) => {
  resp.sendFile("/public/hello.html", { root: __dirname }); //.sendFile -> sending response through the file
  //__dirname -> where to find mentioned(/public/hello.html file) file,        __ is called dunder
});

app.get("/aboutus", function (req, resp) {
  resp.send("<h1>in about us</h1>");
});

app.listen(9090, () => {
  console.log("listening on 9090");
});
