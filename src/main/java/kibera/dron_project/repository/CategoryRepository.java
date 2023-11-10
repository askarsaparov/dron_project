package kibera.dron_project.repository;

import kibera.dron_project.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query(value = "SELECT * FROM Category WHERE on_dashboard = :onDashboard", nativeQuery = true)
    List<Category> filterCategory(Boolean onDashboard);
}
