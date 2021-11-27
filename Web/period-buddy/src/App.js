import Form from "./components/common/Form";
import Home from "./components/Home";
import {
  BrowserRouter as Router,
  Routes,
  Route,
  useNavigate,
} from "react-router-dom";
import { useState, useEffect } from "react";
import { app } from "./firebase-config";
import {
  getAuth,
  signInWithEmailAndPassword,
  createUserWithEmailAndPassword,
} from "firebase/auth";

import "./App.css";

function App() {
  const navigate = useNavigate();
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const handleAction = (id) => {
    const authentication = getAuth();
    if (id === 1) {
      signInWithEmailAndPassword(authentication, email, password).then(
        (response) => {
          navigate("/home");
          sessionStorage.setItem(
            "Auth Token",
            response._tokenResponse.refreshToken
          );
        }
      );
    }
    if (id === 2) {
      createUserWithEmailAndPassword(authentication, email, password).then(
        (response) => {
          navigate("/home");
          sessionStorage.setItem(
            "Auth Token",
            response._tokenResponse.refreshToken
          );
        }
      );
    }
  };
  useEffect(() => {
    let authToken = sessionStorage.getItem("Auth Token");

    if (authToken) {
      navigate("/home");
    }
  }, []);
  return (
    <div className="App">
      <>
        <Routes>
          <Route
            path="/login"
            element={
              <Form
                title="Login"
                setEmail={setEmail}
                setPassword={setPassword}
                handleAction={() => handleAction(1)}
              />
            }
          />
          <Route
            path="/register"
            element={
              <Form
                title="Register"
                setEmail={setEmail}
                setPassword={setPassword}
                handleAction={() => handleAction(2)}
              />
            }
          />
          <Route path="/home" element={<Home />} />
        </Routes>
      </>
    </div>
  );
}

export default App;
