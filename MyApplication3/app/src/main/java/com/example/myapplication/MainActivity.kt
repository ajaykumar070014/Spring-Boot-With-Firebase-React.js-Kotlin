package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get the device FCM token on app startup
        getFCMToken()

        // Subscribe to a specific topic (e.g., "news")
        subscribeToTopic("news")

        // Subscribe to a broadcast topic (e.g., "broadcast")
        subscribeToBroadcast()
    }

    // Fetch the current FCM device token
    private fun getFCMToken() {
        FirebaseMessaging.getInstance().token.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val token = task.result
                Log.d("FCM Token", "Device token: $token")
                Toast.makeText(this, "FCM Token: $token", Toast.LENGTH_LONG).show()
            } else {
                Log.w("FCM Token", "Fetching FCM token failed", task.exception)
            }
        }
    }

    // Subscribe to a specific topic
    private fun subscribeToTopic(topic: String) {
        FirebaseMessaging.getInstance().subscribeToTopic(topic)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d("FCM Topic", "Subscribed to topic: $topic")
                    Toast.makeText(this, "Subscribed to topic: $topic", Toast.LENGTH_SHORT).show()
                } else {
                    Log.w("FCM Topic", "Failed to subscribe to topic: $topic", task.exception)
                }
            }
    }

    // Subscribe to a broadcast group (all devices)
    private fun subscribeToBroadcast() {
        FirebaseMessaging.getInstance().subscribeToTopic("'all' in topics")
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d("FCM Broadcast", "Subscribed to broadcast topic")
                    Toast.makeText(this, "Subscribed to broadcast", Toast.LENGTH_SHORT).show()
                } else {
                    Log.w("FCM Broadcast", "Failed to subscribe to broadcast", task.exception)
                }
            }
    }
}
