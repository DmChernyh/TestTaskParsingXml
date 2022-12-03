package ru.ertelecom.TestTask.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.TreeMap;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InteractionResponseDto {
    private String id;
    private TreeMap<String, String> userData;
}
