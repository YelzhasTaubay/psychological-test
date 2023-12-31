package may.code.api.store.entities;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.*;
import lombok.experimental.FieldDefaults;
import may.code.api.domains.TestedUserAnswer;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sample_test")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class SampleTestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer id;

    @Builder.Default
    Integer testId = 2;

    @Builder.Default
    Integer personalId = 3;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb", length = 20000)
    List<TestedUserAnswer> testedUserAnswers;

}
