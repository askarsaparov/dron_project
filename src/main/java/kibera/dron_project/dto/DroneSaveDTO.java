package kibera.dron_project.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
    @NotNull
    @NotBlank
    private String drone_id;
    @NotNull
    @NotBlank
    private String name;
    private Long brandId;
    @NotNull
    @NotBlank
    private String model;
    private Long manufacturerId;
    private Long countryOriginId;
    @NotNull
    private Long productionYear;
    @NotNull
    private Condition condition;
    private Long ownerId;
    private Long operatorId;
    @NotNull
    private Status status;
    @NotNull
    private Boolean target;
}
