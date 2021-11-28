import React, { useState, useEffect } from "react";
import Box from "@mui/material/Box";
import TextField from "@mui/material/TextField";
import Radio from "@mui/material/Radio";
import RadioGroup from "@mui/material/RadioGroup";
import FormControlLabel from "@mui/material/FormControlLabel";
import FormControl from "@mui/material/FormControl";
import FormLabel from "@mui/material/FormLabel";
import Button from "./common/Button";
import { database } from "../firebase-config";
import { collection, addDoc } from "firebase/firestore";
import { app } from "../firebase-config";
import { useNavigate } from "react-router-dom";
import { getAuth, createUserWithEmailAndPassword } from "firebase/auth";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import "./Register.scss";

const Register = () => {
  const navigate = useNavigate();

  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [name, setName] = useState("");
  const [age, setAge] = useState(0);
  const [phoneNo, setPhoneNo] = useState("0000000000");
  const [mySupporter, setMySupporter] = useState([]);
  const [supporterOf, setSupporterOf] = useState([]);
  const [pmsInterval, setPMSInterval] = useState(3);
  const [periodInterval, setPeriodInterval] = useState(7);
  const [isOwner, setIsOwner] = useState(false);
  const [isSupporter, setIsSupporter] = useState(false);

  const addSupporter = () => {};

  const sendData = async () => {
    const databaseRef = collection(database, "userdata");
    await addDoc(databaseRef, {
      Email: email,
      Password: password,
      Name: name,
      Age: age,
      MySuppoters: mySupporter,
      SupporterOf: supporterOf,
      PMSInterval: pmsInterval,
      PeriodInterval: periodInterval,
      isOwner: isOwner,
      isSupporter: isSupporter,
    }).then(() => {
      toast.success("Data sent successfully!", {
        pauseOnHover: true,
      });
      console.log("sent");
    });
  };
  const handleRegister = () => {
    const authentication = getAuth();
    createUserWithEmailAndPassword(authentication, email, password)
      .then((response) => {
        navigate("/home");
        sessionStorage.setItem(
          "Auth Token",
          response._tokenResponse.refreshToken
        );
        sendData();
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

        <FormControl component="fieldset">
          <FormLabel component="legend">Are you a Period Owner?</FormLabel>
          <RadioGroup
            row
            aria-label="owner"
            name="row-radio-buttons-group-owner"
            value={isOwner}
            onChange={(e) => {
              if (e.target.value === "true") {
                setIsOwner(true);
              } else {
                setIsOwner(false);
              }
            }}
          >
            <FormControlLabel value="true" control={<Radio />} label="Yes" />
            <FormControlLabel value="false" control={<Radio />} label="No" />
          </RadioGroup>
        </FormControl>

        <FormControl component="fieldset">
          <FormLabel component="legend">Are you a Period Supporter?</FormLabel>
          <RadioGroup
            row
            aria-label="supporter"
            name="row-radio-buttons-group-supporter"
            value={isSupporter}
            onChange={(e) => {
              if (e.target.value === "true") {
                setIsSupporter(true);
              } else {
                setIsSupporter(false);
              }
            }}
          >
            <FormControlLabel value="true" control={<Radio />} label="Yes" />
            <FormControlLabel value="false" control={<Radio />} label="No" />
          </RadioGroup>
        </FormControl>
      </Box>

      <Button title="Register" handleAction={handleRegister} />
    </div>
  );
};

export default Register;
