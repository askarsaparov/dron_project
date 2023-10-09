package kibera.dron_project.mapper;

import kibera.dron_project.domain.District;
import kibera.dron_project.domain.Region;
import kibera.dron_project.dto.DistrictDTO;
import kibera.dron_project.dto.DistrictSaveDTO;

public class DistrictMapper {
    public static DistrictDTO toDTO(District entity) {
        return DistrictDTO
                .builder()
                .id(entity.getId())
                .name(entity.getName())
                .districtCode(entity.getDistrictCode())
                .region(RegionMapper.toDTO(entity.getRegion()))
                .build();
    }

    public static DistrictSaveDTO toSaveResponse(District entity) {
        return DistrictSaveDTO
                .builder()
                .id(entity.getId())
                .name(entity.getName())
                .districtCode(entity.getDistrictCode())
                .regionId(entity.getRegion() != null ? entity.getRegion().getId() : null)
                .build();
    }

    public static District toEntity(DistrictSaveDTO dto) {
        return new District()
                .id(dto.getId())
                .name(dto.getName())
                .districtCode(dto.getDistrictCode())
                .region(dto.getRegionId() != null ? new Region().id(dto.getRegionId()) : null);
    }
}
