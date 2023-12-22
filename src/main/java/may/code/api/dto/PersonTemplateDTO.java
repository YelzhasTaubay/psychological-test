package may.code.api.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import may.code.api.domains.UserShouldAnswer;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PersonTemplateDTO {

    Integer id;

    String text;

    List<UserShouldAnswerDTO> userShouldAnswers;
}
