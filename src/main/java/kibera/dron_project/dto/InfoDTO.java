package kibera.dron_project.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InfoDTO {
    private Long drones;
    private Long objects;
    private Long targetDrones;
}
