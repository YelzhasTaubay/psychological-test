package may.code.api.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import may.code.api.dto.AckDTO;
import may.code.api.dto.SchoolDTO;
import may.code.api.exceptions.BadRequestException;
import may.code.api.factory.SchoolDTOFactory;
import may.code.api.store.entities.SchoolEntity;
import may.code.api.store.repositories.SchoolRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Controller
@Transactional
public class SchoolController {

    SchoolRepository schoolRepository;
    SchoolDTOFactory schoolDTOFactory;

    public static final String FETCH_SCHOOLS = "/api/schools";
    public static final String CREATE_SCHOOLS = "/api/schools/{schoolName}";
    public static final String DELETE_SCHOOLS = "/api/schools/{schoolId}";


    @GetMapping(FETCH_SCHOOLS)
    public ResponseEntity<List<SchoolDTO>> fetchSchool(@RequestParam String filter) {

        boolean isFiltered = !filter.trim().isEmpty();

        List<SchoolEntity> schools = schoolRepository.findAllByFilter(isFiltered, filter);

        return ResponseEntity.ok(schoolDTOFactory.createSchoolDTOList(schools));
    }

    @PostMapping(CREATE_SCHOOLS)
    public ResponseEntity<SchoolDTO> createSchool(@PathVariable String schoolName){

        if (schoolRepository.existsByName(schoolName)){
            throw new BadRequestException(String.format("Школа с названием \"%s\" уже существует", schoolName));
        }

        SchoolEntity schoolEntity = schoolRepository.saveAndFlush(
                SchoolEntity.makeDefault(schoolName)
        );

        return ResponseEntity.ok(schoolDTOFactory.createSchoolDTO(schoolEntity));
    }

    @DeleteMapping(DELETE_SCHOOLS)
    public ResponseEntity<AckDTO> deleteSchool(@PathVariable Long schoolId) {

        if (schoolRepository.existsById(schoolId)){
            schoolRepository.deleteById(schoolId);
        }

        return ResponseEntity.ok(AckDTO.makeDefault(true));
    }







}



























