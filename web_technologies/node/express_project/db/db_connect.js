const mysql = require('mysql');
var mysqlConnection = mysql.createConnection({
    host:"127.0.0.1",
    user:"root",
    password:"root",
    port:3306,
    database:"pms"
    //multipleStatements:true
})
mysqlConnection.connect((err) => { 
    if(err){
        console.log("eror: ", err);
    }else{
        console.log("connected to db");
    }
 })

 module.exports = mysqlConnection