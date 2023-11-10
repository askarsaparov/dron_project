package kibera.dron_project.service;

import kibera.dron_project.domain.CountryOrigin;
import kibera.dron_project.dto.InfoDTO;
import kibera.dron_project.dto.InfoGraphDTO;
import kibera.dron_project.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InfoGraphService {
    private final DroneRepository droneRepository;
    private final ObjectRepository objectRepository;
    private final BrandRepository brandRepository;
    private final CountryOriginRepository countryOriginRepository;
    private final RegionRepository regionRepository;
    private final DistrictRepository districtRepository;
    private final EmployeeRepository employeeRepository;
    private final ManufacturerRepository manufacturerRepository;
    private final OrganizationRepository organizationRepository;
    private final PositionRepository positionRepository;
    private final SensorRepository sensorRepository;


    public InfoGraphDTO getInfo() {
        InfoGraphDTO response = new InfoGraphDTO();

        response.setDrones(droneRepository.count());
        response.setObjects(objectRepository.count());
        response.setBrands(brandRepository.count());
        response.setCountryOrigin(countryOriginRepository.count());
        response.setRegions(regionRepository.count());
        response.setDistricts(districtRepository.count());
        response.setEmployees(employeeRepository.count());
        response.setManufacturers(manufacturerRepository.count());
        response.setOrganizations(organizationRepository.count());
        response.setPositions(positionRepository.count());
        response.setSensors(sensorRepository.count());

        return response;
    }
}
