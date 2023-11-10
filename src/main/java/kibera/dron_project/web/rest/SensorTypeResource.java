package kibera.dron_project.web.rest;

import jakarta.validation.Valid;
import kibera.dron_project.dto.PostionDTO;
import kibera.dron_project.dto.SensorTypeDTO;
import kibera.dron_project.service.PositionService;
import kibera.dron_project.service.SensorTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class SensorTypeResource {
    private final SensorTypeService sensorTypeService;

    @GetMapping("/sensor-type")
    public ResponseEntity<List<SensorTypeDTO>> getAll() {
        List<SensorTypeDTO> sensorTypeDTO =  sensorTypeService.getAllSensorType();
        return ResponseEntity.ok(sensorTypeDTO);
    }

    @PostMapping("/sensor-type")
    public ResponseEntity<SensorTypeDTO> create(@RequestBody @Valid SensorTypeDTO sensorTypeDTO) {
        return ResponseEntity.ok(
                sensorTypeService.createSensorType(sensorTypeDTO)
        );
    }

    @GetMapping("/sensor-type/{id}")
    public ResponseEntity<SensorTypeDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(sensorTypeService.findById(id));
    }

    @PutMapping("/sensor-type")
    public ResponseEntity<SensorTypeDTO> update(@RequestBody SensorTypeDTO sensorTypeDTO) {
        return ResponseEntity.ok(
                sensorTypeService.updateSensorType(sensorTypeDTO)
        );
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/sensor-type/{id}")
    public void delete(@PathVariable Long id) {
        sensorTypeService.delete(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/sensor-type/multidelete")
    public void deleteItems(@RequestBody List<Long> ids) {
        sensorTypeService.deleteItems(ids);
    }
}
