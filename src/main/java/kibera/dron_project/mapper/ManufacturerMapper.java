package kibera.dron_project.mapper;

import kibera.dron_project.domain.Manufacturer;
import kibera.dron_project.dto.ManufacturerDTO;

public class ManufacturerMapper {
    public static ManufacturerDTO toDTO(Manufacturer entity) {
        return ManufacturerDTO
                .builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    public static Manufacturer toEntity(ManufacturerDTO dto) {
        return new Manufacturer()
                .id(dto.getId())
                .name(dto.getName());
    }
}
