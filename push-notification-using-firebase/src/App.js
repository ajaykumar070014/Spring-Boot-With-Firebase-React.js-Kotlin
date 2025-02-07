import { useEffect } from "react";
import "./App.css";
import { generateToken, messaging } from "./config/firebaseConfig";
import { onMessage } from "firebase/messaging";

function App() {
  useEffect(() => {
    generateToken();
    onMessage(messaging, (payload) => {
      console.log("Message received: ", payload);
    });
  }, []);
  return (
    <div className="App">
      <header className="App-header"></header>
    </div>
  );
}

export default App;
