package kibera.dron_project.repository;

import kibera.dron_project.domain.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistrictRepository extends JpaRepository<District, Long> {

    @Query("select d from District d")
    List<District> getAll();

}
