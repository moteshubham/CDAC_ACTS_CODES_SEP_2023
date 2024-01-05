//STEP 1: create folder structure -> model, views, routes, db, public, app.js
//STEP 2: in app.js, import all needed libraries

const express = require("express")
const app = express();
const bodyParser = require("body-parser")
const path = require("path")
const routes = require("./routes/router")

//STEP 3: configure the app
//find all views in views folder and extnesion 
//of the file is ejs
app.set("views", path.join(__dirname, "views")); // views is property available in dirnmae-views folder
app.set("view engine", "ejs"); //setting view engine to ejs, ejs is suffix and views is prefix

//STEP 4: to add static references
app.set(express.static(path.join(__dirname, "public")));

//define middlewares
app.use("/css", express.static(path.join(__dirname, "public/css"))); //here join is used instead of + to concatenate coz join removes the special chars else we have to it
app.use(bodyParser.urlencoded({extended:false}));

//define route handlers
app.use("/", routes); //every link pass it to routes
app.listen(9090, () => {//start the server
  console.log("server on 9090");
});


//STEP 5: create routes/router.js -- there you will need db conn so
//STEP 6: create db_connect.js in db for db connecting configs
//STEP 7: create views