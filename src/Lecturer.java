public class Lecturer extends Person implements CourseViewable {
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
           System.out.println("Course added successfully");
       }
       else{
           System.out.println("Maximum course limit reached");
       }
   }
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Department: " +department);
    }
   public void viewCourses() {
        if (i == 0){
            System.out.println("No course added");
        }
        else {
            for(int j = 0; j < i; j++) {
                addCourses[j].displayCourse();
            }
        }
   }

}

