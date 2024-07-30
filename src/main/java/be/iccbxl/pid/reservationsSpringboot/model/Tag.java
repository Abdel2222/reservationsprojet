

package be.iccbxl.pid.reservationsSpringboot.model;

import jakarta.persistence.*;
import lombok.Data;


import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "tags")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String tag;

    @ManyToMany(mappedBy = "tags")
    private Set<Show> shows = new HashSet<>();

    // Constructeurs, getters et setters peuvent être ajoutés ici si nécessaire
}


