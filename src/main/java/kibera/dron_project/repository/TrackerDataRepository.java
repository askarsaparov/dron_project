package kibera.dron_project.repository;

import kibera.dron_project.domain.TrackerData;
import kibera.dron_project.dto.TrackerDataDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;

public interface TrackerDataRepository extends JpaRepository<TrackerData, Long> {


    @Query(value = "SELECT * FROM tracker_data td ORDER BY td.timestamp", nativeQuery = true)
    List<TrackerData> getAllData();

    @Query(value = """
            SELECT td\s
            FROM TrackerData td\s
            WHERE td.drone_id = :droneId\s
              AND td.timestamp\s
                  BETWEEN :startTimestamp\s
                  AND :endTimestamp
            ORDER BY td.timestamp""")
    List<TrackerData> filterDroneId(@Param("droneId") String droneId, @Param("startTimestamp") Timestamp startTimestamp, @Param("endTimestamp") Timestamp endTimestamp);
}
