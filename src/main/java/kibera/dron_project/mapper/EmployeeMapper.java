package kibera.dron_project.mapper;

import kibera.dron_project.domain.Employee;
import kibera.dron_project.domain.Organization;
import kibera.dron_project.domain.Position;
import kibera.dron_project.dto.EmployeeDTO;
import kibera.dron_project.dto.EmployeeSaveDTO;

public class EmployeeMapper {
    public static EmployeeDTO toDTO(Employee entity) {

        if(entity == null) {
            return null;
        }

        return EmployeeDTO
                .builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .surname(entity.getSurname())
                .organizationDTO(entity.getOrganization() != null ? OrganizationMapper.toDTO(entity.getOrganization()) : null)
                .positionDTO(entity.getPosition() != null ? PositionMapper.toDTO(entity.getPosition()) : null)
                .birthday(entity.getBirthday())
                .placeOfBirth(entity.getPlaceOfBirth())
                .passportData(entity.getPasportData())
                .build();
    }

    public static Employee toEntity(EmployeeSaveDTO dto) {
        return new Employee()
                .id(dto.getId())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .surname(dto.getSurname())
                .organization(dto.getOrganizationId() != null ? new Organization().id(dto.getOrganizationId()) : null)
                .position(dto.getPositionId() != null ? new Position().id(dto.getPositionId()) : null)
                .birthday(dto.getBirthday())
                .placeOfBirth(dto.getPlaceOfBirth())
                .pasportData(dto.getPassportData());
    }

}
