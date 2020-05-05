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
public class SectionView {
    private int sectionNo;

    private String semester;

    private int courseId;

    private boolean status;

    private String roomNo;

    private String dayAndTime;

    private String courseName;

    private String courseSubject;
}
