package kibera.dron_project.mapper;

import kibera.dron_project.domain.Position;
import kibera.dron_project.domain.SensorType;
import kibera.dron_project.dto.PostionDTO;
import kibera.dron_project.dto.SensorTypeDTO;

public class SensorTypeMapper {
    public static SensorTypeDTO toDTO(SensorType entity) {
        return SensorTypeDTO
                .builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    public static SensorType toEntity(SensorTypeDTO dto) {
        return new SensorType()
                .id(dto.getId())
                .name(dto.getName());
    }
}
