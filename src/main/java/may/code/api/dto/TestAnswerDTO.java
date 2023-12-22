package may.code.api.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TestAnswerDTO {

    LiteTestDTO test;

    List<TestedUserAnswerDTO> answers;

    List<PersonAnalyzeDTO> personAnalyzes;

    TestedUserDTO user;

}
