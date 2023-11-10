package kibera.dron_project.repository;

import kibera.dron_project.domain.Category;
import kibera.dron_project.domain.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface DistrictRepository extends JpaRepository<District, Long> {

    @Query("select d from District d")
    List<District> getAll();

    @Query(value = "SELECT * FROM District WHERE region_id = :id", nativeQuery = true)
    List<District> filterDistrict(Long id);

    @Modifying
    @Transactional
    @Query("update District o set o.region = null where o.region.id = :regionId")
    void setNullWhichHasDeletedRegion(@Param("regionId") Long id);

}
