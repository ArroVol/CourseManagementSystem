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
@Table(name = "instructor_has_section")
public class InstructorHasSection {
    @Id
    @NotNull
    @Column(name = "instructor_has_section_id")
    private int instructorHasSectionId;

    @NotNull
    @Column(name = "instructor_instructor_id")
    private int instructorInstructorId;

    @NotNull
    @Column(name = "section_section_no_id")
    private int sectionSectionId;
}
