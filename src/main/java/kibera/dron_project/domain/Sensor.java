package kibera.dron_project.domain;

import jakarta.persistence.*;
import kibera.dron_project.enums.Condition;
import kibera.dron_project.enums.Status;
import kibera.dron_project.enums.TypeHost;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="sensor")
@Entity
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sensor_id")
    private String sensorId;

    @Column(name = "name")
    private String name;

    @ManyToOne
    private SensorType sensorType;

    @Column(name = "model")
    private String model;

    @ManyToOne
    private Manufacturer manufacturer;

    @ManyToOne
    private CountryOrigin countryOrigin;

    @Column(name = "production_year")
    private Long productionYear;

    @Column(name = "condition", nullable = false)
    @Enumerated(EnumType.STRING)
    private Condition condition;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "type_host")
    @Enumerated(EnumType.STRING)
    private TypeHost typeHost;

    @Column(name = "host_id")
    private Long hostId;

    public Sensor id(Long id) {
        this.id = id;
        return this;
    }

    public Sensor name(String name) {
        this.name = name;
        return this;
    }

    public Sensor sensorId(String sensorId) {
        this.sensorId = sensorId;
        return this;
    }

    public Sensor sensorType(SensorType sensorType) {
        this.sensorType = sensorType;
        return this;
    }

    public Sensor model(String model) {
        this.model = model;
        return this;
    }

    public Sensor manufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }

    public Sensor countryOrigin(CountryOrigin countryOrigin) {
        this.countryOrigin = countryOrigin;
        return this;
    }

    public Sensor productionYear(Long productionYear) {
        this.productionYear = productionYear;
        return this;
    }

    public Sensor condition(Condition condition) {
        this.condition = condition;
        return this;
    }

    public Sensor status(Status status) {
        this.status = status;
        return this;
    }

    public Sensor typeHost(TypeHost typeHost) {
        this.typeHost = typeHost;
        return this;
    }

    public Sensor hostId(Long hostId) {
        this.hostId = hostId;
        return this;
    }

}
