package com.university.management;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());
    private static final String DIVIDER = "-----------------------------------------------------------------------------------------";
    private static final String INVALID_OPTION = "Invalid option";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        attendance obj = new attendance();

        // Mock Data Initialization
        Login[] users = new Login[]{
                new Login("nethmin-ps23054@stu.kln.ac.lk", "nethmin@123"),
                new Login("wijesir-ps23008@stu.kln.ac.lk", "wijesir@123"),
                new Login("rajakar-ps23225@stu.kln.ac.lk", "rajakar@123"),
                new Login("hewawas-ps23220@stu.kln.ac.lk", "lisara@123"),
                new Login("ashinkaw-ps23230@stu.kln.ac.lk", "ashnika@123")
        };

        Login[] lecturersLogin = new Login[]{
                new Login("herath-23154@lec.kln.ac.lk", "herath@123"),
                new Login("perera-23108@lec.kln.ac.lk", "perera@123"),
        };

        Student[] students = new Student[]{
                new Student("PS/2023/054", "Sakila Nethmin", "nethmin-ps23054@stu.kln.ac.lk", "nethmin@123"),
                new Student("PS/2023/008", "Prasanna Dilshan", "wijesir-ps23008@stu.kln.ac.lk", "wijesir@123"),
                new Student("PS/2023/225", "Rajitha Rajakaruna", "rajakar-ps23225@stu.kln.ac.lk", "rajakar@123"),
                new Student("PS/2023/230","Ashinka Viraj", "ashinkaw-ps23230@stu.kln.ac.lk", "ashnika@123"),
                new Student("PS/2023/220", "Lisara Hewawasam", "hewawas-ps23220@stu.kln.ac.lk", "lisara@123")
        };

        Lecturer[] lecturers = new Lecturer[]{
                new Lecturer("herath/23108", "Kasun Herath", "herath-23154@lec.kln.ac.lk", "herath@123", "Computer Science"),
                new Lecturer("perera/23109", "Sunimal Perera", "perera-23108@lec.kln.ac.lk", "perera@123", "Statistics")
        };

        Course[] courses = new Course[]{
                new Course("COSC12043", "OOP"),
                new Course("STAT12345", "Probability Distribution")
        };

        // Main Control Loop
        while (true) {
            int choice = Front.menu();

            switch (choice) {
                case 1:
                    logger.info("-------------------------------Mark Attendance-------------------------------------------");
                    obj.markAttendance();
                    logger.info(DIVIDER);
                    break;

                case 2:
                    handleLoginProcess(input, users, lecturersLogin, students, lecturers, courses, obj);
                    break;

                case 0:
                    logger.info("Exiting program...");
                    return;

                default:
                    logger.warning(INVALID_OPTION);
            }
        }
    }

    // -------------------------------------------------------------------------
    // Helper Methods to Reduce Cognitive Complexity
    // -------------------------------------------------------------------------

    private static void handleLoginProcess(Scanner input, Login[] users, Login[] lecturersLogin,
                                           Student[] students, Lecturer[] lecturers, Course[] courses, attendance obj) {
        logger.info("-----------------------------------Login-------------------------------------------------");
        logger.info("Enter Email Below:");
        String email = input.nextLine();
        logger.info("Enter Password Below:");
        String password = input.nextLine();
        logger.info(DIVIDER);

        boolean loggedIn = tryStudentLogin(input, email, password, users, students, courses);

        if (!loggedIn) {
            loggedIn = tryLecturerLogin(input, email, password, lecturersLogin, lecturers, obj);
        }

        if (!loggedIn) {
            logger.log(Level.WARNING, "Email or password does not match.");
        }
    }

    private static boolean tryStudentLogin(Scanner input, String email, String password, Login[] users, Student[] students, Course[] courses) {
        for (Login login : users) {
            if (login.checkEnter(email, password)) {
                login.displayLogin(true);
                for (Student student : students) {
                    if (student.getEmail().equals(email) && student.getPassword().equals(password)) {
                        manageStudentSession(input, student, courses);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static void manageStudentSession(Scanner input, Student student, Course[] courses) {
        boolean running = true;
        while (running) {
            logger.info("_______________________________Choose option_____________________________________________");
            logger.info("a. View Profile\nb. View All Courses\nc. Enroll new course\n0. Exit");
            logger.info(DIVIDER);
            String option = input.nextLine();

            switch (option) {
                case "a":
                    student.displayInfo();
                    logger.info("\n1. Update Name\n0. Back\nChoose: ");
                    if ("1".equals(input.nextLine())) {
                        logger.info("Enter new name: ");
                        student.setUserName(input.nextLine());
                        logger.info("Name updated successfully.");
                    }
                    break;
                case "b":
                    logger.info("----------------------------Courses Info--------------------------------------------------");
                    for (Course c : courses) {
                        c.displayCourse();
                    }
                    student.viewCourses();
                    break;
                case "c":
                    logger.info("Enter course code: ");
                    String cc = input.nextLine();
                    logger.info("Enter course name: ");
                    String cn = input.nextLine();
                    student.addCourse(new Course(cc, cn));
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    logger.warning(INVALID_OPTION);
            }
        }
    }

    private static boolean tryLecturerLogin(Scanner input, String email, String password, Login[] lecturersLogin, Lecturer[] lecturers, attendance obj) {
        for (Login login : lecturersLogin) {
            if (login.checkEnter(email, password)) {
                login.displayLogin(true);
                for (Lecturer lec : lecturers) {
                    if (lec.getEmail().equals(email) && lec.getPassword().equals(password)) {
                        manageLecturerSession(input, lec, obj);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static void manageLecturerSession(Scanner input, Lecturer lec, attendance obj) {
        boolean running = true;
        while (running) {
            logger.info("--------------------------------Choose option--------------------------------------------");
            logger.info("a. View Profile\nb. View Courses\nc. Add new Course\nd. View Attendance\n0. Exit");
            logger.info(DIVIDER);
            String option = input.nextLine();

            switch (option) {
                case "a":
                    lec.displayInfo();
                    logger.info("\n1. Update Name\n0. Back\nChoose: ");
                    if ("1".equals(input.nextLine())) {
                        logger.info("Enter new name: ");
                        lec.setUserName(input.nextLine());
                        logger.info("Name updated successfully.");
                    }
                    break;
                case "b":
                    lec.viewCourses();
                    break;
                case "c":
                    logger.info("Course code: ");
                    String cc = input.nextLine();
                    logger.info("Course Name: ");
                    String cn = input.nextLine();
                    lec.addNewCourse(cc, cn);
                    break;
                case "d":
                    obj.displayAttendance();
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    logger.warning(INVALID_OPTION);
            }
        }
    }
}