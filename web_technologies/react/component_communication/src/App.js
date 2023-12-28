import "./App.css"
import Footer from "./components/Footer"
import Header from "./components/Header"
import { useState } from "react"
import NameTable from "./components/NameTable"
import NameList from "./components/NameList"
function App() {
  const [nameArr, setNameArr] = useState(["Shubham", "Jayant", "Nirav", "Mayank"])

  const addNewName = (name) => {
    setNameArr([...nameArr, name])
  }
  const deleteName = (name) => {
    let tempArr = nameArr.filter((obj) => obj !== name)
    setNameArr(tempArr)
  }
  const updateNewName = (name, newName) => {
    let indexOld = nameArr.findIndex(name)
    let tempArr = [...nameArr]
    tempArr[indexOld] = newName
    setNameArr(tempArr)
  }
  return (
    <div>
      <Header />
      <div className="container">
        <div className="row">
          <div className="col-md-3 col-sm-12">
            <img src="" alt="" />
          </div>
          <div className="col-md-5 col-sm-12">
            <NameTable nameArr={nameArr} insertName={addNewName} removeName={deleteName} updateName={updateNewName} />
          </div>
          <div className="col-md-4 col-sm-12">
            <NameList nameArr={nameArr} />
          </div>
        </div>
      </div>
      <Footer />
    </div>
  )
}

export default App
