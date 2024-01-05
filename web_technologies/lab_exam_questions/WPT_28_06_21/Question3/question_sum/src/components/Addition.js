import React from "react"
import { useState } from "react"

function Addition() {
  const [num1, setNum1] = useState("")
  const [num2, setNum2] = useState("")
  const [sum, setSum] = useState("")
  const handleChange1 = (e) => {
    let num1 = e.target.value
    setNum1(parseInt(num1))
  }
  const handleChange2 = (e) => {
    let num2 = e.target.value
    setNum2(parseInt(num2))
  }
  const handleOnClick = () => {
    setSum(num1 + num2)
    console.log(sum)
  }

  return (
    <div>
      <label>
        Number1:
        <input type="text" name="num1" value={num1} onChange={handleChange1} />
      </label>
      <label>
        Number2:
        <input type="text" name="num2" value={num2} onChange={handleChange2} />
      </label>
      <button type="submit" onClick={handleOnClick}>
        Add
      </button>

      {sum && <h2 id="sum"> {sum} </h2>}
    </div>
  )
}

export default Addition
