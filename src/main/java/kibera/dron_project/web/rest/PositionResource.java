package kibera.dron_project.web.rest;

import kibera.dron_project.dto.PostionDTO;
import kibera.dron_project.service.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class PositionResource {

    private final PositionService positionService;

    @GetMapping("/position")
    public ResponseEntity<List<PostionDTO>> getAll() {
        List<PostionDTO> postionDTOList =  positionService.getAllPosition();
        return ResponseEntity.ok(postionDTOList);
    }

    @PostMapping("/position")
    public ResponseEntity<PostionDTO> create(@RequestBody PostionDTO postionDTO) {
        return ResponseEntity.ok(
                positionService.createPosition(postionDTO)
        );
    }

    @GetMapping("/position/{id}")
    public ResponseEntity<PostionDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(positionService.findById(id));
    }

    @PutMapping("/position")
    public ResponseEntity<PostionDTO> update(@RequestBody PostionDTO postionDTO) {
        return ResponseEntity.ok(
                positionService.updatePosition(postionDTO)
        );
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/position/{id}")
    public void delete(@PathVariable Long id) {
        positionService.delete(id);
    }

}
