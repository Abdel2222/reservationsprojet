package be.iccbxl.pid.reservationsSpringboot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "languages")
@Data
@NoArgsConstructor
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "The name must not be empty.")
    @Size(min = 2, max = 60, message = "The name must be between 2 and 60 characters long.")
    private String name;

    @ManyToMany(mappedBy = "languages")
    private List<Artist> artists = new ArrayList<>();

    public Language(String name) {
        this.name = name;
    }

    // Add Artist
    public Language addArtist(Artist artist) {
        if (!this.artists.contains(artist)) {
            this.artists.add(artist);
            artist.getLanguages().add(this);  // Maintain bidirectional relationship
        }
        return this;
    }

    // Remove Artist
    public Language removeArtist(Artist artist) {
        if (this.artists.contains(artist)) {
            this.artists.remove(artist);
            artist.getLanguages().remove(this);  // Maintain bidirectional relationship
        }
        return this;
    }

    @Override
    public String toString() {
        return name;
    }
}
