package may.code.api.store.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "token")
public class TokenEntity {

    private static final int EXPIRED_SECONDS = 60 * 60; //One hour expiration time;

    @Id
    @Builder.Default
    String token = UUID.randomUUID().toString();

    @Builder.Default
    Instant expiredAt = Instant.now().plusSeconds(EXPIRED_SECONDS);

    @Builder.Default
    Instant createdAt = Instant.now();

    @ManyToOne
    @JoinColumn(name = "psychologist_id", referencedColumnName = "id")
    PsychologistEntity psychologis;

    public void updateExpiredAt(){
        this.expiredAt = Instant.now().plusSeconds(EXPIRED_SECONDS);
    }



}
