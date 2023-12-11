package may.code.api.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SchoolClassDTO {

    @NonNull
    Long id;

    @NonNull
    String name;

    @NonNull
    SchoolDTO school;
}
