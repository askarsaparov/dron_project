package kibera.dron_project.mapper;

import kibera.dron_project.domain.Drone;
import kibera.dron_project.domain.Employee;
import kibera.dron_project.domain.Organization;
import kibera.dron_project.dto.DroneDTO;

public class DroneMapper {
    public static DroneDTO toDTO(Drone entity) {
        return DroneDTO
                .builder()
                .id(entity.getId())
                .drone_id(entity.getDrone_id())
                .name(entity.getName())
                .brand(entity.getBrand())
                .model(entity.getModel())
                .manufacturer(entity.getManufacturer())
                .countryOrigin(entity.getCountryOrigin())
                .productionYear(entity.getProductionYear())
                .mood(entity.getMood())
                .ownerId(entity.getOwner() != null ? entity.getOwner().getId() : null)
                .operatorId(entity.getOperator() != null ? entity.getOperator().getId() : null)
                .status(entity.getStatus())
                .build();
    }

    public static Drone toEntity(DroneDTO dto) {
        return new Drone()
                .id(dto.getId())
                .drone_id(dto.getDrone_id())
                .name(dto.getName())
                .brand(dto.getBrand())
                .model(dto.getModel())
                .manufacturer(dto.getManufacturer())
                .countryOrigin(dto.getCountryOrigin())
                .productionYear(dto.getProductionYear())
                .mood(dto.getMood())
                .owner(dto.getOwnerId() != null ? new Organization().id(dto.getOwnerId()) : null)
                .operator(dto.getOperatorId() != null ? new Employee().id(dto.getOperatorId()) : null)
                .status(dto.getStatus());
    }
}
