const express = require("express");
var router = express.Router(); //in this router obj we will add all the paths and then export it and access those from app.js
//this above router obj and routes obj in app.js is same ref to heap location
const connection = require("../db/db_connect");

router.get("/products", (req, resp) => {
  connection.query("select * from products", (err, data, fields) => {
    if (err) {
      console.log("error while querying: ", err);
      resp.status(500).send("<h1>no data</h1>"); //as this rets html hence it is webapp
      //is json.--- ... then it is web service
    } else {
      console.log(data);
      resp.render("index", { productData: data }); //this generates "./views/index.ejs" --> output goes to views
    }
  });
});

router.get("/display-add-form", (req, resp) => {
  resp.render("add_prod");
});

router.post("/add-product", (req, resp) => {
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
        resp.redirect("/products");
      }
    }
  );
});

router.get("/delete/:pnum",function(req,resp){
    connection.query("delete from products where pid=?",[req.params.pnum],function(err,result){
        if(err){
            console.log(err);
            resp.status(500).send("<h3>no data found</h3>")
           }else{
            console.log(result);
            resp.redirect("/products");
           }

    })

});

router.get("/edit/:pnum",function(req,resp){
    connection.query("select * from products where pid=?",[req.params.pnum],function(err,data){
        if(err){
            console.log(err);
            resp.status(500).send("<h3>no data found</h3>")
           }else{
            
            console.log(data);
            resp.render("edit_prod",{prod:data[0]})
           }
    })

})
router.post("/update-product",function(req,resp){
    connection.query("update products set pname=?,qty=?,price=? where pid=?",[req.body.pname,req.body.qty,req.body.price,req.body.pid],function(err,result){
        if(err){
            console.log(err);
            resp.status(500).send("<h3>no data updated</h3>")
           }else{
            console.log(result);
            resp.redirect("/products");
           }

    })

})

//this is same object routes in app.js
module.exports = router;
