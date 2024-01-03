const express = require('express');
const router =express.Router()
const bookStore = require('../db/BookStorage')



router.get("/books", (req, res) => {
  console.log("at GET /books")
  let data = bookStore.getAllBooks()
  res.status(200).send(data) 
})
router.post("/books/book", (req, res) => {
    bookStore.addBook(req.body)
    res.status(200).send("data added success")
//   const { name, author, price } = req.body
//   console.log(req.body)
//   if (!name || !author || !price) {
//     console.log("in if condition")
//     return res.status(401).send({ error: "nit lihi" })
//   }
//   const newBook = {
//     id: idCounter++,
//     name,
//     author,
//     price,
//   }
//   books.push(newBook)
//   console.log("books", books)
//   res.send(newBook)
//   console.log("newBook: ", newBook)
})


module.exports = router