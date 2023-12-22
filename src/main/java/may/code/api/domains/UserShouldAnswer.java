package may.code.api.domains;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class UserShouldAnswer implements Serializable {

    Integer question_id;

    Integer answer_id;

}
