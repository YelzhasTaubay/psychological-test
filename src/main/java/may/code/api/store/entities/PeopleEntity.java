package may.code.api.store.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import may.code.api.domains.PeopleRole;

import javax.persistence.*;
import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "people")
public class PeopleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @NonNull
    String fio;

    @NonNull
    Instant birthday;

    @NonNull
    @Enumerated(EnumType.STRING)
    PeopleRole role;

    @NonNull
    @ManyToOne
    SchoolClassEntity schoolClass;



}
