package ru.ertelecom.TestTask.mapper;

import ru.ertelecom.TestTask.dto.InteractionMessageResponseDto;
import ru.ertelecom.TestTask.dto.InteractionResponseDto;
import ru.ertelecom.TestTask.entity.Interaction;

import java.util.List;

public interface InteractionMapper {
    List<InteractionResponseDto> toListDTO(List<Interaction> interactions);
    List<InteractionMessageResponseDto> toMessageDTO(Interaction interaction);
}
