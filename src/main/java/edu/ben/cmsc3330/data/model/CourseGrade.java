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
    @Column(name = "course_id")
    private String courseId;

    @NotNull
    @Column(name = "student_id")
    private String studentId;

    @Column(name = "grade_received")
    private String gradeReceived;
}
