package may.code.api.store.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "psychologist")
public class PsychologistEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;



}
