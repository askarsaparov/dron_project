package kibera.dron_project.repository;

import kibera.dron_project.domain.Drone;
import kibera.dron_project.domain.Organization;
import kibera.dron_project.enums.Condition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DroneRepository extends JpaRepository<Drone, Long> {
    @Modifying
    @Query("UPDATE Drone d SET d.owner = null WHERE d.owner.id = :organizationId")
    void setNullWhichHasDeletedOrganization(@Param("organizationId") Long organizationId);

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

}
