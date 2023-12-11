package may.code.api.store.repositories;

import may.code.api.store.entities.PsychologistEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PsychologistRepository extends JpaRepository<PsychologistEntity, Long> {
}
