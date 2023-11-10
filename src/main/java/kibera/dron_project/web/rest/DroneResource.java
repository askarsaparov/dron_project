package kibera.dron_project.web.rest;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import kibera.dron_project.domain.Drone;
import kibera.dron_project.domain.Organization;
import kibera.dron_project.dto.DroneDTO;
import kibera.dron_project.dto.DroneFollowDTO;
import kibera.dron_project.dto.DroneSaveDTO;
import kibera.dron_project.enums.Condition;
import kibera.dron_project.mapper.DroneMapper;
import kibera.dron_project.repository.DroneRepository;
import kibera.dron_project.service.DroneService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class DroneResource {
    private final DroneService droneService;
    private final DroneRepository droneRepository;

    @GetMapping("/drone")
    public ResponseEntity<List<DroneDTO>> getAll() {
        List<DroneDTO> droneList = droneService.getAllDrone();
        return ResponseEntity.ok(droneList);
    }

    @PostMapping("/drone")
    public ResponseEntity<DroneSaveDTO> create(@RequestBody @Valid DroneSaveDTO droneDTO) {
        return ResponseEntity.ok(
                droneService.createDrone(droneDTO)
        );
    }

    @GetMapping("/drone/{id}") // This maps to a GET request with a path parameter {id}
    public ResponseEntity<DroneDTO> getById(@PathVariable Long id) {
        DroneDTO drone = droneService.findById(id);
        return ResponseEntity.ok(drone);
    }

    @PutMapping("/drone")
    public ResponseEntity<DroneDTO> update(@RequestBody DroneSaveDTO droneDTO) {
        return ResponseEntity.ok(
                droneService.updateDrone(droneDTO)
        );
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/drone/{id}")
    public void delete(@PathVariable Long id) {
        droneService.delete(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/drone/multidelete")
    public void deleteItems(@RequestBody List<Long> ids) {
        droneService.deleteItems(ids);
    }

    @GetMapping("/drone/search")
    public List<Drone> searchDrone(@RequestParam String value) {
        return droneService.searchDrone(value);
    }

    @GetMapping("/drone/filter")
    public List<Drone> filterDrone(@RequestParam(required = false) Long organizationId, @RequestParam(required = false) Condition condition,
                                   @RequestParam(required = false) String droneId) {
        if (organizationId != null) {
            return droneService.filterDroneOrganizationId(organizationId);
        }
        if (condition != null) {
            return droneService.filterDrone(condition);
        }
        return droneService.filterDroneId(droneId);
    }

    @PutMapping("/drone/follow/{id}")
    public ResponseEntity<DroneDTO> updateDroneTarget(@PathVariable Long id, @RequestBody DroneFollowDTO droneFollowDTO) {
        DroneDTO response = droneService.updateTarget(id, droneFollowDTO);
        return ResponseEntity.ok(response);
    }

}
