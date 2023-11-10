package kibera.dron_project.repository;

import kibera.dron_project.domain.Drone;
import kibera.dron_project.domain.Organization;
import kibera.dron_project.dto.ObjDroneSensorDTO;
import kibera.dron_project.enums.Condition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface DroneRepository extends JpaRepository<Drone, Long> {
    @Transactional
    @Modifying
    @Query("UPDATE Drone d SET d.owner = null WHERE d.owner.id = :organizationId")
    void setNullWhichHasDeletedOrganization(@Param("organizationId") Long organizationId);

    @Transactional
    @Modifying
    @Query("UPDATE Drone d SET d.operator = null WHERE d.operator.id = :operatorId")
    void setNullWhichHasDeletedEmployee(@Param("operatorId") Long id);

    @Query("select dr from Drone dr where dr.drone_id = :droneId")
    Drone getDroneByDroneId(@Param("droneId") String droneId);

    @Query("SELECT u FROM Drone u WHERE u.name LIKE %:keyword% or u.drone_id LIKE %:keyword%")
    List<Drone> searchDrone(String keyword);

    @Query("SELECT u FROM Drone u WHERE u.condition=:condition")
    List<Drone> filterDrone(Condition condition);

    @Query(value = "SELECT * FROM drone WHERE owner_id = :organizationId", nativeQuery = true)
    List<Drone> filterDroneOrganizationId(Long organizationId);

    @Query(value = "SELECT * FROM drone WHERE drone_id = :droneId", nativeQuery = true)
    List<Drone> filterDroneId(String droneId);

    @Query(value = "SELECT COUNT(*) FROM drone WHERE target = TRUE;", nativeQuery = true)
    Long countTargetDrones();

    @Modifying
    @Transactional
    @Query("update Drone o set o.brand = null where o.brand.id = :brandId")
    void setNullWhichHasDeletedBrand(@Param("brandId") Long id);

    @Transactional
    @Modifying
    @Query("UPDATE Drone d SET d.countryOrigin = null WHERE d.countryOrigin.id = :countryOriginId")
    void setNullWhichHasDeletedCountryOrigin(@Param("countryOriginId") Long id);

    @Transactional
    @Modifying
    @Query("UPDATE Drone d SET d.manufacturer = null WHERE d.manufacturer.id = :manufacturerId")
    void setNullWhichHasDeletedManufacturer(@Param("manufacturerId") Long id);

//    @Modifying
//    @Transactional
    @Query("""
            SELECT new kibera.dron_project.dto.ObjDroneSensorDTO(u.id, u.name, 'DRONE')
             FROM Drone u WHERE (u.name ILIKE %:keyword% OR u.drone_id ILIKE %:keyword%)
            """)
    List<ObjDroneSensorDTO> searchDashboardNameCode(@Param("keyword") String keyword);

//    @Modifying
//    @Transactional
    @Query("""
            SELECT new kibera.dron_project.dto.ObjDroneSensorDTO(u.id, u.name, 'DRONE')
             FROM Drone u WHERE u.name ILIKE %:keyword%
            """)
    List<ObjDroneSensorDTO> searchDashboardName(String keyword);

//    @Modifying
//    @Transactional
    @Query("""
            SELECT new kibera.dron_project.dto.ObjDroneSensorDTO(u.id, u.name, 'DRONE')
             FROM Drone u WHERE u.drone_id ILIKE %:keyword%
            """)
    List<ObjDroneSensorDTO> searchDashboardCode(String keyword);
}
