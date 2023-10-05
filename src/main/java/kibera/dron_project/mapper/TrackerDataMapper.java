package kibera.dron_project.mapper;

import kibera.dron_project.domain.TrackerData;
import kibera.dron_project.dto.DroneAttributeDTO;
import kibera.dron_project.dto.TrackerDataDTO;

public class TrackerDataMapper {
    public static TrackerDataDTO toDTO(TrackerData entity, DroneAttributeDTO attributusDTO) {
        return TrackerDataDTO
                .builder()
                .id(entity.getId())
                .length(entity.getLength())
                .record(entity.getRecord())
                .timestamp(entity.getTimestamp())
                .priority(entity.getPriority())
                .latitude(entity.getLatitude())
                .longitude(entity.getLongitude())
                .altitude(entity.getAltitude())
                .angle(entity.getAngle())
                .satellites(entity.getSatellites())
                .speed(entity.getSpeed())
                .droneAttributeDTO(attributusDTO)
                .build();
    }
}
