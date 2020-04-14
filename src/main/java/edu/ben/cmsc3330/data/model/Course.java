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
@Table(name = "course")
public class Course{

    @Id
    @NotNull
    @Column(name = "course_id")
    private String courseId;

    @NotNull
    @Column(name = "course_name")
    private String courseName;

    @NotNull
    @Column(name = "units")
    private String units;

    @NotNull
    @Column(name = "course_subject")
    private String courseSubject;
}