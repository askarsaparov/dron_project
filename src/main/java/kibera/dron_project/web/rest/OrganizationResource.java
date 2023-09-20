package kibera.dron_project.web.rest;
import kibera.dron_project.domain.Employee;
import kibera.dron_project.domain.Organization;
import kibera.dron_project.service.OrganizationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class OrganizationResource {
    private final OrganizationService organizationService;

    public OrganizationResource(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping("/organization")
    public ResponseEntity getAll() {
        List<Organization> organizationList =  organizationService.findAll();
        return ResponseEntity.ok(organizationList);
    }

    @PostMapping("/organization")
    public ResponseEntity create(@RequestBody Organization organization) {
        Organization organization1 =  organizationService.save(organization);
        return ResponseEntity.ok(organization);
    }

    @GetMapping("/organization/{id}") // This maps to a GET request with a path parameter {id}
    public ResponseEntity<Organization> getById(@PathVariable Long id) {
        Organization organization = organizationService.findById(id);

        if (organization != null) {
            return ResponseEntity.ok(organization); // Return 200 OK with the resource
        } else {
            return ResponseEntity.notFound().build(); // Return 404 Not Found if the resource doesn't exist
        }
    }

    @PutMapping("/organization")
    public ResponseEntity update( @RequestBody Organization organization) {
//        if (organization.getId() == null) {
//            return ResponseEntity.badRequest().build();
//        }

        Organization organization1 = organizationService.save(organization);
        if (organization != null) {
            return ResponseEntity.ok(organization);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/organization/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        organizationService.delete(id);
        return ResponseEntity.ok("Qator o'chirildi");
    }

//    @GetMapping("/organization/{name}")
//    public ResponseEntity<?> getAll(@PathVariable String name) {
//        List<Organization> organizationList =  organizationService.findByName(name);
//        return ResponseEntity.ok(organizationList);
//    }

//    @GetMapping("/organization/search")
//    public ResponseEntity<?> getAllSearch(@RequestParam String name) {
//        List<Organization> organizationList =  organizationService.findAllByParam(name);
//        return ResponseEntity.ok(organizationList);
//    }
}
