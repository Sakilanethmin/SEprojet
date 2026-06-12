
import java.time.LocalTime;
import java.util.Scanner;

public class attendance {
    String[] children = {"rajitha", "prasanna", "sakila", "lisara"};
    String[] attendanceTime = new String[children.length]; // store time

    void markAttendance() {

        Scanner sc = new Scanner(System.in);
       while (true) {

           System.out.print("Enter name (or 'exit'): ");
            String name = sc.nextLine();
           if (name.equalsIgnoreCase("exit")) {
                break;
           }

            boolean found = false;

            for (int i = 0; i < children.length; i++) {
                if (name.equalsIgnoreCase(children[i])) {

                    LocalTime time = LocalTime.now();
                    attendanceTime[i] = time.toString();

                    System.out.println("Attendance marked for " + children[i] +
                            " at " + attendanceTime[i]);

                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Name not found!");
            }
        }
    }

    void displayAttendance() {
        System.out.println("-------------------------------- Attendance List ---------------------------------------");
        for (int i = 0; i < children.length; i++) {
            String time = (attendanceTime[i] == null) ? "Absent" : attendanceTime[i];
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println(":" + children[i] + " | " + time + "|");
        }
    }
}






