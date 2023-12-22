package may.code.api.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PersonAnalyzeDTO {

    Integer personTemplateId;

    Integer testedUserAnswers;

    Integer totalAnswers;
}
