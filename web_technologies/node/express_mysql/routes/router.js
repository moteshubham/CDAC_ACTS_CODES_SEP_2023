const express = require('express');
var router = express.Router()   //in this router obj we will add all the paths and then export it and access those from app.js
//this above router obj and routes obj in app.js is same ref to heap location 
const connection = require('../db/db_connect');

router.get("/products", (req,resp) => { 
    connection.query("select * from products",(err,data,fields) => { 
        if(err){
            console.log("error while querying: ", err);
            resp.status(500).send("<h1>no data</h1>")   //as this rets html hence it is webapp
            //is json.--- ... then it is web service
        }else{
            console.log(data);
            resp.render("index", {productData : data})  //this generates "./views/index.ejs" --> output goes to views
        }

     })
 })


module.exports = router