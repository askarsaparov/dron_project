package kibera.dron_project.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import kibera.dron_project.annotation.CheckingRegion;
import lombok.*;

@Getter
@Setter
@Builder
@CheckingRegion
@NoArgsConstructor
@AllArgsConstructor
public class DistrictSaveDTO {
    private Long id;
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    @NotBlank
    private String districtCode;
    private Long regionId;
}
