package kibera.dron_project.service;

import kibera.dron_project.domain.Organization;
import kibera.dron_project.repository.OrganizationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationService {
    private final OrganizationRepository organizationRepository;

    public OrganizationService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

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
        organizationRepository.deleteById(id);
    }

//    public List<Organization> findByName(String name) {
//        return organizationRepository.findByName(name);
//    }

//    public List<Organization> findAllByParam(String name) {
//        return organizationRepository.findAllByLikeNative(name);
//    }

}
