package kibera.dron_project.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DistrictDTO {
    private Long id;
    private String name;
    private String districtCode;
    private RegionDTO region;
}
