package kibera.dron_project.domain;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="country_origin")
@Entity
public class CountryOrigin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    public CountryOrigin id(Long id) {
        this.id = id;
        return this;
    }

    public CountryOrigin name(String name) {
        this.name = name;
        return this;
    }
}
