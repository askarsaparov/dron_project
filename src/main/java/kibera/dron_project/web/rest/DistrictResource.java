package kibera.dron_project.web.rest;

import jakarta.validation.Valid;
import kibera.dron_project.domain.Category;
import kibera.dron_project.domain.District;
import kibera.dron_project.dto.DistrictDTO;
import kibera.dron_project.dto.DistrictSaveDTO;
import kibera.dron_project.dto.EmployeeDTO;
import kibera.dron_project.dto.EmployeeSaveDTO;
import kibera.dron_project.service.DistrictService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class DistrictResource {
    private final DistrictService districtService;

    public DistrictResource(DistrictService districtService) {
        this.districtService = districtService;
    }

    @GetMapping("/district")
    public ResponseEntity<?> getAll() {
        List<DistrictDTO> districtList =  districtService.getAllDistrict();
        return ResponseEntity.ok(districtList);
    }

    @PostMapping("/district")
    public ResponseEntity<DistrictSaveDTO> create(@RequestBody @Valid DistrictSaveDTO districtSaveDTO) {
        return ResponseEntity.ok(
                districtService.createDistrict(districtSaveDTO)
        );
    }

    @GetMapping("/district/{id}") // This maps to a GET request with a path parameter {id}
    public ResponseEntity<?> getById(@PathVariable Long id) {
        DistrictDTO districtDTO = districtService.findById(id);

        if (districtDTO != null) {
            return ResponseEntity.ok(districtDTO); // Return 200 OK with the resource
        } else {
            return ResponseEntity.notFound().build(); // Return 404 Not Found if the resource doesn't exist
        }
    }

    @PutMapping("/district")
    public ResponseEntity<DistrictSaveDTO> update(@RequestBody DistrictSaveDTO districtSaveDTO) {
        return ResponseEntity.ok(
                districtService.updateDistrict(districtSaveDTO)
        );
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/district/{id}")
    public void delete(@PathVariable Long id) {
        districtService.delete(id);
    }

    @GetMapping("/district/filter")
    public List<District> filterDistrict(@RequestParam(required = false) Long region_id) {
        return districtService.filterDistrict(region_id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/district/multidelete")
    public void deleteItems(@RequestBody List<Long> ids) {
        districtService.deleteItems(ids);
    }
}
