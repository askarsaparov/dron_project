package kibera.dron_project.mapper;

import kibera.dron_project.domain.Position;
import kibera.dron_project.dto.PostionDTO;

public class PositionMapper {
    public static PostionDTO toDTO(Position entity) {
        return PostionDTO
                .builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    public static Position toEntity(PostionDTO dto) {
        return new Position()
                .id(dto.getId())
                .name(dto.getName());
    }
}
