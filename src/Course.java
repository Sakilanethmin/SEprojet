public class Course{
    protected String courseCode;
    protected String courseName;

    public Course(String courseCode, String courseName){
        this.courseCode = courseCode;
        this.courseName = courseName;
    }

    public void displayCourse(){
        System.out.println("Course code: " +courseCode);
        System.out.println("Course Name: " +courseName);
    }

}


