package may.code.api.store.repositories;

import may.code.api.store.entities.TestedUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestedUserRepository extends JpaRepository<TestedUserEntity, Integer> {
}
