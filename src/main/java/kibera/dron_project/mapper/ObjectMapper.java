package kibera.dron_project.mapper;

import kibera.dron_project.domain.Category;
import kibera.dron_project.domain.District;
import kibera.dron_project.domain.Object;
import kibera.dron_project.domain.Region;
import kibera.dron_project.dto.ObjectDTO;
import kibera.dron_project.dto.ObjectSaveDTO;

public class ObjectMapper {
    public static ObjectDTO toDTO(Object entity) {

        if(entity == null) {
            return null;
        }

        return ObjectDTO
                .builder()
                .id(entity.getId())
                .name(entity.getName())
                .categoryDTO(CategoryMapper.toDTO(entity.getCategory()))
                .level(entity.getLevel())
                .regionDTO(entity.getRegion() != null ? RegionMapper.toDTO(entity.getRegion()) : null)
                .districtDTO(entity.getDistrict() != null ? DistrictMapper.toDTO(entity.getDistrict()) : null)
                .address(entity.getAddress())
                .latitude(entity.getLatitude())
                .longitude(entity.getLongitude())
                .build();
    }

    public static Object toEntity(ObjectSaveDTO dto) {
        return new Object()
                .id(dto.getId())
                .name(dto.getName())
                .category(dto.getCategoryId() != null ? new Category().id(dto.getCategoryId()) : null)
                .level(dto.getLevel())
                .region(dto.getRegionId() != null ? new Region().id(dto.getRegionId()) : null)
                .district(dto.getDistrictId() != null ? new District().id(dto.getDistrictId()) : null)
                .address(dto.getAddress())
                .latitude(dto.getLatitude())
                .longitude(dto.getLongitude());
    }
}
