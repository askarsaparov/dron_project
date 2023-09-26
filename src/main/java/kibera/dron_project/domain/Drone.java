package kibera.dron_project.domain;
import jakarta.persistence.*;
import kibera.dron_project.enums.Mood;
import kibera.dron_project.enums.Status;

import java.io.Serializable;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="drone")
@Entity
public class Drone implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "drone_id")
    private String drone_id;

    @Column(name = "name")
    private String name;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "country_origin")
    private String countryOrigin;

    @Column(name = "production_year")
    private Long productionYear;

    @Column(name = "mood", nullable = false)
    @Enumerated(EnumType.STRING)
    private Mood mood;

    @ManyToOne
    private Organization owner;

    @ManyToOne
    private Employee operator;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

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

    public Drone brand(String brand) {
        this.brand = brand;
        return this;
    }

    public Drone model(String model) {
        this.model = model;
        return this;
    }

    public Drone manufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }

    public Drone countryOrigin(String countryOrigin) {
        this.countryOrigin = countryOrigin;
        return this;
    }

    public Drone productionYear(Long productionYear) {
        this.productionYear = productionYear;
        return this;
    }

    public Drone mood(Mood mood) {
        this.mood = mood;
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
}
