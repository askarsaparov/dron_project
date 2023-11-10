package kibera.dron_project.repository;

import kibera.dron_project.domain.Sensor;
import kibera.dron_project.dto.ObjDroneSensorDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long> {
    @Modifying
    @Transactional
    @Query("update Sensor o set o.sensorType = null where o.sensorType.id = :sensorId")
    void setNullWhichHasDeletedSensorType(Long sensorId);

    @Modifying
    @Transactional
    @Query(value="SELECT * FROM sensor WHERE type_host = 'DRONE' AND host_id = :droneId", nativeQuery = true)
    List<Sensor> filterDrone(Long droneId);

    @Modifying
    @Transactional
    @Query(value="SELECT * FROM sensor WHERE type_host = 'OBJECT' AND host_id = :objectId", nativeQuery = true)
    List<Sensor> filterObject(Long objectId);

    @Modifying
    @Transactional
    @Query(value="SELECT * FROM sensor WHERE type_host IS NULL OR host_id IS NULL", nativeQuery = true)
    List<Sensor> filterUnused();

    @Modifying
    @Transactional
    @Query("""
            SELECT new kibera.dron_project.dto.ObjDroneSensorDTO(u.id, u.name, 'SENSOR')
             FROM Sensor u WHERE u.name ILIKE %:keyword% OR u.sensorId ILIKE %:keyword%
            """)
    List<ObjDroneSensorDTO> searchDashboardNameCode(String keyword);

    @Modifying
    @Transactional
    @Query("""
            SELECT new kibera.dron_project.dto.ObjDroneSensorDTO(u.id, u.name, 'SENSOR')
             FROM Sensor u WHERE u.name ILIKE %:keyword%
            """)
    List<ObjDroneSensorDTO> searchDashboardName(String keyword);

    @Modifying
    @Transactional
    @Query("""
            SELECT new kibera.dron_project.dto.ObjDroneSensorDTO(u.id, u.name, 'SENSOR')
             FROM Sensor u WHERE u.sensorId ILIKE %:keyword%
            """)
    List<ObjDroneSensorDTO> searchDashboardCode(String keyword);
}