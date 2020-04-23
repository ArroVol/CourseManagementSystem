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
@Table(name = "course_grade")
public class CourseGrade{

    @Id
    @NotNull
    @Column(name = "course_grade_id")
    private int courseGradeId;

//    @NotNull
//    @Column(name = "registration_id")
//    private String registrationId;

    @NotNull
    @Column(name = "section_no")
    private int sectionNo;

    @NotNull
    @Column(name = "student_id")
    private int studentId;

    @Column(name = "grade_received")
    private String gradeReceived;
}
