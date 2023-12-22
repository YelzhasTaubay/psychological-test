package may.code.api.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import may.code.api.exceptions.NotFoundException;
import may.code.api.store.entities.PsychologistEntity;
import may.code.api.store.entities.TokenEntity;
import may.code.api.store.repositories.PsychologistRepository;
import may.code.api.store.repositories.TokenRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Controller
@Transactional
public class AuthorizationController {

    TokenRepository tokenRepository;
    PsychologistRepository psychologistRepository;

    public static final String AUTHORIZE = "/api/psychologist/authorize";

    @GetMapping(AUTHORIZE)
    public ResponseEntity<String> authorize(
            @RequestParam String login,
            @RequestParam String password
    ){

        PsychologistEntity psychologist = psychologistRepository
                .findTopByLoginAndPassword(login, password)
                .orElseThrow(() -> new NotFoundException("Пользователь с таким логином и паролем не найден"));

        TokenEntity tokenEntity = tokenRepository
                .findByPsychologisId(psychologist.getId())
                .orElseGet(() ->
                        TokenEntity.builder()
                                .psychologis(psychologist)
                                .build());

        tokenEntity.updateExpiredAt();

        tokenEntity = tokenRepository.saveAndFlush(tokenEntity);

        return ResponseEntity.ok(tokenEntity.getToken());
    };



}
