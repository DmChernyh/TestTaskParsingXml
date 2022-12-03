package ru.ertelecom.TestTask.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;
import ru.ertelecom.TestTask.entity.Interaction;

import java.sql.SQLException;
import java.util.List;

@Repository
public class InteractionDaoImpl implements InteractionDao {

    private static final Logger logger = LogManager.getLogger();

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveInteraction(Interaction interaction) throws SQLException {
        entityManager.persist(interaction);
        logger.info("Интеракция добавлена а БД");
    }

    @Override
    public List<Interaction> getInteractionsByMediaType(String mediaType) {
        return entityManager.createQuery("from Interaction where mediaType =: type")
                .setParameter("type", mediaType).getResultList();

    }

    @Override
    public Interaction getInteractionByInteractionId(String interactionId) {
        try {
            return entityManager.createQuery("from Interaction where id =: type", Interaction.class)
                    .setParameter("type", interactionId).getSingleResult();
        } catch (NoResultException ignore) {
        }
        return null;
    }
}
