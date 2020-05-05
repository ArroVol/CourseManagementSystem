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
public class InstructorView {

    private String instructorId;

    private String firstName;

    private String lastName;

    private String middleName;

    private String instructorEmail;
}
