package kibera.dron_project.domain;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="manufacturer")
@Entity
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    public Manufacturer id(Long id) {
        this.id = id;
        return this;
    }

    public Manufacturer name(String name) {
        this.name = name;
        return this;
    }
}
