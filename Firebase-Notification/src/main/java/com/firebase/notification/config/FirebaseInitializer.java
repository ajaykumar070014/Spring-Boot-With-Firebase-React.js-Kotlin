package com.firebase.notification.config;

import java.io.FileNotFoundException;
import java.io.InputStream;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Configuration
public class FirebaseInitializer {

    @jakarta.annotation.PostConstruct
    public void initialize() {
        try {
            InputStream serviceAccount = getClass().getClassLoader().getResourceAsStream("firebase-service-account.json");

            if (serviceAccount == null) {
                throw new FileNotFoundException("firebase-service-account.json not found on the classpath");
            }

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
                System.out.println("Firebase App initialized successfully!");
            } else {
                System.out.println("Firebase App already initialized.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
