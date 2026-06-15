package com.university.management;
import java.util.logging.Logger;
public class Student extends Person implements CourseViewable {
    private static final Logger LOGGER = Logger.getLogger(Student.class.getName());

    Course[] enrolledCourses = new Course[10];
    int i  = 0;
    public Student(String userID, String userName, String email, String password) {
        super(userID, userName, email, password);
    }

    public void addCourse(Course course){
        if (i < enrolledCourses.length) {
            enrolledCourses[i] = course;
            i++;
            LOGGER.info("Enrolled successfully");
        }
        else{
            LOGGER.info("Maximum course limit reached");
        }
    }

    public void viewCourses(){
            for(int j = 0; j < i; j++){
                enrolledCourses[j].displayCourse();
            }
    }

}