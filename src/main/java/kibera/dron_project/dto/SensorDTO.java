package kibera.dron_project.dto;

import kibera.dron_project.enums.Condition;
import kibera.dron_project.enums.Status;
import kibera.dron_project.enums.TypeHost;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SensorDTO {
    private Long id;
    private String name;
    private String sensorId;
    private SensorTypeDTO sensorTypeDTO;
    private String model;
    private ManufacturerDTO manufacturerDTO;
    private CountryOriginDTO countryOriginDTO;
    private Long productionYear;
    private Condition condition;
    private Status status;
    private Object host;
    private TypeHost typeHost;
}
