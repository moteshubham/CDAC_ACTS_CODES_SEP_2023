import React from "react"
import "./NameTable.css"
import NameForm from "./NameForm"
function NameTable(props) {
  const insertData = (name) => {
    props.insertName(name)
  }
  const removeData =(name) => { 
    props.removeName(name)
   }

   const updateNewData =(name, newName) => { 
    props.updateName(name,newName)
    }


  return (
    <div>
      <table border="2">
        <thead>
          <tr>
            <th>Id</th>
            <th>name</th>
          </tr>
        </thead>
        <tbody>
          {props.nameArr.map((obj, index) => (
            <tr key={index}>
              <td>{index + 1}</td>
              <td>{obj}</td>
            </tr>
          ))}
          <tr></tr>
        </tbody>
      </table>
      <NameForm addData={insertData} deleteData={removeData} updateData={updateNewData} />
    </div>
  )
}

export default NameTable
