package kibera.dron_project.domain;

import jakarta.persistence.*;
import kibera.dron_project.enums.Level;
import lombok.*;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="object")
@Entity
public class Object {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    private Category category;

    @Column(name = "level", nullable = false)
    @Enumerated(EnumType.STRING)
    private Level level;

    @ManyToOne
    private Region region;

    @ManyToOne
    private District district;

    @Column(name = "address")
    private String address;

    @Column(name = "latitude")
    private BigDecimal latitude;

    @Column(name = "longitude")
    private BigDecimal longitude;

    public Object id(Long id) {
        this.id = id;
        return this;
    }

    public Object name(String name) {
        this.name = name;
        return this;
    }

    public Object category(Category category) {
        this.category = category;
        return this;
    }

    public Object level(Level level) {
        this.level = level;
        return this;
    }

    public Object region(Region region) {
        this.region = region;
        return this;
    }

    public Object district(District district) {
        this.district = district;
        return this;
    }

    public Object address(String address) {
        this.address = address;
        return this;
    }

    public Object latitude(BigDecimal latitude) {
        this.latitude = latitude;
        return this;
    }

    public Object longitude(BigDecimal longitude) {
        this.longitude = longitude;
        return this;
    }
}
