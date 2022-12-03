package ru.ertelecom.TestTask.dao;

import ru.ertelecom.TestTask.entity.Interaction;

import java.sql.SQLException;
import java.util.List;

public interface InteractionDao {
    void saveInteraction(Interaction interaction) throws SQLException;
    List<Interaction> getInteractionsByMediaType(String mediaType);
    Interaction getInteractionByInteractionId(String interactionId);
}
