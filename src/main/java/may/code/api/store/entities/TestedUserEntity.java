package may.code.api.store.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import may.code.api.domains.TestedUserStatus;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tested_user")
public class TestedUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer id;

    @Column(length = 64)
    @NonNull
    String firstName;

    @Column(length = 64)
    @NonNull
    String lastName;

    @Column(length = 64)
    @NonNull
    String middleName;

    @NonNull
    String birthday;

    @Column(length = 64)
    @NonNull
    @Enumerated(EnumType.STRING)
    TestedUserStatus status;

    @Column(length = 128)
    @NonNull
    String login;

    @Builder.Default
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    List<TestAnswerEntity> testedUserAnswers = new ArrayList<>();

    @Column(length = 10)
    @NonNull
    String password;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "school_class_id", referencedColumnName = "id")
    SchoolClassEntity schoolClass;

    public static TestedUserEntity makeDefault(
            String firstName,
            String middleName,
            String lastName,
            String login,
            String password,
            String birthday,
            TestedUserStatus status,
            SchoolClassEntity schoolClass
    ){
        return builder()
                .firstName(firstName)
                .middleName(middleName)
                .lastName(lastName)
                .login(login)
                .password(password)
                .birthday(birthday)
                .status(status)
                .schoolClass(schoolClass)
                .build();
    }

}
