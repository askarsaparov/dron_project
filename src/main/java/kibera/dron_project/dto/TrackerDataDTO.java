package kibera.dron_project.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrackerDataDTO {
    private Long id;
    private String length;
    private String record;
    private String timestamp;
    private String priority;
    private String latitude;
    private String longitude;
    private String altitude;
    private String angle;
    private String satellites;
    private String speed;
    private DroneAttributeDTO droneAttributeDTO;
}
