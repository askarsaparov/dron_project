package kibera.dron_project.repository;

import kibera.dron_project.domain.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

    @Modifying
    @Transactional
    @Query("update Organization o set o.district = null where o.district.id = :districtId")
    void setNullWhichHasDeletedDistrict(@Param("districtId") Long id);

    @Modifying
    @Transactional
    @Query("update Organization o set o.region = null where o.region.id = :regionId")
    void setNullWhichHasDeletedRegion(@Param("regionId") Long id);

}
