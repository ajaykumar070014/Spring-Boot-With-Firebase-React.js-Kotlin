package com.firebase.notification.service;

import com.firebase.notification.dto.FirebaseNotificationReqDto;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public interface FirebaseNotificationService {
    String sendMessageToSpecificDevice(String deviceToken, FirebaseNotificationReqDto request) throws ExecutionException, InterruptedException;
    String sendMessageToSpecificTopic(String topic,FirebaseNotificationReqDto request) throws ExecutionException, InterruptedException;
}
