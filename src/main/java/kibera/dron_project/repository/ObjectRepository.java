package kibera.dron_project.repository;

import kibera.dron_project.domain.Object;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ObjectRepository extends JpaRepository<Object, Long> {
    @Modifying
    @Query("UPDATE Object e SET e.category = null WHERE e.category.id = :categoryId")
    void setNullWhichHasDeletedCategory(@Param("categoryId") Long categoryId);

    @Query("SELECT u FROM Object u WHERE u.name LIKE %:keyword%")
    List<Object> searchObject(String keyword);
}
