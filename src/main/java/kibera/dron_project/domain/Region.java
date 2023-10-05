package kibera.dron_project.domain;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="region")
@Entity
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "region_code")
    private String regionCode;

    @Column(name = "name")
    private String name;

    public Region id(Long id) {
        this.id = id;
        return this;
    }

    public Region regionCode(String regionCode) {
        this.regionCode = regionCode;
        return this;
    }

    public Region name(String name) {
        this.name = name;
        return this;
    }
}
