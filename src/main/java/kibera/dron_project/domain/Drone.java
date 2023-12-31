package kibera.dron_project.domain;
import jakarta.persistence.*;
import kibera.dron_project.enums.Condition;
import kibera.dron_project.enums.Status;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="drone")
@Entity
public class Drone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "drone_id", unique = true)
    private String drone_id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    private Brand brand;

    @Column(name = "model")
    private String model;

    @ManyToOne()
    private Manufacturer manufacturer;

    @ManyToOne
    private CountryOrigin countryOrigin;

    @Column(name = "production_year")
    private Long productionYear;

    @Column(name = "condition", nullable = false)
    @Enumerated(EnumType.STRING)
    private Condition condition;

    @ManyToOne
    private Organization owner;

    @ManyToOne
    private Employee operator;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "target")
    private Boolean target;

    public Drone id(Long id) {
        this.id = id;
        return this;
    }

    public Drone drone_id(String drone_id) {
        this.drone_id = drone_id;
        return this;
    }

    public Drone name(String name) {
        this.name = name;
        return this;
    }

    public Drone brand(Brand brand) {
        this.brand = brand;
        return this;
    }

    public Drone model(String model) {
        this.model = model;
        return this;
    }

    public Drone manufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }

    public Drone countryOrigin(CountryOrigin countryOrigin) {
        this.countryOrigin = countryOrigin;
        return this;
    }

    public Drone productionYear(Long productionYear) {
        this.productionYear = productionYear;
        return this;
    }

    public Drone condition(Condition condition) {
        this.condition = condition;
        return this;
    }

    public Drone owner(Organization owner) {
        this.owner = owner;
        return this;
    }

    public Drone operator(Employee operator) {
        this.operator = operator;
        return this;
    }

    public Drone status(Status status) {
        this.status = status;
        return this;
    }

    public Drone target(Boolean target) {
        this.target = target;
        return this;
    }
}
