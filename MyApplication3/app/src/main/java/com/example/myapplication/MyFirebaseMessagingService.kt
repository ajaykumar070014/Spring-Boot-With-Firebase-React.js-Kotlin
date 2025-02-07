package com.example.myapplication

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {

    private val CHANNEL_ID = "default_channel"

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        Log.d(TAG, "From: ${remoteMessage.from}")

        // Check if message contains a notification payload
        remoteMessage.notification?.let {
            val title = it.title
            val body = it.body

            // Show the notification
            when (remoteMessage.from) {
                "/topics/news" -> {
                    Log.d(TAG, "Received a message from the 'news' topic")
                    showNotification("Topic: News", body)
                }
                "/topics/broadcast" -> {
                    Log.d(TAG, "Received a broadcast message")
                    showNotification("Broadcast", body)
                }
                else -> {
                    Log.d(TAG, "Received a device-specific message")
                    showNotification(title, body)
                }
            }
        }
    }

    override fun onNewToken(token: String) {
        Log.d(TAG, "New FCM Token: $token")

        // Optionally, send the token to your server
        sendRegistrationToServer(token)
    }

    private fun sendRegistrationToServer(token: String) {
        // Logic to send the token to your server (optional)
        Log.d(TAG, "Token sent to server: $token")
    }

    private fun showNotification(title: String?, body: String?) {
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // For Android Oreo and above, create a notification channel
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                "FCM Notifications",
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                description = "Channel for FCM notifications"
            }
            notificationManager.createNotificationChannel(channel)
        }

        val notification: Notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle(title)
            .setContentText(body)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .build()

        notificationManager.notify(0, notification)  // Notification ID 0, change if needed
    }

    companion object {
        private const val TAG = "MyFirebaseMsgService"
    }
}
