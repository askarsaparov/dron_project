package kibera.dron_project.domain;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="district")
@Entity
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "district_code")
    private String districtCode;

    @ManyToOne(fetch = FetchType.EAGER)
    private Region region;

    public District id(Long id) {
        this.id = id;
        return this;
    }

    public District name(String name) {
        this.name = name;
        return this;
    }

    public District districtCode(String districtCode) {
        this.districtCode = districtCode;
        return this;
    }

    public District region(Region region) {
        this.region = region;
        return this;
    }
}
