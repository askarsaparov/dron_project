package kibera.dron_project.domain;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="position")
@Entity
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    public Position id(Long id) {
        this.id = id;
        return this;
    }

    public Position name(String name) {
        this.name = name;
        return this;
    }
}
