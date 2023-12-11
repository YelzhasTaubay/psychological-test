package may.code.api.store.repositories;

import may.code.api.store.entities.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestPeopleRepository extends JpaRepository<TestPeopleRepository, Long> {
}
