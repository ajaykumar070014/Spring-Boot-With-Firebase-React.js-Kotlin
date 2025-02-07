# Multi-Platform Notification System

## Overview

This project sends notifications from a **Spring Boot backend** to both **web (React.js)** and **mobile (Android - Kotlin)** clients via Firebase Cloud Messaging (FCM).

---

## Tech

- Backend: Java, Spring Boot, Firebase Admin SDK
- Frontend: React.js, Firebase SDK
- Mobile: Kotlin, Android, Firebase SDK
- Messaging: Firebase Cloud Messaging (FCM)

---

## Setup

## Backend Setup:
- Added a step-by-step guide for cloning the repository and navigating to the `backend` folder.
- Generate/download the `serviceAccountKey.json` file from the Firebase Console.
- Specified the exact location (`src/main/resources`) where the `serviceAccountKey.json` file should be placed.
- Included an optional step for updating configuration files like `application.properties`.
- Added a command to run the Spring Boot application.
  
## Frontend Setup :
   - Navigate to the React.js frontend directory.
   - Install dependencies:
     ```bash
     npm install
     ```
   - Replace the `firebase-messaging-sw.js` with your `firebaseConfig`
   - Replace `firebaseConfig.js` with your `firebaseConfig`
     ### Firebase VAPID Key Setup: Steps to Obtain/Generate VAPID Key

1. **Log in to Firebase Console**  
   - Go to the [Firebase Console](https://console.firebase.google.com/) and log in with your Google account.

2. **Select Your Project**  
   - Choose the Firebase project for which you want to configure the VAPID key.

3. **Navigate to Project Settings**  
   - Click on the gear icon (⚙️) next to **Project Overview** in the left sidebar.
   - Select **Project settings** from the dropdown menu.

4. **Go to Cloud Messaging Tab**  
   - In the **Project settings** page, navigate to the **Cloud Messaging** tab.

5. **Find or Generate the VAPID Key**  
   - Under the **Web configuration** section, look for the **Key Pair** field.
   - If a VAPID key already exists, it will be displayed here.
   - If no key exists, click the **Generate Key Pair** button to create a new VAPID key.

6. **Copy the VAPID Key**  
   - Once the key is generated or displayed, copy it to your clipboard.
   - Store it securely, as it will be required for configuring FCM in your web application.
   
7. **Start the React app:**
     ```bash
     npm start
     ```

## Android Setup:
   - Open Android Studio.
   - Replace `google-services.json` to the app directory.
