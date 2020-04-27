package edu.ben.cmsc3330.data.translator;

import edu.ben.cmsc3330.data.model.Course;
import edu.ben.cmsc3330.web.model.CourseView;

public class CourseTranslator {

    public static CourseView entityToView(final Course course) {
        return CourseView.builder()
                .courseId(course.getCourseId())
                .courseName(course.getCourseName())
                .units((course.getUnits()))
                .courseSubject(course.getCourseSubject())
                .build();
    }
}
