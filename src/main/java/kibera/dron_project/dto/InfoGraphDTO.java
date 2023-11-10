package kibera.dron_project.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InfoGraphDTO {
    private Long drones;
    private Long objects;
    private Long brands;
    private Long countryOrigin;
    private Long regions;
    private Long districts;
    private Long employees;
    private Long manufacturers;
    private Long organizations;
    private Long positions;
    private Long sensors;
}
