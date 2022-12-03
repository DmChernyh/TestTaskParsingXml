package ru.ertelecom.TestTask.service;

import ru.ertelecom.TestTask.entity.Interaction;
import java.sql.SQLException;
import java.util.List;

public interface InteractionService {
    void saveInteraction(Interaction interaction) throws SQLException;
    List<Interaction> getInteractionsByMediaType(String mediaType);
    Interaction getInteractionByInteractionId(String interactionId);
}
