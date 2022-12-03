package ru.ertelecom.TestTask.controller;

import lombok.AllArgsConstructor;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ertelecom.TestTask.dto.InteractionResponseDto;
import ru.ertelecom.TestTask.mapper.InteractionMapper;
import ru.ertelecom.TestTask.entity.Interaction;
import ru.ertelecom.TestTask.service.InteractionService;

import java.util.List;

@RestController
@RequestMapping("api")
@AllArgsConstructor
public class Controller {

    private static final Logger logger = LogManager.getLogger();
    private final InteractionMapper interactionMapper;
    private final InteractionService interactionService;

    @GetMapping("/interactionsList")
    public ResponseEntity<?> getInteractionsByMediaType(@RequestParam(name = "mediaType") String mediaType) {
        List<InteractionResponseDto> list = interactionMapper.toListDTO(interactionService.getInteractionsByMediaType(mediaType));
        if (list.isEmpty()) {
            logger.warn("Интеракции для выбранного mediaType не найдены");
            return new ResponseEntity<>("Интеракции для выбранного mediaType не найдены", HttpStatus.BAD_REQUEST);
        }
        logger.info("Интеракции для mediaType=" + mediaType + " получены");
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/interaction/{interactionId}")
    public ResponseEntity<?> getMessagesByInteractionId(@PathVariable("interactionId") String interactionId) {
        Interaction interaction = interactionService.getInteractionByInteractionId(interactionId);
        if (interaction == null) {
            logger.warn("Интеракция с id=" + interactionId + " не найдена");
            return new ResponseEntity<>("Интеракция с id=" + interactionId + " не найдена", HttpStatus.BAD_REQUEST);
        }
        logger.info("Интеракция с id=" + interactionId + " получена");
        return ResponseEntity.ok(interactionMapper.toMessageDTO(interaction));
    }


}
