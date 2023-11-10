package kibera.dron_project.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import kibera.dron_project.enums.Condition;
import kibera.dron_project.enums.Status;
import kibera.dron_project.enums.TypeHost;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SensorSaveDTO {
    private Long id;
    @NotNull
    @NotBlank
    private String name;
    private String sensorId;
    private Long sensorTypeId;
    @NotNull
    @NotBlank
    private String model;
    private Long manufacturerId;
    private Long countryOriginId;
    private Long productionYear;
    @NotNull
    private Condition condition;
    @NotNull
    private Status status;
}
