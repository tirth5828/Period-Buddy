import React, { useState, useEffect } from "react";
import Box from "@mui/material/Box";
import TextField from "@mui/material/TextField";
import Button from "./common/Button";
import { database } from "../firebase-config";
import { collection, addDoc } from "firebase/firestore";
import { app } from "../firebase-config";
import { useNavigate } from "react-router-dom";
import { getAuth, createUserWithEmailAndPassword } from "firebase/auth";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

const Register = () => {
  const navigate = useNavigate();
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [name, setName] = useState("");
  const [age, setAge] = useState(0);

  const sendData = async () => {
    const databaseRef = collection(database, "userdata");
    await addDoc(databaseRef, {
      Email: email,
      Password: password,
      Name: name,
      Age: age,
    }).then(() => {
      toast.success("Data sent successfully!", {
        pauseOnHover: true,
      });
      console.log("sent");
    });
  };
  const handleRegister = () => {
    sendData();
    const authentication = getAuth();
    createUserWithEmailAndPassword(authentication, email, password)
      .then((response) => {
        navigate("/home");
        sessionStorage.setItem(
          "Auth Token",
          response._tokenResponse.refreshToken
        );
      })
      .catch((error) => {
        if (error.code === "auth/email-already-in-use") {
          toast.error("Email Already in Use");
        }
      });
  };

  useEffect(() => {
    let authToken = sessionStorage.getItem("Auth Token");
    if (authToken) {
      navigate("/home");
    }
  }, []);

  return (
    <div>
      <ToastContainer />
      <div className="heading-container">
        <h3>Register</h3>
      </div>

      <Box
        component="form"
        sx={{
          "& > :not(style)": { m: 1, width: "25ch" },
        }}
        noValidate
        autoComplete="off"
      >
        <TextField
          id="email"
          label="Email"
          variant="outlined"
          onChange={(e) => setEmail(e.target.value)}
        />
        <TextField
          id="password"
          label="Password"
          variant="outlined"
          onChange={(e) => setPassword(e.target.value)}
        />
        <TextField
          id="name"
          label="Name"
          variant="outlined"
          onChange={(e) => setName(e.target.value)}
        />
        <TextField
          id="age"
          label="Age"
          variant="outlined"
          onChange={(e) => setAge(e.target.value)}
        />
      </Box>

      <Button title="Register" handleAction={handleRegister} />
    </div>
  );
};

export default Register;
