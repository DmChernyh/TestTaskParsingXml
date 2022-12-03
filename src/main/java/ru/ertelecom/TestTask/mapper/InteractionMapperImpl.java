package ru.ertelecom.TestTask.mapper;

import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import ru.ertelecom.TestTask.dto.InteractionMessageResponseDto;
import ru.ertelecom.TestTask.dto.InteractionResponseDto;
import ru.ertelecom.TestTask.entity.Interaction;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import static ru.ertelecom.TestTask.util.Converter.stringToDocument;

@Component
public class InteractionMapperImpl implements InteractionMapper {

    @Override
    public List<InteractionResponseDto> toListDTO(List<Interaction> interactions) {

        List<InteractionResponseDto> listDto = new ArrayList<>();

        for (Interaction interaction : interactions) {
            Document doc = stringToDocument(interaction.getStructuredText().replaceAll("\u0002", "STX"));
            TreeMap<String, String> map = new TreeMap<>();
            Node ud = doc.getElementsByTagName("userData").item(0);
            NodeList items = ud.getChildNodes();

            for (int i = 0; i < items.getLength(); i++) {
                Node item = items.item(i);
                try {
                    String key = item.getAttributes().getNamedItem("key").getTextContent();
                    map.put(key, item.getTextContent());
                } catch (NullPointerException ignored) {
                }
            }

            listDto.add(new InteractionResponseDto(interaction.getId(), map));
        }
        return listDto;
    }

    @Override
    public List<InteractionMessageResponseDto> toMessageDTO(Interaction interaction) {

        List<InteractionMessageResponseDto> list = new ArrayList<>();
        Document doc = stringToDocument(interaction.getStructuredText().replaceAll("\u0002", "STX"));

        NodeList messages = doc.getElementsByTagName("message");
        for (int i = 0; i < messages.getLength(); i++) {
            list.add(new InteractionMessageResponseDto(
                    Instant
                            .parse(doc.getDocumentElement().getAttributes().getNamedItem("startAt").getTextContent())
                            .plusSeconds(Long.parseLong(messages.item(i).getAttributes().getNamedItem("timeShift").getTextContent())),
                    messages.item(i).getAttributes().getNamedItem("userId").getTextContent(),
                    messages.item(i).getTextContent()));
        }
        return list;
    }
}
