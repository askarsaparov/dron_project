package kibera.dron_project.repository;

import kibera.dron_project.domain.Drone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DroneRepository extends JpaRepository<Drone, Long> {
    @Modifying
    @Query("UPDATE Drone d SET d.owner = null WHERE d.owner.id = :organizationId")
    void setNullWhichHasDeletedOrganization(@Param("organizationId") Long organizationId);

    @Modifying
    @Query("UPDATE Drone d SET d.operator = null WHERE d.operator.id = :operatorId")
    void setNullWhichHasDeletedEmployee(@Param("operatorId") Long id);

}
