import { initializeApp } from "firebase/app";
import { getMessaging, getToken } from "firebase/messaging";

const firebaseConfig = {
  apiKey: "xxxxxxxxxxxxxxxxxxx",
  authDomain: "xxxxxxxxxxxxxxxxxxx",
  projectId: "xxxxxxxxxxxxxxxxxxx",
  storageBucket: "xxxxxxxxxxxxxxxxxxx.firebasestorage.app",
  messagingSenderId: "xxxxxxxxxxxxxxxxxxx",
  appId: "xxxxxxxxxxxxxxxxxxx",
  measurementId: "xxxxxxxxxxxxxxxxxxx",
};

const app = initializeApp(firebaseConfig);
export const messaging = getMessaging(app);

export const generateToken = async () => {
  const permission = await Notification.requestPermission();
  console.log(permission);
  if (permission === "granted") {
    const token = await getToken(messaging, {
      vapidKey:
        "xxxxxxxxxxxxxxxxxxx", //Firebase-Console-> select project-> project Overview setting-> cloud messaging->" Web configuration: Key Pair if exist or Generate Key Pair"
    });
    console.log(token);
  }
};
