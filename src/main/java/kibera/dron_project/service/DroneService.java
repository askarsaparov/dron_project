package kibera.dron_project.service;

import java.util.Map;
import java.util.Optional;

import jakarta.persistence.EntityNotFoundException;
import kibera.dron_project.domain.Drone;
import kibera.dron_project.dto.DroneDTO;
import kibera.dron_project.dto.DroneFollowDTO;
import kibera.dron_project.dto.DroneSaveDTO;
import kibera.dron_project.enums.Condition;
import kibera.dron_project.mapper.DroneMapper;
import kibera.dron_project.repository.DroneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class DroneService {
    private final DroneRepository droneRepository;

    public DroneDTO findById(Long id) {
        return droneRepository
                .findById(id)
                .map(DroneMapper::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("Drone not found"));
    }

    public void delete(Long id) {
        droneRepository.deleteById(id);
    }

    public List<DroneDTO> getAllDrone() {
        List<Drone> drones = droneRepository.findAll();
        return drones
                .stream()
                .map(DroneMapper::toDTO)
                .toList();
    }

    public DroneSaveDTO createDrone(DroneSaveDTO droneDTO) {
        droneRepository.save(DroneMapper.toEntity(droneDTO));
        return droneDTO;
    }

    public DroneDTO updateDrone(DroneSaveDTO droneDTO) {
        return DroneMapper.toDTO(
                droneRepository.save(DroneMapper.toEntity(droneDTO))
        );
    }

    public List<Drone> searchDrone(String keyword) {
        return droneRepository.searchDrone(keyword);
    }

    public List<Drone> filterDrone(Condition condition) {
        return droneRepository.filterDrone(condition);
    }

    public List<Drone> filterDroneOrganizationId(Long organizationId) {
        return droneRepository.filterDroneOrganizationId(organizationId);
    }

    public List<Drone> filterDroneId(String droneId) {
        return droneRepository.filterDroneId(droneId);
    }

    public DroneDTO updateTarget(Long id, DroneFollowDTO droneFollowDTO) {

        Drone drone = droneRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Drone not found"));

        drone.setTarget(droneFollowDTO.getTarget());

        return DroneMapper.toDTO(droneRepository.save(drone));
    }

    public void deleteItems(List<Long> ids) {
        for (Long id : ids) {
            droneRepository.deleteById(id);
        }
    }
}
