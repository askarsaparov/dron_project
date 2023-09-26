package kibera.dron_project.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationDTO {

    private Long id;
    private String name;
    private String region;
    private String district;
    private String address;

}
