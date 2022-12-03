package ru.ertelecom.TestTask.init;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ru.ertelecom.TestTask.entity.Interaction;
import ru.ertelecom.TestTask.service.InteractionService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

@Component
@AllArgsConstructor
public class InitConfig {

    private final InteractionService interactionService;

    public void init() throws SQLException {

        StringBuilder XMLInString = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new FileReader(getClass().getResource("/").getPath() + "/static/" + "test.xml"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                XMLInString.append(line);
            }
        }
        catch (IOException e) { e.printStackTrace(); }

        Interaction interaction1 = new Interaction();
        interaction1.setId("005PAaH11EN8Q825");
        interaction1.setMediaType("chat");
        interaction1.setStructuredText(XMLInString.toString());
        interactionService.saveInteraction(interaction1);

        Interaction interaction2 = new Interaction();
        interaction2.setId("005PAaH11EN8Q826");
        interaction2.setMediaType("mail");
        interaction2.setStructuredText(XMLInString.toString());
        interactionService.saveInteraction(interaction2);

        Interaction interaction3 = new Interaction();
        interaction3.setId("005PAaH11EN8Q827");
        interaction3.setMediaType("mail");
        interaction3.setStructuredText(XMLInString.toString());
        interactionService.saveInteraction(interaction3);

        Interaction interaction4 = new Interaction();
        interaction4.setId("005PAaH11EN8Q828");
        interaction4.setMediaType("chat");
        interaction4.setStructuredText(XMLInString.toString());
        interactionService.saveInteraction(interaction4);
    }

}
