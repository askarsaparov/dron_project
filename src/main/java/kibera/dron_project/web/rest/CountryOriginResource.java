package kibera.dron_project.web.rest;

import kibera.dron_project.dto.CountryOriginDTO;
import kibera.dron_project.dto.PostionDTO;
import kibera.dron_project.service.CountryOriginService;
import kibera.dron_project.service.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class CountryOriginResource {
    private final CountryOriginService countryOriginService;

    @GetMapping("/country-origin")
    public ResponseEntity<List<CountryOriginDTO>> getAll() {
        List<CountryOriginDTO> countryOriginDTO =  countryOriginService.getAllCountryOrigin();
        return ResponseEntity.ok(countryOriginDTO);
    }

    @PostMapping("/country-origin")
    public ResponseEntity<CountryOriginDTO> create(@RequestBody CountryOriginDTO countryOriginDTO) {
        return ResponseEntity.ok(
                countryOriginService.createCountryOrigin(countryOriginDTO)
        );
    }

    @GetMapping("/country-origin/{id}")
    public ResponseEntity<CountryOriginDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(countryOriginService.findById(id));
    }

    @PutMapping("/country-origin")
    public ResponseEntity<CountryOriginDTO> update(@RequestBody CountryOriginDTO countryOriginDTO) {
        return ResponseEntity.ok(
                countryOriginService.updateCountryOrigin(countryOriginDTO)
        );
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/country-origin/{id}")
    public void delete(@PathVariable Long id) {
        countryOriginService.delete(id);
    }
}
