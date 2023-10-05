package kibera.dron_project.repository;

import kibera.dron_project.domain.TrackerData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TrackerDataRepository extends JpaRepository<TrackerData, Long> {


    @Query(value = "SELECT td FROM TrackerData td")
    List<TrackerData> getAllData();

}
