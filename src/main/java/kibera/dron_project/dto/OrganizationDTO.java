package kibera.dron_project.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationDTO {

    private Long id;
    private String name;
    private RegionDTO regionDTO;
    private DistrictDTO districtDTO;
    private String address;
    private String color;
}
