package may.code.api.store.repositories;

import may.code.api.store.entities.SchoolClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SchoolClassRepository extends JpaRepository<SchoolClassEntity, Long> {

    void deleteByIdAndSchoolId(Long schoolClassId, Long schoolId);

}
