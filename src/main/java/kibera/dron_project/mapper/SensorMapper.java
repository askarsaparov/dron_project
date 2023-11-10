package kibera.dron_project.mapper;

import kibera.dron_project.domain.*;
import kibera.dron_project.dto.*;
import kibera.dron_project.enums.TypeHost;
import kibera.dron_project.repository.DroneRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SensorMapper {
    private final DroneRepository droneRepository;

    public static SensorDTO toDTO(Sensor entity) {
        return SensorDTO
                .builder()
                .id(entity.getId())
                .name(entity.getName())
                .sensorId(entity.getSensorId())
                .sensorTypeDTO(SensorTypeMapper.toDTO(entity.getSensorType()))
                .model(entity.getModel())
                .manufacturerDTO(ManufacturerMapper.toDTO(entity.getManufacturer()))
                .countryOriginDTO(CountryOriginMapper.toDTO(entity.getCountryOrigin()))
                .productionYear(entity.getProductionYear())
                .condition(entity.getCondition())
                .status(entity.getStatus())
                .build();
    }

    public static SensorDTO toDTO(Sensor entity, DroneDTO drone, ObjectDTO object) {
        return SensorDTO
                .builder()
                .id(entity.getId())
                .name(entity.getName())
                .sensorId(entity.getSensorId())
                .sensorTypeDTO(SensorTypeMapper.toDTO(entity.getSensorType()))
                .model(entity.getModel())
                .manufacturerDTO(ManufacturerMapper.toDTO(entity.getManufacturer()))
                .countryOriginDTO(CountryOriginMapper.toDTO(entity.getCountryOrigin()))
                .productionYear(entity.getProductionYear())
                .condition(entity.getCondition())
                .status(entity.getStatus())
                .host(entity.getTypeHost() != null ? (entity.getTypeHost().equals(TypeHost.OBJECT) ? object : drone) : null)
                .typeHost(entity.getTypeHost() != null ? entity.getTypeHost() : null)
                .build();
    }

    public static SensorSaveDTO toSaveResponse(Sensor entity) {
        return SensorSaveDTO
                .builder()
                .id(entity.getId())
                .name(entity.getName())
                .sensorId(entity.getSensorId())
                .sensorTypeId(entity.getSensorType() != null ? entity.getSensorType().getId() : null)
                .model(entity.getModel())
                .manufacturerId(entity.getManufacturer() != null ? entity.getManufacturer().getId() : null)
                .countryOriginId(entity.getCountryOrigin() != null ? entity.getCountryOrigin().getId() : null)
                .productionYear(entity.getProductionYear())
                .condition(entity.getCondition())
                .status(entity.getStatus())
                .build();
    }

    public static Sensor toEntity(SensorSaveDTO dto) {
        return new Sensor()
                .id(dto.getId())
                .name(dto.getName())
                .sensorId(dto.getSensorId())
                .sensorType(dto.getSensorTypeId() != null ? new SensorType().id(dto.getSensorTypeId()) : null)
                .model(dto.getModel())
                .manufacturer(dto.getManufacturerId() != null ? new Manufacturer().id(dto.getManufacturerId()) : null)
                .countryOrigin(dto.getCountryOriginId() != null ? new CountryOrigin().id(dto.getCountryOriginId()) : null)
                .productionYear(dto.getProductionYear())
                .condition(dto.getCondition())
                .status(dto.getStatus());
    }
}
//        if (entity.getTypeHost() != null) {
//            sensorDTO.setTypeHost(entity.getTypeHost());
//
//            if (entity.getHostId() != null) {
//                TypeHost typeHost = entity.getTypeHost();
//                if (typeHost == TypeHost.DRONE) {
//                    Drone drone = droneRepository.findById(entity.getHostId());
//                    DroneDTO droneDTO = DroneMapper.toDTO(drone);
//                    sensorDTO.setHost(droneDTO);
//                }
//            }
//        }