package kibera.dron_project.service;

import jakarta.persistence.EntityNotFoundException;
import kibera.dron_project.domain.SensorType;
import kibera.dron_project.dto.SensorTypeDTO;
import kibera.dron_project.mapper.SensorTypeMapper;
import kibera.dron_project.repository.SensorRepository;
import kibera.dron_project.repository.SensorTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SensorTypeService {
    private final SensorTypeRepository sensorTypeRepository;
    private final SensorRepository sensorRepository;


    public List<SensorTypeDTO> getAllSensorType() {
        List<SensorType> sensorTypes = sensorTypeRepository.findAll();
        return sensorTypes
                .stream()
                .map(SensorTypeMapper::toDTO)
                .toList();
    }

    public SensorTypeDTO createSensorType(SensorTypeDTO sensorTypeDTO) {
        return SensorTypeMapper.toDTO(
                sensorTypeRepository.save(SensorTypeMapper.toEntity(sensorTypeDTO))
        );
    }

    public SensorTypeDTO findById(Long id) {
        return sensorTypeRepository
                .findById(id)
                .map(SensorTypeMapper::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("Sensor Type not found"));
    }

    public SensorTypeDTO updateSensorType(SensorTypeDTO sensorTypeDTO) {
        return SensorTypeMapper.toDTO(
                sensorTypeRepository.save(SensorTypeMapper.toEntity(sensorTypeDTO))
        );
    }

    public void delete(Long id) {
        sensorRepository.setNullWhichHasDeletedSensorType(id);

        sensorTypeRepository.deleteById(id);
    }

    public void deleteItems(List<Long> ids) {
        for (Long id : ids) {
            sensorRepository.setNullWhichHasDeletedSensorType(id);

            sensorTypeRepository.deleteById(id);
        }
    }
}
