package kibera.dron_project.web.rest;

import jakarta.validation.Valid;
import kibera.dron_project.domain.Sensor;
import kibera.dron_project.domain.TrackerData;
import kibera.dron_project.dto.SensorDTO;
import kibera.dron_project.dto.SensorHostDTO;
import kibera.dron_project.dto.SensorSaveDTO;
import kibera.dron_project.enums.TypeHost;
import kibera.dron_project.service.SensorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class SensorResource {
    private final SensorService sensorService;

    @GetMapping("/sensor")
    public ResponseEntity<List<SensorDTO>> getAll() {
        List<SensorDTO> sensorDTO =  sensorService.getAllSensor();
        return ResponseEntity.ok(sensorDTO);
    }

    @PostMapping("/sensor")
    public ResponseEntity<SensorSaveDTO> create(@RequestBody @Valid SensorSaveDTO sensorDTO) {
        return ResponseEntity.ok(
                sensorService.createSensor(sensorDTO)
        );
    }

    @GetMapping("/sensor/{id}")
    public ResponseEntity<SensorDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(sensorService.findById(id));
    }

    @PutMapping("/sensor")
    public ResponseEntity<SensorSaveDTO> update(@RequestBody SensorSaveDTO sensorDTO) {
        return ResponseEntity.ok(
                sensorService.updateSensor(sensorDTO)
        );
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/sensor/{id}")
    public void delete(@PathVariable Long id) {
        sensorService.delete(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/sensor/multidelete")
    public void deleteItems(@RequestBody List<Long> ids) {
        sensorService.deleteItems(ids);
    }

    @PutMapping("/sensor/add-host/")
    public ResponseEntity<SensorDTO> update(@RequestBody SensorHostDTO sensorDTO) {
        return ResponseEntity.ok(
                sensorService.updateSensorHost(sensorDTO)
        );
    }

    @GetMapping("/sensor/filter/drone")
    public List<Sensor> filterDrone(@RequestParam(required = true) Long droneId) {
        return sensorService.filterDrone(droneId);
    }

    @GetMapping("/sensor/filter/object")
    public List<Sensor> filterObject(@RequestParam(required = true) Long objectId) {
        return sensorService.filterObject(objectId);
    }

    @GetMapping("/sensor/filter/unused")
    public List<Sensor> filterObject() {
        return sensorService.filterUnused();
    }
}
