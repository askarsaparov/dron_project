package kibera.dron_project.dto;

import kibera.dron_project.enums.Condition;
import kibera.dron_project.enums.Status;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DroneDTO {
    private Long id;
    private String drone_id;
    private String name;
    private BrandDTO brandDTO;
    private String model;
    private ManufacturerDTO manufacturerDTO;
    private CountryOriginDTO countryOriginDTO;
    private Long productionYear;
    private Condition condition;
    private OrganizationDTO ownerDTO;
    private EmployeeDTO operatorDTO;
    private Status status;
    private Boolean target;
}
