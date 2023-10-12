package kibera.dron_project.repository;

import kibera.dron_project.domain.SensorType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorTypeRepository extends JpaRepository<SensorType, Long> {
}
