package com.university.management;
import java.time.LocalTime;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Attendance {
    private static final Logger logger = Logger.getLogger(Attendance.class.getName());
    String[] children = {"rajitha", "prasanna", "sakila", "lisara"};
    String[] attendanceTime = new String[children.length]; // store time

    void markAttendance() {

        Scanner sc = new Scanner(System.in);
       while (true) {

           logger.info("Enter name (or 'exit'): ");
            String name = sc.nextLine();
           if (name.equalsIgnoreCase("exit")) {
                break;
           }

            boolean found = false;

            for (int i = 0; i < children.length; i++) {
                if (name.equalsIgnoreCase(children[i])) {

                    LocalTime time = LocalTime.now();
                    attendanceTime[i] = time.toString();

                    logger.log(Level.INFO, "Attendance marked for {0} at {1}", new Object[]{children[i], attendanceTime[i]});

                    found = true;
                    break;
                }
            }

            if (!found) {
                logger.info("Name not found!");
            }
        }
    }

    void displayAttendance() {
        logger.info ("-------------------------------- Attendance List ---------------------------------------");
        for (int i = 0; i < children.length; i++) {
            String time = (attendanceTime[i] == null) ? "Absent" : attendanceTime[i];
            logger.info("-----------------------------------------------------------------------------------------");
            logger.log(Level.INFO, ":{0} | {1}|", new Object[]{children[i], time});
        }
    }
}






