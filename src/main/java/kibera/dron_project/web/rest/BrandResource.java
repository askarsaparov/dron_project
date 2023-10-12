package kibera.dron_project.web.rest;

import kibera.dron_project.dto.BrandDTO;
import kibera.dron_project.dto.PostionDTO;
import kibera.dron_project.service.BrandService;
import kibera.dron_project.service.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class BrandResource {

    private final BrandService brandService;

    @GetMapping("/brand")
    public ResponseEntity<List<BrandDTO>> getAll() {
        List<BrandDTO> brandDTO =  brandService.getAllBrand();
        return ResponseEntity.ok(brandDTO);
    }

    @PostMapping("/brand")
    public ResponseEntity<BrandDTO> create(@RequestBody BrandDTO brandDTO) {
        return ResponseEntity.ok(
                brandService.createBrand(brandDTO)
        );
    }

    @GetMapping("/brand/{id}")
    public ResponseEntity<BrandDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(brandService.findById(id));
    }

    @PutMapping("/brand")
    public ResponseEntity<BrandDTO> update(@RequestBody BrandDTO brandDTO) {
        return ResponseEntity.ok(
                brandService.updateBrand(brandDTO)
        );
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/brand/{id}")
    public void delete(@PathVariable Long id) {
        brandService.delete(id);
    }
}
