package edu.ben.cmsc3330.data.translator;

import edu.ben.cmsc3330.data.model.Section;
import edu.ben.cmsc3330.web.model.SectionView;

public class SectionTranslator {

    public static SectionView entityToView(final Section section) {
        return SectionView.builder()
                .sectionNo(section.getSectionNo())
                .semester(section.getSemester())
                .courseId(section.getCourseId())
                .status(section.isStatus())
                .roomNo(section.getRoomNo())
                .dayAndTime(section.getDayAndTime())
                .courseName(section.getCourseName())
                .courseSubject(section.getCourseSubject())
                .build();
    }
}
