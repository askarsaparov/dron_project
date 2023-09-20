package kibera.dron_project.service;

import jakarta.persistence.EntityNotFoundException;
import kibera.dron_project.domain.Drone;
import kibera.dron_project.dto.DroneDTO;
import kibera.dron_project.mapper.DroneMapper;
import kibera.dron_project.repository.DroneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
        Drone drone = droneRepository.getOne(id);
        droneRepository.delete(drone);
    }

    public List<DroneDTO> getAllDrone() {
        List<Drone> drones = droneRepository.findAll();
        return drones
                .stream()
                .map(DroneMapper::toDTO)
                .toList();
    }

    public DroneDTO createDrone(DroneDTO droneDTO) {
        return DroneMapper.toDTO(
                droneRepository.save(DroneMapper.toEntity(droneDTO))
        );
    }

    public DroneDTO updateDrone(DroneDTO droneDTO) {
        return DroneMapper.toDTO(
                droneRepository.save(DroneMapper.toEntity(droneDTO))
        );
    }
}
