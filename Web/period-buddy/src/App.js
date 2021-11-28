import Home from "./components/Home";
import Register from "./components/Register";
import Login from "./components/Login";
import Navbar from "./components/Navbar/Navbar";
import Footer from "./components/Footer/Footer";
import { Routes, Route } from "react-router-dom";
import "./App.css";

function App() {
  return (
    <div className="App">
      <>
        <Routes>
          <Route
            path="/login"
            element={
              <div>
                <Navbar />
                <Login />
                <Footer />
              </div>
            }
          />
          <Route
            path="/register"
            element={
              <div>
                <Navbar />
                <Register />
                <Footer />
              </div>
            }
          />
          <Route
            path="/home"
            element={
              <div>
                <Navbar />
                <Home />
                <Footer />
              </div>
            }
          />
        </Routes>
      </>
    </div>
  );
}

export default App;
