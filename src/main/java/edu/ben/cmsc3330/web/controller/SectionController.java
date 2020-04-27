package edu.ben.cmsc3330.web.controller;

import edu.ben.cmsc3330.data.model.Section;
import edu.ben.cmsc3330.data.repository.SectionRepository;
import edu.ben.cmsc3330.data.translator.SectionTranslator;
import edu.ben.cmsc3330.web.model.SectionView;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
public class SectionController {

    private final SectionRepository sectionRepository;

    public SectionController(final SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    //http://localhost:8080/api/section/1
    @GetMapping(value = "/api/section/{sectionId}")
    public SectionView viewSection(@PathVariable int sectionId) throws Exception {
        log.info("inside view section method , secitonId: " + sectionId);
        // Retrieve the Section object
        Optional<Section> sectionOption = sectionRepository.findBySectionNo(sectionId);

        // Verify we actually got a good section/section id
        if (sectionOption.isEmpty()) {
            log.error("Section with id [{}] does not exist in DB", sectionId);
            throw new Exception("Section with id [" + sectionId + "] does not exist in DB");
        }
        return SectionTranslator.entityToView(sectionOption.get());
    }

    // get all sections
    @GetMapping(value = "/api/section")
    public List<Section> getAllSections() {
        log.info("inside the get all users in the section controller class");
        return this.sectionRepository.findAll();
    }

    // get sections by term
    @GetMapping(value = "/api/section/term/{semester}")
    public List<Section> getSectionByTerm(@PathVariable String semester) throws Exception {
        log.info("inside getSectionByTerm in the section controller class " + semester);
        List<Section> sectionOption = sectionRepository.findBySemesterContainingOrderBySemester(semester);
        if (sectionOption.isEmpty()) {
            log.error("there are no classes during that semester [{}] does not exist in DB", semester);
            throw new Exception("Section with id [" + semester + "] does not exist in DB");
        }
        return sectionOption;
    }



//    @PostMapping
//    public Section createSection(@RequestBody Section section) {
//        return this.sectionRepository.save(section);
//    }

//    @PostMapping
//    public Section save(@RequestBody SectionView sectionView, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            throw new ValidationException();
//        }
//        Section newSection = new Section();
//        newSection.setStreet(sectionView.getStreet());
//        newSection.setCity(sectionView.getCity());
//        newSection.setState(sectionView.getState());
//        newSection.setPostalCode(sectionView.getPostalCode());
//        // save note instance to db
//        this.sectionRepository.save(newSection);
//
//        return newSection;
//    }
//
////    @DeleteMapping("/{id}")
////    public void delete(@PathVariable String id) {
////        this.sectionRepository.deleteById(Long.valueOf(id));
////    }
//
//    // delete user by id
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Section> deleteUser(@PathVariable("id") Long userId) {
//        Optional<Section> existingSection = this.sectionRepository.findById(userId);
//
////                .orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + userId));
//        this.sectionRepository.delete(existingSection.get());
//        return ResponseEntity.ok().build();
//    }
//
//    // update user
//    @PutMapping("/{id}")
//    public Section updateUser(@RequestBody Section section, @PathVariable ("id") long userId) {
//        Optional<Section> existingSection = this.sectionRepository.findById(userId);
////                .orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + userId));
//        existingSection.get().setCity(section.getCity());
//        return this.sectionRepository.save(existingSection.get());
//    }
}
