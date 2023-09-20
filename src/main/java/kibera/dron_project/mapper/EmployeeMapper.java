package kibera.dron_project.mapper;

import kibera.dron_project.domain.Employee;
import kibera.dron_project.domain.Organization;
import kibera.dron_project.dto.EmployeeDTO;

public class EmployeeMapper {
    public static EmployeeDTO toDTO(Employee entity) {
        return EmployeeDTO
                .builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .surname(entity.getSurname())
                .organizationId(entity.getOrganization() != null ? entity.getOrganization().getId() : null)
                .position(entity.getPosition())
                .birthday(entity.getBirthday())
                .placeOfBirth(entity.getPlaceOfBirth())
                .pasportData(entity.getPasportData())
                .build();
    }

    public static Employee toEntity(EmployeeDTO dto) {
        return new Employee()
                .id(dto.getId())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .surname(dto.getSurname())
                .organization(dto.getOrganizationId() != null ? new Organization().id(dto.getOrganizationId()) : null)
                .position(dto.getPosition())
                .birthday(dto.getBirthday())
                .placeOfBirth(dto.getPlaceOfBirth())
                .pasportData(dto.getPasportData());
    }

}
