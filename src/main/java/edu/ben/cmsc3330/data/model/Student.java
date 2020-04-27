package edu.ben.cmsc3330.data.model;

import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "student")
public class Student {

    @Id
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name = "student_first_name")
    private String studentFirstName;

    @NotNull
    @Column(name = "student_last_name")
    private String studentLastName;

    @Column(name = "student_middle_name")
    private String studentMiddleName;

    @Column(name = "ssn")
    private String ssn;

    @Column(name = "dob")
    private String dob;

    @Column(name = "student_email")
    private String studentEmail;

}
