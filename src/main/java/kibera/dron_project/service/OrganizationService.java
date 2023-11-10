package kibera.dron_project.service;

import jakarta.persistence.EntityNotFoundException;
import kibera.dron_project.domain.Object;
import kibera.dron_project.domain.Organization;
import kibera.dron_project.dto.ObjectDTO;
import kibera.dron_project.dto.ObjectSaveDTO;
import kibera.dron_project.dto.OrganizationDTO;
import kibera.dron_project.dto.OrganizationSaveDTO;
import kibera.dron_project.mapper.ObjectMapper;
import kibera.dron_project.mapper.OrganizationMapper;
import kibera.dron_project.repository.DroneRepository;
import kibera.dron_project.repository.EmployeeRepository;
import kibera.dron_project.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class OrganizationService {

    private final OrganizationRepository organizationRepository;
    private final EmployeeRepository employeeRepository;
    private final DroneRepository droneRepository;

    public List<OrganizationDTO> getAllOrganization() {
        List<Organization> organization = organizationRepository.findAll();
        return organization
                .stream()
                .map(OrganizationMapper::toDTO)
                .toList();
    }

    public OrganizationSaveDTO createOrganization(OrganizationSaveDTO organizationSaveDTO) {
        organizationSaveDTO.setId(null);
        organizationRepository.save(OrganizationMapper.toEntity(organizationSaveDTO));
        return organizationSaveDTO;
    }

    public OrganizationDTO findById(Long id) {
        return organizationRepository
                .findById(id)
                .map(OrganizationMapper::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("Organization not found"));
    }

    public OrganizationSaveDTO updateOrganization(OrganizationSaveDTO organizationSaveDTO) {
        organizationRepository.save(OrganizationMapper.toEntity(organizationSaveDTO));
        return organizationSaveDTO;
    }

    public void delete(Long id) {

        employeeRepository.setNullWhichHasDeletedOrganization(id);
        droneRepository.setNullWhichHasDeletedOrganization(id);

        organizationRepository.deleteById(id);
    }

    public void deleteItems(List<Long> ids) {
        for (Long id : ids) {
            employeeRepository.setNullWhichHasDeletedOrganization(id);
            droneRepository.setNullWhichHasDeletedOrganization(id);
            organizationRepository.deleteById(id);
        }
    }
}
