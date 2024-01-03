import React from "react"
import "./BookForm.css"
import { useState } from "react"
import ShowTable from "./ShowTable"
import { useNavigate } from "react-router-dom"
import BookService from "../service/BookService"

function BookForm() {
  const [formDetails, setFormDetails] = useState({ name: "", author: "", price: "" })

  const navigate = useNavigate()
  const addBook = () => {
BookService.addBook(formDetails).then(() => { 
    console.log("in add");
    navigate(0)
 }).catch((err) => { 
    console.log(err);
  })
    
  }
  const handleOnChange = (event) => {
    let { name, value } = event.target
    setFormDetails({...formDetails, [name]:value})
  }
  return (
    <div>
      <div className="input-form">
        <label>
          Name:
          <input type="text" name="name" id="name" onChange={handleOnChange} />
        </label>
        <label>
          Author:
          <input type="text" name="author" id="author" onChange={handleOnChange} />
        </label>
        <label>
          Price:
          <input type="text" name="price" id="price" onChange={handleOnChange} />
        </label>
        <button type="button" onClick={addBook}>
          Add to Store
        </button>
      </div>
      <ShowTable />
    </div>
  )
}

export default BookForm
