package edu.ben.cmsc3330.web.model;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class StudentView {

    private String studentFirstName;

    private String studentLastName;

    private String studentMiddleName;

    private String ssn;

    private String dob;

    private String studentEmail;
}
