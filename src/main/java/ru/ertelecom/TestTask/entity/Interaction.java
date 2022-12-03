package ru.ertelecom.TestTask.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Objects;

@Table
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Interaction {

    @Id
    @Column(name="id")
    private String id;

    @Column(name="mediatype")
    private String mediaType;

    @Column(name="structuredtext")
    private String structuredText;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Interaction that = (Interaction) o;
        return Objects.equals(id, that.id) && Objects.equals(mediaType, that.mediaType) && Objects.equals(structuredText, that.structuredText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mediaType, structuredText);
    }
}
