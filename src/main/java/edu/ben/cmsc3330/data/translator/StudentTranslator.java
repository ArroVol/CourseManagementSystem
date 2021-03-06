package edu.ben.cmsc3330.data.translator;

import edu.ben.cmsc3330.data.model.Address;
import edu.ben.cmsc3330.data.model.Student;
import edu.ben.cmsc3330.web.model.AddressView;
import edu.ben.cmsc3330.web.model.StudentView;

/**
 * Translator for Students
 */
public class StudentTranslator {

    /**
     * Student View Builder
     * @param student Student
     * @return Student View
     */
    public static StudentView entityToView(final Student student) {

        return StudentView.builder()
                .studentFirstName((student.getStudentFirstName()))
                .studentLastName(student.getStudentLastName())
//                .studentMiddleName(student.getStudentMiddleName())
//                .ssn(student.getSsn())
//                .dob(student.getDob())
                .studentEmail(student.getStudentEmail())
                .build();
    }

}
