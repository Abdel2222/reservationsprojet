package be.iccbxl.pid.reservationsSpringboot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "artists")
@Data
@NoArgsConstructor
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "The firstname must not be empty.")
    @Size(min = 2, max = 60, message = "The firstname must be between 2 and 60 characters long.")
    private String firstname;

    @NotEmpty(message = "The lastname must not be empty.")
    @Size(min = 2, max = 60, message = "The lastname must be between 2 and 60 characters long.")
    private String lastname;

    @ManyToMany(mappedBy = "artists")
    private List<Type> types = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "artist_language",
            joinColumns = @JoinColumn(name = "artist_id"),
            inverseJoinColumns = @JoinColumn(name = "language_id")
    )

    private List<Language> languages = new ArrayList<>();

    public Artist(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    // Add Type
    public Artist addType(Type type) {
        if (!this.types.contains(type)) {
            this.types.add(type);
            type.getArtists().add(this);  // Maintain bidirectional relationship
        }
        return this;
    }

    // Remove Type
    public Artist removeType(Type type) {
        if (this.types.contains(type)) {
            this.types.remove(type);
            type.getArtists().remove(this);  // Maintain bidirectional relationship
        }
        return this;
    }

    // Add Language
    public Artist addLanguage(Language language) {
        if (!this.languages.contains(language)) {
            this.languages.add(language);
            language.getArtists().add(this);  // Maintain bidirectional relationship
        }
        return this;
    }

    // Remove Language
    public Artist removeLanguage(Language language) {
        if (this.languages.contains(language)) {
            this.languages.remove(language);
            language.getArtists().remove(this);  // Maintain bidirectional relationship
        }
        return this;
    }

    @Override
    public String toString() {
        return firstname + " " + lastname;
    }
}
