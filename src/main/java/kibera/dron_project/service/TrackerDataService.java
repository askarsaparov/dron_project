package kibera.dron_project.service;

import kibera.dron_project.domain.TrackerData;
import kibera.dron_project.repository.DroneRepository;
import kibera.dron_project.repository.TrackerDataRepository;
import lombok.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TrackerDataService {

    private final TrackerDataRepository trackerDataRepository;
    private final DroneRepository droneRepository;

    public List<TrackerData> getAllData() {
        return trackerDataRepository.getAllData();
    }

    public List<TrackerData> filterDroneId(String droneId, LocalDateTime startTimestamp, LocalDateTime endTimestamp) {
        return trackerDataRepository.filterDroneId(droneId, Timestamp.valueOf(startTimestamp), Timestamp.valueOf(endTimestamp));
    }
}
