package kibera.dron_project.dto;

import kibera.dron_project.enums.Condition;
import kibera.dron_project.enums.Status;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DroneSaveDTO {

    private Long id;
    private String drone_id;
    private String name;
    private String brand;
    private String model;
    private String manufacturer;
    private String countryOrigin;
    private Long productionYear;
    private Condition condition;
    private Long ownerId;
    private Long operatorId;
    private Status status;
    private Boolean target;

}
