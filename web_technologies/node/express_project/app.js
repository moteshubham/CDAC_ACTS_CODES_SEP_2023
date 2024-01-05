//webservice

const express = require("express")
const app = express();
const bodyParser = require("body-parser")
const path = require("path")
const routes = require("./routes/router")
//Cors seetings need to be added while connection from react app

app.set(express.static(path.join(__dirname, "public")));


app.use(bodyParser.urlencoded({extended:false})); //takes care of request params, query
app.use(bodyParser.json())  //takes care of converting json data
//define route handlers
app.use("/", routes); //every link pass it to routes
app.listen(9090, () => {//start the server
  console.log("server on 9090");
});

module.exports = app

//STEP 5: create routes/router.js -- there you will need db conn so
//STEP 6: create db_connect.js in db for db connecting configs
//STEP 7: create views