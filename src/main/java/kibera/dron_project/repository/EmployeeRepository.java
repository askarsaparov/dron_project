package kibera.dron_project.repository;

import kibera.dron_project.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee , Long> {

//    @Query("update ")
    void setNullWhichHasDeletedOrganization(Long id);
}
