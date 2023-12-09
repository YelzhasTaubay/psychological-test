package may.code.api.store.repositories;

import lombok.NonNull;
import may.code.api.store.entities.SchoolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SchoolRepository extends JpaRepository<SchoolEntity, Long> {

    Boolean existsByName(@NonNull String name);

    @Query("select s from SchoolEntity s " +
            "where :isFiltered = false " +
            "or lower(s.name) like lower(concat('%', :filter, '%')) " +
            "order by s.name desc")
    List<SchoolEntity> findAllByFilter(boolean isFiltered, String filter);

}
