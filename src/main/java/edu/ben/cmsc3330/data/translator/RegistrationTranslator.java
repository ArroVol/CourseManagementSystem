package edu.ben.cmsc3330.data.translator;

import edu.ben.cmsc3330.data.model.Registration;
import edu.ben.cmsc3330.web.model.RegistrationView;

/**
 * Translator for Registration
 */
public class RegistrationTranslator {

    /**
     * Registration View Builder
     * @param registration Registration
     * @return Registration View
     */
    public static RegistrationView entityToView(final Registration registration) {
        return RegistrationView.builder()
                .registrationId(registration.getRegistrationId())
                .studentId(registration.getStudentId())
                .sectionNo(registration.getSectionNo())
                .semester(registration.getSemester())
                .courseName(registration.getCourseName())
                .build();
    }
}
