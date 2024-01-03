import React from "react"
import "./ShowTable.css"
import  { useEffect, useState } from "react"
import BookService from "../service/BookService"

function ShowTable() {
  const [bookArr, setBookArr] = useState([])
  useEffect(() => {
    BookService.getAllBooks().then((result) => {
      setBookArr([...result.data])
    })
  }, [])

  return (
    <div>
      <table border={2}>
        <thead>
          <tr>
            <td>Id</td>
            <td>Name</td>
            <td>Author</td>
            <td>Price</td>
          </tr>
        </thead>
        <tbody>
          {bookArr.map((book) => (
            <tr key={book}>
              <th>{book.id}</th>
              <th>{book.name}</th>
              <th>{book.author}</th>
              <th>{book.price}</th>
            </tr>
          ))}
        
        </tbody>
      </table>
    </div>
  )
}

export default ShowTable
