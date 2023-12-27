import React from "react"

class CounterClassComponent extends React.Component {
  constructor(props) {
    super(props)
    this.state = {
      count: 0, //write any no of things whose value you want to retain in state
      name: "mote",
    }
    //this.increament=this.increament.bind(this)
  }
  //---------------------------------------------------------------------------------------
  increment = () => {
    //this.setState(this.count++)   //you cant do this, cant directly modify this object
    //use setstate function to change the state, it is asynchronous function, it will create new state object, it will not overrite the old state object
    //to check the changed value of state use call back function
    this.setState({ ...this.state, count: this.state.count + 1 }, () => {
      console.log(this.state.count) //here we get fresh output
    })
    //console.log(this.state.count); //if we dont write this line in clbk function it gives us the old value as setState is async
  }

  decrement = () => {
    this.setState({ ...this.state, count: this.state.count <= 0 ? 0 : this.state.count - 1 }, () => {
      console.log(this.state.count)
    })
  }

  resetcnt = () => {
    this.setState({ ...this.state, count: 0 })
  }

  render() {
    return (
      <div>
        <h1>You clicked {this.state.count} </h1>
        <button type="button" className="btn btn-primary" onClick={this.increment} name="btn" id="inc">
          Increment
        </button>
        <button type="button" className="btn btn-secondary" onClick={this.decrement} name="btn" id="dec">
          Decrement
        </button>
        <button type="button" className="btn btn-danger" onClick={this.resetcnt} name="btn" id="res">
          Reset
        </button>
      </div>
    )
  }
}

export default CounterClassComponent
