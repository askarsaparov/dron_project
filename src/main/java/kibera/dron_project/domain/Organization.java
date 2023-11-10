package kibera.dron_project.domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="organization")
@Entity
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    private Region region;

    @ManyToOne(fetch = FetchType.EAGER)
    private District district;

    @Column(name = "address")
    private String address;

    @Column(name = "color")
    private String color;

    public Organization id(Long id) {
        this.id = id;
        return this;
    }

    public Organization name(String name) {
        this.name = name;
        return this;
    }

    public Organization region(Region region) {
        this.region = region;
        return this;
    }

    public Organization district(District district) {
        this.district = district;
        return this;
    }

    public Organization address(String address) {
        this.address = address;
        return this;
    }

    public Organization color(String color) {
        this.color = color;
        return this;
    }
}
