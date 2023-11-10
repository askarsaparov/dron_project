package kibera.dron_project.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import kibera.dron_project.enums.Level;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ObjectSaveDTO {
    private Long id;
    @NotNull
    @NotBlank
    private String name;
    private Long categoryId;
    @NotNull
    private Level level;
    private Long regionId;
    private Long districtId;
    @NotNull
    @NotBlank
    private String address;
    @NotNull
    private BigDecimal latitude;
    @NotNull
    private BigDecimal longitude;
}
