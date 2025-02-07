package com.firebase.notification.utils;

import com.firebase.notification.dto.FirebaseNotificationReqDto;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;

import java.util.concurrent.ExecutionException;
public class FirebaseNotificationUtil {

    public static Message getPreConfiguredMessageToDevice(String deviceToken, FirebaseNotificationReqDto request) {
        return Message.builder()
                .setToken(deviceToken)
                .setNotification(Notification.builder()
                        .setTitle(request.getTitle())
                        .setBody(request.getMessage())
                        .build())
                .build();
    }

    public static Message getPreconfiguredMessageToTopic(String topic, FirebaseNotificationReqDto request) {

        return Message.builder()
                .setTopic(topic)
                .setNotification(Notification.builder()
                        .setTitle(request.getTitle())
                        .setBody(request.getMessage())
                        .build())
                .build();

    }

    public static String sendAndGetResponse(Message message) throws InterruptedException, ExecutionException {
        return FirebaseMessaging.getInstance().sendAsync(message).get();
    }
}
