package kibera.dron_project.web.rest;

import kibera.dron_project.dto.ManufacturerDTO;
import kibera.dron_project.dto.PostionDTO;
import kibera.dron_project.service.ManufacturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class ManufacturerResource {

    private final ManufacturerService manufacturerService;

    @GetMapping("/manufacturer")
    public ResponseEntity<List<ManufacturerDTO>> getAll() {
        List<ManufacturerDTO> manufacturerDTO =  manufacturerService.getAllManufacturer();
        return ResponseEntity.ok(manufacturerDTO);
    }

    @PostMapping("/manufacturer")
    public ResponseEntity<ManufacturerDTO> create(@RequestBody ManufacturerDTO manufacturerDTO) {
        return ResponseEntity.ok(
                manufacturerService.createManufacturer(manufacturerDTO)
        );
    }

    @GetMapping("/manufacturer/{id}")
    public ResponseEntity<ManufacturerDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(manufacturerService.findById(id));
    }

    @PutMapping("/manufacturer")
    public ResponseEntity<ManufacturerDTO> update(@RequestBody ManufacturerDTO manufacturerDTO) {
        return ResponseEntity.ok(
                manufacturerService.updateManufacturer(manufacturerDTO)
        );
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/manufacturer/{id}")
    public void delete(@PathVariable Long id) {
        manufacturerService.delete(id);
    }
}
