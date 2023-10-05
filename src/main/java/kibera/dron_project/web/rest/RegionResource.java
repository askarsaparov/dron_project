package kibera.dron_project.web.rest;

import kibera.dron_project.dto.DroneDTO;
import kibera.dron_project.dto.DroneSaveDTO;
import kibera.dron_project.dto.RegionDTO;
import kibera.dron_project.service.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class RegionResource {
    private final RegionService regionService;

    @GetMapping("/region")
    public ResponseEntity<?> getAll() {
        List<RegionDTO> regionList =  regionService.getAllRegion();
        return ResponseEntity.ok(regionList);
    }

    @PostMapping("/region")
    public ResponseEntity<?> create(@RequestBody RegionDTO regionDTO) {
        return ResponseEntity.ok(
                regionService.createRegion(regionDTO)
        );
    }

    @GetMapping("/region/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        RegionDTO region = regionService.findById(id);

        if (region != null) {
            return ResponseEntity.ok(region);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/region")
    public ResponseEntity<?> update(@RequestBody RegionDTO regionDTO) {
        return ResponseEntity.ok(
                regionService.updateRegion(regionDTO)
        );
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/region/{id}")
    public void delete(@PathVariable Long id) {
        regionService.delete(id);
    }
}
