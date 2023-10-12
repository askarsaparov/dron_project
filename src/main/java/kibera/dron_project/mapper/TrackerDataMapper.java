package kibera.dron_project.mapper;

import kibera.dron_project.domain.TrackerData;
import kibera.dron_project.dto.DroneAttributeDTO;
import kibera.dron_project.dto.TrackerDataDTO;

import java.sql.Timestamp;


public class TrackerDataMapper {
    public static TrackerDataDTO toDTO(TrackerData entity, DroneAttributeDTO attributusDTO) {
        return TrackerDataDTO
                .builder()
                .id(entity.getId())
                .length(entity.getLength())
                .record(entity.getRecord())
                .timestamp(new Timestamp(Long.parseLong(entity.getTimestamp())).toString())
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
