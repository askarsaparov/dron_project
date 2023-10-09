package kibera.dron_project.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DistrictSaveDTO {
    private Long id;
    private String name;
    private String districtCode;
    private Long regionId;
}
