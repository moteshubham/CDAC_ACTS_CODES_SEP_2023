const express = require("express")
const bodyParser = require("body-parser")
const app = express()
const routes = require("./routes/router");



app.use((req,res,next) => {
  res.setHeader("Access-Control-Allow-Origin","*"); /* @dev First, read about security */
  res.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
  res.setHeader("Access-Control-Max-Age", 2592000); // 30 days
  res.setHeader("Access-Control-Allow-Credentials", true);
  res.setHeader("Access-Control-Allow-Headers", "content-type");
  next();
});


app.use(bodyParser.json())
app.use(bodyParser.urlencoded({extended:false}))

app.use('/',routes);


app.listen(8080, () => {
  console.log("server on 8080")
})
