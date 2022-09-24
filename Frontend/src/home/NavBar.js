import React from "react";
import logo from './images/logo.jpg'
import { NavLink } from "react-router-dom";

const NavBar = () => {


  const change = () => {
    document.getElementById("login").innerHTML = ""
  }



  return (
    <>
      <div className="container-fluid nav-bg">
        <div className="row">
          <div className="col-11 mx-auto">


            <nav className="navbar navbar-expand-lg navbar-light bg-white">
              <div className="container-fluid">
                <a className="navbar-brand" href="/home"><img className="logosize" src={logo} alt="logo"></img></a>
                <NavLink className="navbar-brand name " to="#"><h2 >School Management System</h2></NavLink>

                <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                  <span className="navbar-toggler-icon"></span>
                </button>
                <div className="collapse navbar-collapse" id="navbarSupportedContent">
                  <ul className="navbar-nav ms-auto mb-2 mb-lg-0">



                    <li className="nav-item" id="login" >
                      {/* <NavLink onClick={change} className="nav-link" to="/login">Login</NavLink> */}
                      <NavLink onClick={change} className="nav-link" to="/login">
                        <button type="button" className="btn btn-primary">Login</button>
                      </NavLink>
                    </li>



                  </ul>

                </div>
              </div>
            </nav>
          </div>
        </div>
      </div>

    </>

  )
}

export default NavBar;