package ru.ertelecom.TestTask.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.Instant;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InteractionMessageResponseDto {
    private Instant time;
    private String userId;
    private String message;
}
