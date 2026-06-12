package com.university.management;
public class Student extends Person implements CourseViewable {
    Course[] enrolledCourses = new Course[10];
    int i  = 0;
    public Student(String userID, String userName, String email, String password) {
        super(userID, userName, email, password);
    }
    public void displayInfo(){
        super.displayInfo();
    }
    public void addCourse(Course course){
        if (i < enrolledCourses.length) {
            enrolledCourses[i] = course;
            i++;
            System.out.println("Enrolled successfully");
        }
        else{
            System.out.println("Maximum course limit reached");
        }
    }
    public void viewCourses(){
            for(int j = 0; j < i; j++){
                enrolledCourses[j].displayCourse();
            }
    }

}