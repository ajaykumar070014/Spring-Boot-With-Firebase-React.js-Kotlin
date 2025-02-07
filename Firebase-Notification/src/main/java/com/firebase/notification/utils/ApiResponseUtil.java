package com.firebase.notification.utils;

import com.firebase.notification.dto.SuccessResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ApiResponseUtil {

    public static <T> ResponseEntity<SuccessResponse<T>> SuccessResponse(HttpStatus status, String message, T data) {
        SuccessResponse<T> apiResponse = new SuccessResponse<>(status.value(), new SuccessResponse.DataWrapper<>(message, data, ""));
        return new ResponseEntity<>(apiResponse, status);
    }

    public static <T> ResponseEntity<SuccessResponse<T>> ErrorResponse(HttpStatus status, String message, String customCode) {
        SuccessResponse<T> apiResponse = new SuccessResponse<>(status.value(), new SuccessResponse.DataWrapper<>(message, null, customCode));
        return new ResponseEntity<>(apiResponse, status);
    }
}
