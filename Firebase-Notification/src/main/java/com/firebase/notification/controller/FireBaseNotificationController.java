package com.firebase.notification.controller;

import com.firebase.notification.dto.FirebaseNotificationReqDto;
import com.firebase.notification.dto.SuccessResponse;
import com.firebase.notification.exception.CustomApiException;
import com.firebase.notification.service.FirebaseNotificationService;
import com.firebase.notification.utils.ApiResponseUtil;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
public class FireBaseNotificationController {
    private final FirebaseNotificationService firebaseNotificationService;

    public FireBaseNotificationController(FirebaseNotificationService firebaseNotificationService) {
        this.firebaseNotificationService = firebaseNotificationService;
    }

    @PostMapping("/notification/device")
    public ResponseEntity<SuccessResponse<String>> sendNotificationDevice(@RequestParam String deviceToken, @RequestBody @Valid FirebaseNotificationReqDto request) {
        try {
            String response = firebaseNotificationService.sendMessageToSpecificDevice(deviceToken, request);
            return ApiResponseUtil.SuccessResponse(HttpStatus.OK, "Message Sent Successfully", response);
        } catch (CustomApiException ex) {
            return ApiResponseUtil.ErrorResponse(ex.getStatusCode(), ex.getMessage(), ex.getCustomCode());
        } catch (InterruptedException | ExecutionException ex) {
            return ApiResponseUtil.ErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage(), "BAD_REQUEST");
        }
    }

    @PostMapping("/notification/topic")
    public ResponseEntity<SuccessResponse<String>> sendNotificationToTopic(@RequestParam String topic, @RequestBody @Valid FirebaseNotificationReqDto request) {
        try {
            String response = firebaseNotificationService.sendMessageToSpecificTopic(topic, request);
            return ApiResponseUtil.SuccessResponse(HttpStatus.OK, "Message Sent Successfully", response);
        } catch (CustomApiException ex) {
            return ApiResponseUtil.ErrorResponse(ex.getStatusCode(), ex.getMessage(), ex.getCustomCode());
        } catch (InterruptedException | ExecutionException ex) {
            return ApiResponseUtil.ErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage(), "BAD_REQUEST");
        }
    }
}
