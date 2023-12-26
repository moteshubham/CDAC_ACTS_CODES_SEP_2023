//STEP 1: create folder structure -> model, views, routes, db, public, app.js
//STEP 2: in app.js, import all needed libraries

const express = require("express")
//import { express } from "express";
const app = express();
//import { bodyParser } from "body-parser";
const bodyParser = require("body-parser")
//import { path } from "path";
const path = require("path")
//import { routes } from "./routes/router";
const routes = require("./routes/router")
//STEP 3: configure the app
app.set("views", path.join(__dirname, "views")); // views is property available in dirnmae-views folder
app.set("view engine", "ejs"); //setting view engine to ejs, ejs is suffix and views is prefix

//STEP 4: to add static references
app.set(express.static(path.join(__dirname, "public")));
app.use("/css", express.static(path.join(__dirname, "public/css"))); //here join is used instead of + to concatenate coz join removes the special chars else we have to it
app.use(bodyParser.urlencoded({extended:false}));
app.use("/", routes); //every link pass it to routes
app.listen(9090, () => {
  console.log("server on 9090");
});


//STEP 5: create routes/router.js -- there you will need db conn so
//STEP 6: create db_connect.js in db for db connecting configs