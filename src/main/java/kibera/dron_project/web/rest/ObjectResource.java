package kibera.dron_project.web.rest;

import kibera.dron_project.domain.Object;
import kibera.dron_project.dto.ObjectDTO;
import kibera.dron_project.dto.ObjectSaveDTO;
import kibera.dron_project.service.ObjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class ObjectResource {
    private final ObjectService objectService;

    @GetMapping("/object")
    public ResponseEntity<List<ObjectDTO>> getAll() {
        List<ObjectDTO> objectDTO =  objectService.getAllObject();
        return ResponseEntity.ok(objectDTO);
    }

    @PostMapping("/object")
    public ResponseEntity<ObjectSaveDTO> create(@RequestBody ObjectSaveDTO objectSaveDTO) {
        return ResponseEntity.ok(
                objectService.createObject(objectSaveDTO)
        );
    }

    @GetMapping("/object/{id}") // This maps to a GET request with a path parameter {id}
    public ResponseEntity<ObjectDTO> getById(@PathVariable Long id) {
        ObjectDTO object = objectService.findById(id);

        if (object != null) {
            return ResponseEntity.ok(object); // Return 200 OK with the resource
        } else {
            return ResponseEntity.notFound().build(); // Return 404 Not Found if the resource doesn't exist
        }
    }

    @PutMapping("/object")
    public ResponseEntity<ObjectSaveDTO> update(@RequestBody ObjectSaveDTO objectDTO) {
        return ResponseEntity.ok(
                objectService.updateObject(objectDTO)
        );
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/object/{id}")
    public void delete(@PathVariable Long id) {
        objectService.delete(id);
    }

    @GetMapping("/object/search")
    public List<Object> searchObject(@RequestParam String name) {
        return objectService.searchObject(name);
    }

}
