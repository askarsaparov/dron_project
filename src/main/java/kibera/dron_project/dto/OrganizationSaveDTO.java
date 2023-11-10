package kibera.dron_project.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationSaveDTO {
    private Long id;
    @NotNull
    @NotBlank
    private String name;
    private Long regionId;
    private Long districtId;
    @NotNull
    @NotBlank
    private String address;
    @NotNull
    @NotBlank
    private String color;
}
