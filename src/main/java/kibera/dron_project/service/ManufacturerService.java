package kibera.dron_project.service;

import jakarta.persistence.EntityNotFoundException;
import kibera.dron_project.domain.Manufacturer;
import kibera.dron_project.dto.ManufacturerDTO;
import kibera.dron_project.mapper.ManufacturerMapper;
import kibera.dron_project.mapper.PositionMapper;
import kibera.dron_project.repository.DroneRepository;
import kibera.dron_project.repository.ManufacturerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ManufacturerService {
    private final ManufacturerRepository manufacturerRepository;
    private final DroneRepository droneRepository;

    public List<ManufacturerDTO> getAllManufacturer() {
        List<Manufacturer> positions = manufacturerRepository.findAll();
        return positions
                .stream()
                .map(ManufacturerMapper::toDTO)
                .toList();
    }

    public ManufacturerDTO createManufacturer(ManufacturerDTO manufacturerDTO) {
        return ManufacturerMapper.toDTO(
                manufacturerRepository.save(ManufacturerMapper.toEntity(manufacturerDTO))
        );
    }

    public ManufacturerDTO findById(Long id) {
        return manufacturerRepository
                .findById(id)
                .map(ManufacturerMapper::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("Manufacturer not found"));
    }

    public ManufacturerDTO updateManufacturer(ManufacturerDTO manufacturerDTO) {
        return ManufacturerMapper.toDTO(
                manufacturerRepository.save(ManufacturerMapper.toEntity(manufacturerDTO))
        );
    }

    public void delete(Long id) {
        droneRepository.setNullWhichHasDeletedManufacturer(id);

        manufacturerRepository.deleteById(id);
    }

    public void deleteItems(List<Long> ids) {
        for (Long id : ids) {
            droneRepository.setNullWhichHasDeletedManufacturer(id);
            manufacturerRepository.deleteById(id);
        }
    }
}
