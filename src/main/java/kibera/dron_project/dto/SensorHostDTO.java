package kibera.dron_project.dto;

import jakarta.validation.constraints.NotNull;
import kibera.dron_project.enums.TypeHost;
import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SensorHostDTO {
    private Long id;
    @NotNull
    private TypeHost typeHost;
    @NotNull
    private Long hostId;
}
