package kibera.dron_project.repository;

import kibera.dron_project.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee , Long> {

    @Modifying
    @Query("UPDATE Employee e SET e.organization = null WHERE e.organization.id = :organizationId")
    void setNullWhichHasDeletedOrganization(@Param("organizationId") Long organizationId);

    @Modifying
    @Query("UPDATE Employee e SET e.position = null WHERE e.position.id = :positionId")
    void setNullWhichHasDeletedPosition(@Param("positionId") Long id);

}
