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
public class CourseView {

    private int courseId;

    private String courseName;

    private int units;

    private String courseSubject;

}
