import { initializeApp } from "firebase/app";
import { getFirestore } from "@firebase/firestore";

const firebaseConfig = {
  apiKey: "AIzaSyBv3BywD6tYSKfbFWAqZpXDLs7ddKQ3PPo",
  authDomain: "period-buddy-4e396.firebaseapp.com",
  databaseURL:
    "https://period-buddy-4e396-default-rtdb.asia-southeast1.firebasedatabase.app",
  projectId: "period-buddy-4e396",
  storageBucket: "period-buddy-4e396.appspot.com",
  messagingSenderId: "356966721830",
  appId: "1:356966721830:web:7b1ecd3d6bd3b6e080b9e7",
  measurementId: "G-S1EC49WPFE",
};

export const app = initializeApp(firebaseConfig);
export const database = getFirestore(app);
