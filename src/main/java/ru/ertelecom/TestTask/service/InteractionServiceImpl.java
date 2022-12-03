package ru.ertelecom.TestTask.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ertelecom.TestTask.dao.InteractionDao;
import ru.ertelecom.TestTask.entity.Interaction;
import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class InteractionServiceImpl implements InteractionService {

    private final InteractionDao interactionDao;

    @Override
    public void saveInteraction(Interaction interaction) throws SQLException {
        interactionDao.saveInteraction(interaction);
    }

    @Override
    public List<Interaction> getInteractionsByMediaType(String mediaType) {
        return interactionDao.getInteractionsByMediaType(mediaType);
    }

    @Override
    public Interaction getInteractionByInteractionId(String interactionId) {
        return interactionDao.getInteractionByInteractionId(interactionId);
    }
}
