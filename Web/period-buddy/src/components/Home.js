import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { database } from "../firebase-config";
import { collection, getDocs } from "firebase/firestore";

export default function Home() {
  let navigate = useNavigate();
  const databaseRef = collection(database, "userdata");
  const [userData, setUserData] = useState([]);
  const handleLogout = () => {
    sessionStorage.removeItem("Auth Token");
    navigate("/login");
  };
  useEffect(() => {
    let authToken = sessionStorage.getItem("Auth Token");

    if (authToken) {
      navigate("/home");
    }

    if (!authToken) {
      navigate("/login");
    }

    const getData = async () => {
      const data = await getDocs(databaseRef);
      console.log(data.docs.map((doc) => ({ ...doc.data(), id: doc.id })));
      setUserData(data.docs.map((doc) => ({ ...doc.data(), id: doc.id })));
    };
    getData();
  }, []);
  return (
    <div>
      <div>Home Page</div>
      <h3>Name</h3>
      <h3>Age</h3>
      <h3>PhoneNo</h3>
      <button onClick={handleLogout}>Log out</button>
    </div>
  );
}
