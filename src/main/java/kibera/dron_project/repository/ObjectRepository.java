package kibera.dron_project.repository;

import kibera.dron_project.domain.Object;
import kibera.dron_project.dto.ObjDroneSensorDTO;
import kibera.dron_project.enums.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ObjectRepository extends JpaRepository<Object, Long> {

    @Query("SELECT u FROM Object u WHERE u.name ILIKE %:keyword% AND u.category.id= :category")
    List<Object> searchObject(String keyword, Long category);

    @Query("SELECT u FROM Object u WHERE u.name ILIKE %:keyword%")
    List<Object> searchObject(String keyword);

    @Query(value = "SELECT * FROM Object WHERE category_id = :id", nativeQuery = true)
    List<Object> filterObject(Long id);

    @Modifying
    @Transactional
    @Query("update Object o set o.district = null where o.district.id = :districtId")
    void setNullWhichHasDeletedDistrict(@Param("districtId") Long id);

    @Modifying
    @Transactional
    @Query("update Object o set o.region = null where o.region.id = :regionId")
    void setNullWhichHasDeletedRegion(@Param("regionId") Long id);

    @Modifying
    @Transactional
    @Query("update Object o set o.category = null where o.category.id = :categoryId")
    void setNullWhichHasDeletedCategory(@Param("categoryId") Long id);

//    @Modifying
//    @Transactional
    @Query("""
            SELECT new kibera.dron_project.dto.ObjDroneSensorDTO(u.id, u.name, 'OBJECT')
             FROM Object u WHERE u.name ILIKE %:keyword%
            """)
    List<ObjDroneSensorDTO> searchObjectDashboard(@Param("keyword") String keyword);

}
