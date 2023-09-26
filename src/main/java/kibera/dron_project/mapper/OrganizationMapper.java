package kibera.dron_project.mapper;

import kibera.dron_project.domain.Organization;
import kibera.dron_project.dto.OrganizationDTO;

public class OrganizationMapper {

    public static OrganizationDTO toDTO(Organization organization) {

        if (organization != null) {
            return OrganizationDTO
                    .builder()
                    .id(organization.getId())
                    .name(organization.getName())
                    .region(organization.getRegion())
                    .district(organization.getDistrict())
                    .address(organization.getAddress())
                    .build();
        } else {
            return null;
        }

    }

}
