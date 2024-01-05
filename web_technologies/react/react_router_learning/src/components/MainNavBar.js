import React from 'react'
import { NavLink } from 'react-router-dom'
export default function MainNavBar() {
  return (
    <div>
    <nav className="navbar navbar-expand-lg navbar-light bg-light">
    <a className="navbar-brand" href="#">Navbar</a>
    <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span className="navbar-toggler-icon"></span>
    </button>
  
    <div className="collapse navbar-collapse" id="navbarSupportedContent">
      <ul className="navbar-nav mr-auto">
        <li className="nav-item active">
          <NavLink className="nav-link" to="/home">Home <span className="sr-only">(current)</span></NavLink>
        </li>
        <li className="nav-item">
          <NavLink className="nav-link" to="/table">Table</NavLink>
        </li>
        <li className="nav-item">
          <NavLink className="nav-link" to="/list">List</NavLink>
        </li>
        <li className="nav-item">
          <NavLink className="nav-link" to="/form">form</NavLink>
        </li>
        
        <li className="nav-item">
          <NavLink className="nav-link disabled">Disabled</NavLink>
        </li>
      </ul>
      
    </div>
  </nav></div>
  )
}
