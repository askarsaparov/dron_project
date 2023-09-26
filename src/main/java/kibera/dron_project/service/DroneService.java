package kibera.dron_project.service;

import jakarta.persistence.EntityNotFoundException;
import kibera.dron_project.domain.Drone;
import kibera.dron_project.dto.DroneDTO;
import kibera.dron_project.dto.DroneSaveDTO;
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

    public DroneDTO createDrone(DroneSaveDTO droneDTO) {
        return DroneMapper.toDTO(
                droneRepository.save(DroneMapper.toEntity(droneDTO))
        );
    }

    public DroneDTO updateDrone(DroneSaveDTO droneDTO) {
        return DroneMapper.toDTO(
                droneRepository.save(DroneMapper.toEntity(droneDTO))
        );
    }
}
