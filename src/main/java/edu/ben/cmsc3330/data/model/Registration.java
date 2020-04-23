package edu.ben.cmsc3330.data.model;

import com.sun.istack.NotNull;
import lombok.*;

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
@Table(name = "registration")
public class Registration {

    @Id
    @NotNull
    @Column(name = "registration_id")
    private int registrationId;

    @NotNull
    @Column(name = "student_id")
    private int studentId;

    @NotNull
    @Column(name = "section_no")
    private int sectionNo;

    @NotNull
    @Column(name = "semester")
    private String semester;

    @NotNull
    @Column(name = "course_name")
    private String courseName;

    @NotNull
    @Column(name = "date_of_registration")
    private String dateOfRegistration;

    @NotNull
    @Column(name = "date_of_completion")
    private String dateOfCompletion;

}

