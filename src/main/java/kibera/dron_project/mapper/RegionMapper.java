package kibera.dron_project.mapper;

import kibera.dron_project.domain.Region;
import kibera.dron_project.dto.RegionDTO;

public class RegionMapper {
    public static RegionDTO toDTO(Region entity) {
        return RegionDTO
                .builder()
                .id(entity.getId())
                .regionCode(entity.getRegionCode())
                .name(entity.getName())
                .build();
    }

    public static Region toEntity(RegionDTO dto) {
        return new Region()
                .id(dto.getId())
                .regionCode(dto.getRegionCode())
                .name(dto.getName());
    }
}
