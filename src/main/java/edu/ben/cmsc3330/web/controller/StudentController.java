package edu.ben.cmsc3330.web.controller;

import edu.ben.cmsc3330.data.model.Student;
import edu.ben.cmsc3330.data.repository.StudentRepository;
import edu.ben.cmsc3330.data.translator.StudentTranslator;
import edu.ben.cmsc3330.web.model.StudentView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
import java.util.Optional;

@RequestMapping("/model/address")
@CrossOrigin
@Slf4j
@RestController
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @GetMapping(value = "/api/student/{id}")
    public StudentView viewStudent(@PathVariable Long studentId) throws Exception {

        // Retrieve the Address object
        Optional<Student> studentOption = studentRepository.findById(studentId);

        // Verify we actually got a good address/address id
        if (studentOption.isEmpty()) {
            log.error("Address with id [{}] does not exist in DB", studentId);
            throw new Exception("Address with id [" + studentId + "] does not exist in DB");
        }

        return StudentTranslator.entityToView(studentOption.get());

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        this.studentRepository.deleteById(Long.valueOf(id));
    }
}

