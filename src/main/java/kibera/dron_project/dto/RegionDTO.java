package kibera.dron_project.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegionDTO {
    private Long id;
    @NotNull
    @NotBlank
    private String regionCode;
    @NotNull
    @NotBlank
    private String name;
}
