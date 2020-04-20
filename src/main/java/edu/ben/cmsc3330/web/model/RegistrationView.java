package edu.ben.cmsc3330.web.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Column;
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationView {
    private String registrationId;

    private String studentId;

    private String sectionNo;

    private String semester;

    private String courseName;

    private String dateOfRegistration;

    private String dateOfCompletion;
}
