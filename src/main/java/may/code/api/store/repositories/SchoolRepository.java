package may.code.api.store.repositories;

import may.code.api.store.entities.SchoolEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<SchoolEntity, Integer> {
}
