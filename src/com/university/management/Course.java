package com.university.management;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Course{
    private static final Logger logger = Logger.getLogger(Course.class.getName());
    protected String courseCode;
    protected String courseName;

    public Course(String courseCode, String courseName){
        this.courseCode = courseCode;
        this.courseName = courseName;
    }

    public void displayCourse(){
        logger.log(Level.INFO, "Course code: {0}", courseCode);
        logger.log(Level.INFO, "Course Name: {0}", courseName);
    }

}


