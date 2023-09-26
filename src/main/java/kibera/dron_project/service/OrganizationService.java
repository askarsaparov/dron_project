package kibera.dron_project.service;

import kibera.dron_project.domain.Organization;
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

    public Organization save(Organization organization) {
        return organizationRepository.save(organization);
    }

    public List<Organization> findAll() {
        return organizationRepository.findAll();
    }

    public Organization findById(Long id) {
        return organizationRepository.findById(id).get();
    }

    public void delete(Long id) {

        employeeRepository.setNullWhichHasDeletedOrganization(id);
        droneRepository.setNullWhichHasDeletedOrganization(id);

        organizationRepository.deleteById(id);
    }

}
