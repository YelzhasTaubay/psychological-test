package may.code.api.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import may.code.api.domains.UserRole;
import may.code.api.dto.AckDTO;
import may.code.api.dto.UserDTO;
import may.code.api.exceptions.BadRequestException;
import may.code.api.exceptions.NotFoundException;
import may.code.api.factory.UserDTOFactory;
import may.code.api.store.entities.SchoolClassEntity;
import may.code.api.store.entities.UserEntity;
import may.code.api.store.repositories.SchoolClassRepository;
import may.code.api.store.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Controller
@Transactional
public class UserController {

    UserRepository userRepository;
    SchoolClassRepository schoolClassRepository;
    UserDTOFactory userDTOFactory;

    public static final String FETCH_USERS = "/api/schools/classes/users";
    public static final String CREATE_USER = "/api/schools/classes/{classId}/users";
    public static final String DELETE_USER = "/api/schools/classes/users/{userId}";

    @GetMapping(FETCH_USERS)


    @PostMapping(CREATE_USER)
    public ResponseEntity<UserDTO> createUsers(
            @RequestParam Instant birthday,
            @RequestParam String fullName,
            @RequestParam UserRole userRole,
            @PathVariable Long classId
    ) {

        SchoolClassEntity schoolClass = schoolClassRepository
                .findById(classId)
                .orElseThrow(() ->
                        new NotFoundException(String.format("Школа с названием \"%s\" не найдена. ", classId)));

        UserEntity user = userRepository.saveAndFlush(
                UserEntity.makeDefault(fullName, birthday, userRole, schoolClass)
        );

        return ResponseEntity.ok(userDTOFactory.createUserDTO(user));
    }


    @DeleteMapping(DELETE_USER)
    public ResponseEntity<AckDTO> deleteUser(@PathVariable Long userId) {

        if (userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
        }

        return ResponseEntity.ok(AckDTO.makeDefault(true));
    }

}
