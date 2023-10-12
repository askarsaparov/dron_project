package kibera.dron_project.dto;

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
    private String name;
    private Long categoryId;
    private Level level;
    private Long regionId;
    private Long districtId;
    private String address;
    private BigDecimal latitude;
    private BigDecimal longitude;
}
