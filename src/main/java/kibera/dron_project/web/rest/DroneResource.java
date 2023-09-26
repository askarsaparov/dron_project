package kibera.dron_project.web.rest;

import kibera.dron_project.dto.DroneDTO;
import kibera.dron_project.dto.DroneSaveDTO;
import kibera.dron_project.service.DroneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class DroneResource {
    private final DroneService droneService;

    @GetMapping("/drone")
    public ResponseEntity<?> getAll() {
        List<DroneDTO> droneList =  droneService.getAllDrone();
        return ResponseEntity.ok(droneList);
    }

    @PostMapping("/drone")
    public ResponseEntity<?> create(@RequestBody DroneSaveDTO droneDTO) {
        return ResponseEntity.ok(
                droneService.createDrone(droneDTO)
        );
    }

    @GetMapping("/drone/{id}") // This maps to a GET request with a path parameter {id}
    public ResponseEntity<?> getById(@PathVariable Long id) {
        DroneDTO drone = droneService.findById(id);

        if (drone != null) {
            return ResponseEntity.ok(drone); // Return 200 OK with the resource
        } else {
            return ResponseEntity.notFound().build(); // Return 404 Not Found if the resource doesn't exist
        }
    }

    @PutMapping("/drone")
    public ResponseEntity<?> update(@RequestBody DroneSaveDTO droneDTO) {
        return ResponseEntity.ok(
                droneService.updateDrone(droneDTO)
        );
    }

    @DeleteMapping("/drone/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        droneService.delete(id);
        return ResponseEntity.ok("Qator o'chirildi");
    }
}
