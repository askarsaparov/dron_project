package kibera.dron_project.web.rest;

import kibera.dron_project.domain.Drone;
import kibera.dron_project.domain.TrackerData;
import kibera.dron_project.dto.TrackerDataDTO;
import kibera.dron_project.enums.Condition;
import kibera.dron_project.service.TrackerDataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class TrackerDataResource {
    private final TrackerDataService trackerDataService;

    @GetMapping("/tracker-data")
    public ResponseEntity<List<TrackerData>> getAll() {
        return ResponseEntity.ok(trackerDataService.getAllData());
    }

    @GetMapping("/tracker-data/filter")
    public List<TrackerData> filterDrone(@RequestParam(required = true) String droneId, @RequestParam(required = true) LocalDateTime startTimestamp, @RequestParam(required = true) LocalDateTime endTimestamp) {
        return trackerDataService.filterDroneId(droneId, startTimestamp, endTimestamp);
    }
}
