const express = require("express");
var router = express.Router(); //in this router obj we will add all the paths and then export it and access those from app.js
//this above router obj and routes obj in app.js is same ref to heap location
const connection = require("../db/db_connect");

router.get("/products", (req, resp) => {
  connection.query("select * from products", (err, data, fields) => {
    if (err) {
      console.log("error while querying: ", err);
      resp.status(500).send("<h1>no data found</h1>"); //as this rets html hence it is webapp
      //is json.--- ... then it is web service
    } else {
      console.log(data);
      resp.send(data); //send data in array format
      //form appears in react,
      //expresswebservice //url should have only nouns NOT verbs
      //|get|http://localhost:9090/products|will read all products|
      //|get|http://localhost:9090/products/product/:pnum|will read a product|
      //|post|http://localhost:9090/products/product/:pnum|will create or add data in db|
      //|put|http://localhost:9090/products/product/:pnum|will update  data in db|
      //|delete|http://localhost:9090/products/product/:pnum|will delete  data in db|
    }
  });
});

//add new product received via request body and add it in db
router.post("/products/product/:pnum", (req, resp) => {
  console.log("adding product");
  connection.query(
    "insert into products values (?,?,?,?)",
    [req.body.pid, req.body.pname, req.body.qty, req.body.price],
    (err, result) => {
      if (err) {
        console.log(err);
        resp.status(500).send("<h3>no data found</h3>");
      } else {
        console.log(result);
        resp.status(200).send("data added successfully");
      }
    }
  );
});

//delete product from the db whose id is received via params
router.delete("/products/product/:pnum", function (req, resp) {
  connection.query("delete from products where pid=?", [req.params.pnum], function (err, result) {
    if (err) {
      console.log(err);
      resp.status(500).send("<h3>no data found</h3>");
    } else {
      console.log(result);
      resp.status(200).send("data deleted successfully");
    }
  });
});

//retireve details of one roduct with id received via params pnum
router.get("/products/product/:pnum", function (req, resp) {
  connection.query("select * from products where pid=?", [req.params.pnum], function (err, data) {
    if (err) {
      console.log(err);
      resp.status(500).send("<h3>no data found</h3>");
    } else {
      console.log(data);
      resp.send(data[0]);
    }
  });
});

//update product received via reqeust body and update in db
router.put("/products/product/:pnum", function (req, resp) {
  connection.query(
    "update products set pname=?,qty=?,price=? where pid=?",
    [req.body.pname, req.body.qty, req.body.price, req.body.pid],
    function (err, result) {
      if (err) {
        console.log(err);
        resp.status(500).send("<h3>no data updated</h3>");
      } else {
        console.log(result);
        resp.status(200).send("data updated");
      }
    }
  );
});

//this is same object routes in app.js
module.exports = router;
