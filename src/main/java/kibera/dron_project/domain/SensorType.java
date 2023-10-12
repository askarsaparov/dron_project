package kibera.dron_project.domain;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="sensor_type")
@Entity
public class SensorType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    public SensorType id(Long id) {
        this.id = id;
        return this;
    }

    public SensorType name(String name) {
        this.name = name;
        return this;
    }
}
