package com.firebase.notification.service.implementation;

import com.firebase.notification.dto.FirebaseNotificationReqDto;
import com.firebase.notification.service.FirebaseNotificationService;
import com.firebase.notification.utils.FirebaseNotificationUtil;
import com.google.firebase.messaging.Message;
import org.springframework.stereotype.Service;
import java.util.concurrent.ExecutionException;

@Service
public class FirebaseNotificationServiceImpl implements FirebaseNotificationService {

    @Override
    public String sendMessageToSpecificDevice(String deviceToken, FirebaseNotificationReqDto request) throws ExecutionException, InterruptedException {
        Message message = FirebaseNotificationUtil.getPreConfiguredMessageToDevice(deviceToken, request);
        return FirebaseNotificationUtil.sendAndGetResponse(message);
    }

    @Override
    public String sendMessageToSpecificTopic(String topic,FirebaseNotificationReqDto request) throws ExecutionException, InterruptedException {
        Message message = FirebaseNotificationUtil.getPreconfiguredMessageToTopic(topic,request);
        return FirebaseNotificationUtil.sendAndGetResponse(message);
    }

}
