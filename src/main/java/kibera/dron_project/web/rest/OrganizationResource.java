package kibera.dron_project.web.rest;
import jakarta.validation.Valid;
import kibera.dron_project.domain.Organization;
import kibera.dron_project.dto.ObjectDTO;
import kibera.dron_project.dto.ObjectSaveDTO;
import kibera.dron_project.dto.OrganizationDTO;
import kibera.dron_project.dto.OrganizationSaveDTO;
import kibera.dron_project.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class OrganizationResource {
    private final OrganizationService organizationService;

    @GetMapping("/organization")
    public ResponseEntity<List<OrganizationDTO>> getAll() {
        List<OrganizationDTO> organizationDTO =  organizationService.getAllOrganization();
        return ResponseEntity.ok(organizationDTO);
    }

    @PostMapping("/organization")
    public ResponseEntity<OrganizationSaveDTO> create(@RequestBody @Valid OrganizationSaveDTO organizationSaveDTO) {
        return ResponseEntity.ok(
                organizationService.createOrganization(organizationSaveDTO)
        );
    }

    @GetMapping("/organization/{id}") // This maps to a GET request with a path parameter {id}
    public ResponseEntity<OrganizationDTO> getById(@PathVariable Long id) {
        OrganizationDTO organization = organizationService.findById(id);

        if (organization != null) {
            return ResponseEntity.ok(organization); // Return 200 OK with the resource
        } else {
            return ResponseEntity.notFound().build(); // Return 404 Not Found if the resource doesn't exist
        }
    }

    @PutMapping("/organization")
    public ResponseEntity<OrganizationSaveDTO> update(@RequestBody OrganizationSaveDTO organizationSaveDTO) {
        return ResponseEntity.ok(
                organizationService.updateOrganization(organizationSaveDTO)
        );
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/organization/{id}")
    public void delete(@PathVariable Long id) {
        organizationService.delete(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/organization/multidelete")
    public void deleteItems(@RequestBody List<Long> ids) {
        organizationService.deleteItems(ids);
    }

}
