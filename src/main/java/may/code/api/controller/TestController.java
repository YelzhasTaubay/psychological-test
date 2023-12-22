package may.code.api.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import may.code.api.store.repositories.TestAnswerRepository;
import may.code.api.store.repositories.TestRepository;
import may.code.api.store.repositories.TestedUserRepository;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@RestController
@Transactional
public class TestController {

    TestRepository testRepository;
    TestedUserRepository testedUserRepository;

    TestAnswerRepository testAnswerRepository;

}
