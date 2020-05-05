package edu.ben.cmsc3330.data.model;

import com.sun.istack.NotNull;
import lombok.*;
import org.w3c.dom.html.HTMLImageElement;

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
@Table(name = "section")
public class Section {

    @Id
    @NotNull
    @Column(name = "section_no")
    private int sectionNo;

    @NotNull
    @Column(name = "semester")
    private String semester;

    @NotNull
    @Column(name = "course_id")
    private int courseId;

    @Column(name = "status")
    private boolean status;

    @Column(name = "room_no")
    private String roomNo;

    @Column(name = "day_and_time")
    private String dayAndTime;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "course_subject")
    private String courseSubject;


}
