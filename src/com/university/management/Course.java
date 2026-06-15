package com.university.management;

import java.util.logging.Logger;

public class Course {

    private static final Logger LOGGER = Logger.getLogger(Course.class.getName());

    protected String courseCode;
    protected String courseName;

    public Course(String courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
    }

    public void displayCourse() {
        LOGGER.info("Course code: " + courseCode);
        LOGGER.info("Course Name: " + courseName);
    }
}