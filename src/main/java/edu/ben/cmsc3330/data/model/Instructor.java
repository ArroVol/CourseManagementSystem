package edu.ben.cmsc3330.data.model;

import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "instructor")
public class Instructor {

    @Id
    @NotNull
    @Column(name = "instructor_id")
    private int instructorId;

    @NotNull
    @Column(name = "instructor_first_name")
    private String firstName;

    @NotNull
    @Column(name = "instructor_last_name")
    private String lastName;

    @Column(name = "instructor_middle_name")
    private String middleName;

    @Column(name = "instructor_email")
    private String instructorEmail;

}
