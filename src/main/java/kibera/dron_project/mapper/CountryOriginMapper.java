package kibera.dron_project.mapper;

import kibera.dron_project.domain.CountryOrigin;
import kibera.dron_project.dto.CountryOriginDTO;

public class CountryOriginMapper {
    public static CountryOriginDTO toDTO(CountryOrigin entity) {
        return CountryOriginDTO
                .builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    public static CountryOrigin toEntity(CountryOriginDTO dto) {
        return new CountryOrigin()
                .id(dto.getId())
                .name(dto.getName());
    }
}
