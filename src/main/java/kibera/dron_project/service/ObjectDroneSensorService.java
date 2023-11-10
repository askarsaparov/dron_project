package kibera.dron_project.service;

import kibera.dron_project.domain.Drone;
import kibera.dron_project.domain.Object;
import kibera.dron_project.domain.Sensor;
import kibera.dron_project.dto.ObjDroneSensorDTO;
import kibera.dron_project.enums.Type;
import kibera.dron_project.repository.DroneRepository;
import kibera.dron_project.repository.ObjectRepository;
import kibera.dron_project.repository.SensorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ObjectDroneSensorService {
    private final ObjectRepository objectRepository;
    private final SensorRepository sensorRepository;
    private final DroneRepository droneRepository;

    @Transactional(readOnly = true)
    public List<ObjDroneSensorDTO> search(String keyword, Boolean name, Boolean code, Boolean object, Boolean drone, Boolean sensor) {

        List<ObjDroneSensorDTO> response = new ArrayList<>();

        List<ObjDroneSensorDTO> objects = (Boolean.TRUE.equals(object) && Boolean.TRUE.equals(name))
                ? objectRepository.searchObjectDashboard(keyword)
                : Collections.emptyList();

        List<ObjDroneSensorDTO> drones = (Boolean.TRUE.equals(drone) && (Boolean.TRUE.equals(name) && Boolean.TRUE.equals(code)))
                ? droneRepository.searchDashboardNameCode(keyword)
                : (Boolean.TRUE.equals(name) && Boolean.FALSE.equals(code))
                ? droneRepository.searchDashboardName(keyword)
                : (Boolean.FALSE.equals(name) && Boolean.TRUE.equals(code))
                ? droneRepository.searchDashboardCode(keyword)
                : Collections.emptyList();

        List<ObjDroneSensorDTO> sensors = (Boolean.TRUE.equals(sensor) && (Boolean.TRUE.equals(name) && Boolean.TRUE.equals(code)))
                ? sensorRepository.searchDashboardNameCode(keyword)
                : (Boolean.TRUE.equals(name) && Boolean.FALSE.equals(code))
                ? sensorRepository.searchDashboardName(keyword)
                : (Boolean.FALSE.equals(name) && Boolean.TRUE.equals(code))
                ? sensorRepository.searchDashboardCode(keyword)
                : Collections.emptyList();

        response.addAll(drones);
        response.addAll(objects);
        response.addAll(sensors);

        return response;
    }
}
