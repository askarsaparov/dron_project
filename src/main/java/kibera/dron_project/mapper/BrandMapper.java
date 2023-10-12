package kibera.dron_project.mapper;

import kibera.dron_project.domain.Brand;
import kibera.dron_project.dto.BrandDTO;

public class BrandMapper {
    public static BrandDTO toDTO(Brand entity) {
        return BrandDTO
                .builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    public static Brand toEntity(BrandDTO dto) {
        return new Brand()
                .id(dto.getId())
                .name(dto.getName());
    }
}
