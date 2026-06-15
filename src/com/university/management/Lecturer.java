package com.university.management;
import java.util.logging.Logger;
import java.util.logging.Level;
public class Lecturer extends Person implements CourseViewable {
    private static final Logger logger = Logger.getLogger(Lecturer.class.getName());
    Course[] addCourses = new Course[10];
    private int i = 0;
    protected String department;

    Lecturer(String userId,String userName, String email, String password, String department){
        super(userId, userName, email, password);
        this.department = department;
    }
   public void addNewCourse(String courseCode, String courseName){
       if (i < addCourses.length) {
           addCourses[i] = new Course(courseCode, courseName);
           i++;
           logger.info("Course added successfully");
       }
       else{
           logger.info("Maximum course limit reached");
       }
   }
   @Override
    public void displayInfo() {
        super.displayInfo();
       logger.log(Level.INFO, "Department: {0}", department);
    }

    @Override
   public void viewCourses() {
        if (i == 0){
            logger.info("No course added");
        }
        else {
            for(int j = 0; j < i; j++) {
                addCourses[j].displayCourse();
            }
        }
   }

}

