package kibera.dron_project.repository;

import kibera.dron_project.domain.TrackerData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TrackerDataRepository extends JpaRepository<TrackerData, Long> {


    @Query(value = "SELECT * FROM tracker_data td WHERE (SELECT target FROM drone d WHERE d.drone_id = td.drone_id) = true ORDER BY td.timestamp asc", nativeQuery = true)
    List<TrackerData> getAllData();
}
