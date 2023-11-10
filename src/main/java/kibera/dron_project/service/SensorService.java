package kibera.dron_project.service;

import jakarta.persistence.EntityNotFoundException;
import kibera.dron_project.domain.Drone;
import kibera.dron_project.domain.Object;
import kibera.dron_project.domain.Sensor;
import kibera.dron_project.dto.*;
import kibera.dron_project.enums.TypeHost;
import kibera.dron_project.mapper.DroneMapper;
import kibera.dron_project.mapper.ObjectMapper;
import kibera.dron_project.mapper.SensorMapper;
import kibera.dron_project.repository.DroneRepository;
import kibera.dron_project.repository.ObjectRepository;
import kibera.dron_project.repository.SensorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SensorService {
    private final SensorRepository sensorRepository;
    private final DroneRepository droneRepository;
    private final ObjectRepository objectRepository;

    public List<SensorDTO> getAllSensor() {
        List<Sensor> sensor = sensorRepository.findAll();
        return sensor
                .stream()
                .map(SensorMapper::toDTO)
                .toList();
    }

    public SensorSaveDTO createSensor(SensorSaveDTO sensorSaveDTO) {
        sensorSaveDTO.setId(null);

        return SensorMapper.toSaveResponse(
                sensorRepository.save(SensorMapper.toEntity(sensorSaveDTO))
        );
    }

    public SensorDTO findById(Long id) {
        return sensorRepository
                .findById(id)
                .map(s -> {

                    Long hostId = s.getHostId();

                    if(hostId == null) {
                        return SensorMapper.toDTO(s);
                    } else {

                        ObjectDTO object = null;
                        DroneDTO drone = null;

                        if(s.getTypeHost().equals(TypeHost.OBJECT)) {
                            object = objectRepository
                                    .findById(s.getHostId())
                                    .map(ObjectMapper::toDTO)
                                    .orElseThrow(() -> new EntityNotFoundException("Object not found"));
                        } else {
                            drone = droneRepository
                                    .findById(s.getHostId())
                                    .map(DroneMapper::toDTO)
                                    .orElseThrow(() -> new EntityNotFoundException("Drone not found"));
                        }

                        return SensorMapper.toDTO(s, drone, object);
                    }

                })
                .orElseThrow(() -> new EntityNotFoundException("Sensor not found"));
    }

    public SensorSaveDTO updateSensor(SensorSaveDTO sensorSaveDTO) {

        Sensor oldSensor = sensorRepository
                .findById(sensorSaveDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("Sensor not found"));

        Sensor sensor = SensorMapper.toEntity(sensorSaveDTO);

        sensor.setHostId(oldSensor.getHostId() != null ? oldSensor.getHostId() : null);
        sensor.setTypeHost(oldSensor.getTypeHost() != null ? oldSensor.getTypeHost() : null);

        return SensorMapper.toSaveResponse(
                sensorRepository.save(sensor)
        );
    }

    public void delete(Long id) {
        sensorRepository.deleteById(id);
    }

    public void deleteItems(List<Long> ids) {
        for (Long id : ids) {
            sensorRepository.deleteById(id);
        }
    }

    public SensorDTO updateSensorHost(SensorHostDTO sensorDTO) {
        Sensor sensor = sensorRepository
                .findById(sensorDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("Sensor not found"));


        sensor.setTypeHost(sensorDTO.getTypeHost());
        if (sensor.getTypeHost() == TypeHost.DRONE) {
            Drone drone = droneRepository
                    .findById(sensorDTO.getHostId())
                    .orElseThrow(() -> new EntityNotFoundException("Drone not found"));
        } else if (sensor.getTypeHost() == TypeHost.OBJECT) {
            Object object = objectRepository
                    .findById(sensorDTO.getHostId())
                    .orElseThrow(() -> new EntityNotFoundException("Object not found"));
        }
        sensor.setHostId(sensorDTO.getHostId());

        sensorRepository.save(sensor);

        Long hostId = sensor.getHostId();

        if(hostId == null) {
            return SensorMapper.toDTO(sensor);
        } else {

            ObjectDTO object = null;
            DroneDTO drone = null;

            if(sensor.getTypeHost().equals(TypeHost.OBJECT)) {
                object = objectRepository
                        .findById(sensor.getHostId())
                        .map(ObjectMapper::toDTO)
                        .orElseThrow(() -> new EntityNotFoundException("Object not found"));
            } else {
                drone = droneRepository
                        .findById(sensor.getHostId())
                        .map(DroneMapper::toDTO)
                        .orElseThrow(() -> new EntityNotFoundException("Drone not found"));
            }

            return SensorMapper.toDTO(sensor, drone, object);
        }
    }

    public List<Sensor> filterDrone(Long droneId) {
        return sensorRepository.filterDrone(droneId);
    }

    public List<Sensor> filterObject(Long objectId) {
        return sensorRepository.filterObject(objectId);
    }

    public List<Sensor> filterUnused() {
        return sensorRepository.filterUnused();
    }
}
