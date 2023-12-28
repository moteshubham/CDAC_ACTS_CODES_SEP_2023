import React from "react"
import { useState } from "react"
function NameForm(props) {
  const [name, setName] = useState("")
  const [errmsg, setErrmsg] = useState("")

  const addName = (event) => {
    event.preventDefault()
    if (name.trim().length === 0) {
      setErrmsg("Name can not be blank")
      return
    }
    setErrmsg("")
    props.addData(name)
    setName("")
  }
  const deleteName = () => {
    if (name.trim().length === 0) {
      setErrmsg("Name can not be blank")
      return
    }
    setErrmsg("")
    props.deleteData(name)
    setName("")
  }

  const updateName = () => {
    const newname = prompt("enetr new name")
   // console.log(name, newname)
    //add this property in NameTab, and complete the code for updating name
    props.updateData(name, newname)
  }

  return (
    <div>
      {name}
      <form action="">
        <div className="form-group">
          <label htmlFor="name">Name</label>
          <input
            type="text"
            className="form-control"
            id="name"
            name="name"
            value={name}
            onChange={(event) => {
              setName(event.target.value)
            }}
          />
          <p>{errmsg} </p>
        </div>
        <button type="button" className="btn btn-primary" onClick={addName}>
          Add
        </button>
        <button type="button" className="btn btn-primary" onClick={deleteName}>
          Delete
        </button>
        <button type="button" className="btn btn-primary" onClick={updateName}>
          Update
        </button>
      </form>
    </div>
  )
}

export default NameForm
