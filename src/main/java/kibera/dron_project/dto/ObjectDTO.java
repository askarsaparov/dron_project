package kibera.dron_project.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import kibera.dron_project.enums.Level;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ObjectDTO {
    private Long id;
    private String name;
    private CategoryDTO categoryDTO;
    private Level level;
    private RegionDTO regionDTO;
    private DistrictDTO districtDTO;
    private String address;
    private BigDecimal latitude;
    private BigDecimal longitude;
}
