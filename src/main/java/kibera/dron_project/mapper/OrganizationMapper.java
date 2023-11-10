package kibera.dron_project.mapper;

import kibera.dron_project.domain.District;
import kibera.dron_project.domain.Organization;
import kibera.dron_project.domain.Region;
import kibera.dron_project.dto.DistrictDTO;
import kibera.dron_project.dto.DistrictSaveDTO;
import kibera.dron_project.dto.OrganizationDTO;
import kibera.dron_project.dto.OrganizationSaveDTO;

public class OrganizationMapper {

    public static OrganizationDTO toDTO(Organization entity) {
        if (entity == null) {
            return null;
        }
        return OrganizationDTO
                .builder()
                .id(entity.getId())
                .name(entity.getName())
                .regionDTO(entity.getRegion() != null ? RegionMapper.toDTO(entity.getRegion()) : null)
                .districtDTO(entity.getDistrict() != null ? DistrictMapper.toDTO(entity.getDistrict()) : null)
                .address((entity.getAddress()))
                .color((entity.getColor()))
                .build();
    }

    public static Organization toEntity(OrganizationSaveDTO dto) {
        return new Organization()
                .id(dto.getId())
                .name(dto.getName())
                .region(dto.getRegionId() != null ? new Region().id(dto.getRegionId()) : null)
                .district(dto.getDistrictId() != null ? new District().id(dto.getDistrictId()) : null)
                .color(dto.getColor())
                .address(dto.getAddress());
    }

}
