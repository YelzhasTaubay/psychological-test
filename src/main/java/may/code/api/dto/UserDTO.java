package may.code.api.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import may.code.api.domains.UserRole;

import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDTO {

    @NonNull
    Long id;

    @NonNull
    String fullName;

    @NonNull
    Instant birthday;

    @NonNull
    UserRole role;

    @NonNull
    Long schoolClassId;

}
