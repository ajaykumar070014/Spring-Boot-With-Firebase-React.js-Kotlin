package com.firebase.notification.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FirebaseNotificationReqDto {
    @NotBlank(message = "Tittle Required")
    private String title;
    @NotBlank(message = "Message Required")
    private String message;
}
