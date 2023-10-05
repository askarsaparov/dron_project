package kibera.dron_project.web.rest;

import kibera.dron_project.dto.TrackerDataDTO;
import kibera.dron_project.service.TrackerDataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class TrackerDataResource {
    private final TrackerDataService trackerDataService;

    @GetMapping("/tracker-data")
    public ResponseEntity<List<TrackerDataDTO>> getAll() {
        return ResponseEntity.ok(trackerDataService.getAllData());
    }
}
