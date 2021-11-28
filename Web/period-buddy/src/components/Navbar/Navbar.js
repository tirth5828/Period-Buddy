import React from "react";
import { NavLink } from "react-router-dom";
import "./Navbar.scss";
import logo from "../../Assets/logo.jpeg";

function Navbar() {
  return (
    <div>
      <nav className="navbar">
        <div className="logo-container">
          <NavLink to="/" className="logo">
            <img src={logo} alt="logo" />
          </NavLink>
        </div>
        <div className="navitems">
          <NavLink to="/" className="navchild">
            <div>Home</div>
          </NavLink>
          <NavLink to="/about" className="navchild">
            <div>History</div>
          </NavLink>
          <NavLink to="/speakers" className="navchild">
            <div>Period FAQ</div>
          </NavLink>
          <NavLink to="/talks" className="navchild">
            <div>Find Buddy</div>
          </NavLink>
          <NavLink to="/team" className="navchild">
            <div>Be a Support</div>
          </NavLink>
        </div>
      </nav>
    </div>
  );
}
export default Navbar