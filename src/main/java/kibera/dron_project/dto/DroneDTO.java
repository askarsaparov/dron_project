package kibera.dron_project.dto;

import kibera.dron_project.enums.Mood;
import kibera.dron_project.enums.Status;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DroneDTO {
    private Long id;
    private String drone_id;
    private String name;
    private String brand;
    private String model;
    private String manufacturer;
    private String countryOrigin;
    private Long productionYear;
    private Mood mood;
    private Long ownerId;
    private Long operatorId;
    private Status status;
}
