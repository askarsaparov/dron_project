package kibera.dron_project.mapper;

import kibera.dron_project.domain.*;
import kibera.dron_project.dto.DroneAttributeDTO;
import kibera.dron_project.dto.DroneDTO;
import kibera.dron_project.dto.DroneSaveDTO;

public class DroneMapper {
    public static DroneDTO toDTO(Drone entity) {
        return DroneDTO
                .builder()
                .id(entity.getId())
                .drone_id(entity.getDrone_id())
                .name(entity.getName())
                .brandDTO(entity.getBrand() != null ? BrandMapper.toDTO(entity.getBrand()) : null)
                .model(entity.getModel())
                .manufacturerDTO(entity.getManufacturer() != null ? ManufacturerMapper.toDTO(entity.getManufacturer()) : null)
                .countryOriginDTO(entity.getCountryOrigin() != null ? CountryOriginMapper.toDTO(entity.getCountryOrigin()) : null)
                .productionYear(entity.getProductionYear())
                .condition(entity.getCondition())
                .ownerDTO(OrganizationMapper.toDTO(entity.getOwner()))
                .operatorDTO(EmployeeMapper.toDTO(entity.getOperator()))
                .status(entity.getStatus())
                .target(entity.getTarget())
                .build();
    }

//    public static DroneAttributeDTO toAttributesDTO(Drone entity) {
//        return DroneAttributeDTO
//                .builder()
//                .id(entity.getId())
//                .drone_id(entity.getDrone_id())
//                .name(entity.getName())
//                .brand(entity.getBrand())
//                .model(entity.getModel())
//                .manufacturer(entity.getManufacturer())
//                .countryOrigin(entity.getCountryOrigin())
//                .condition(entity.getCondition())
//                .status(entity.getStatus())
//                .target(entity.getTarget())
//                .build();
//    }

    public static Drone toEntity(DroneSaveDTO dto) {
        return new Drone()
                .id(dto.getId())
                .drone_id(dto.getDrone_id())
                .name(dto.getName())
                .brand(dto.getBrandId() != null ? new Brand().id(dto.getBrandId()) : null)
                .model(dto.getModel())
                .manufacturer(dto.getManufacturerId() != null ? new Manufacturer().id(dto.getManufacturerId()) : null)
                .countryOrigin(dto.getCountryOriginId() != null ? new CountryOrigin().id(dto.getCountryOriginId()) : null)
                .productionYear(dto.getProductionYear())
                .condition(dto.getCondition())
                .owner(dto.getOwnerId() != null ? new Organization().id(dto.getOwnerId()) : null)
                .operator(dto.getOperatorId() != null ? new Employee().id(dto.getOperatorId()) : null)
                .status(dto.getStatus())
                .target(dto.getTarget() != null ? dto.getTarget() : false);
    }

}
