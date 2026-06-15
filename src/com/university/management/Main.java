package com.university.management;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        attendance obj = new attendance();

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

        while (true) {
            int choice = Front.menu();

            switch (choice) {
                case 1:
                    System.out.println("-------------------------------Mark Attendance-------------------------------------------");
                    obj.markAttendance();
                    System.out.println("-----------------------------------------------------------------------------------------");
                    break;

                case 2: { // Login
                    System.out.println("-----------------------------------Login-------------------------------------------------");
                    System.out.print("Email: ");
                    String email = input.nextLine();
                    System.out.print("Password: ");
                    String password = input.nextLine();
                    System.out.println("-----------------------------------------------------------------------------------------");

                    boolean loggedIn = false;

                    // Student Login
                    for (Login login : users) {
                        if (login.checkEnter(email, password)) {
                            login.displayLogin(true);
                            loggedIn = true;

                            for (Student student : students) {
                                if (student.getEmail().equals(email) && student.getPassword().equals(password)) {

                                    boolean running = true;
                                    while (running) {
                                        System.out.println("_______________________________Choose option_____________________________________________");
                                        System.out.println("a. View Profile");
                                        System.out.println("b. View All Courses ");
                                        System.out.println("c. Enroll new course");
                                        System.out.println("0. Exit");
                                        System.out.println("_________________________________________________________________________________________");
                                        String option = input.nextLine();

                                        switch (option) {
                                            case "a":
                                                student.displayInfo();
                                                System.out.println();
                                                System.out.println("1. Update Name");
                                                System.out.println("0. Back");
                                                System.out.print("Choose: ");
                                                String profileOption = input.nextLine();

                                                switch (profileOption) {
                                                    case "1":
                                                        System.out.print("Enter new name: ");
                                                        String newUserName = input.nextLine();
                                                        student.setUserName(newUserName);
                                                        System.out.println("Name updated successfully.");
                                                        break;

                                                    case "0":
                                                        break;

                                                    default:
                                                        System.out.println("Invalid option");
                                                }
                                                break;

                                            case "b":
                                                System.out.println("----------------------------Courses Info--------------------------------------------------");
                                                for (Course c : courses) {
                                                    c.displayCourse();
                                                }
                                                student.viewCourses();
                                                break;

                                            case "c":
                                                System.out.print("Enter course code: ");
                                                String cc = input.nextLine();
                                                System.out.print("Enter course name: ");
                                                String cn = input.nextLine();
                                                student.addCourse(new Course(cc, cn));
                                                break;

                                            case "0":
                                                running = false;
                                                break;

                                            default:
                                                System.out.println("Invalid option");
                                        }
                                    }
                                }
                            }
                        }
                    }

                    // Lecturer Login
                    for (Login login : lecturersLogin) {
                        if (login.checkEnter(email, password)) {
                            login.displayLogin(true);
                            loggedIn = true;

                            for (Lecturer lec : lecturers) {
                                if (lec.getEmail().equals(email) && lec.getPassword().equals(password)) {

                                    boolean running = true;
                                    while (running) {
                                        System.out.println("--------------------------------Choose option--------------------------------------------");
                                        System.out.println("a. View Profile");
                                        System.out.println("b. View Courses");
                                        System.out.println("c. Add new Course");
                                        System.out.println("d. View Attendance");
                                        System.out.println("0. Exit");
                                        System.out.println("-----------------------------------------------------------------------------------------");
                                        String option = input.nextLine();

                                        switch (option) {
                                            case "a":
                                                lec.displayInfo();
                                                System.out.println();
                                                System.out.println("1. Update Name");
                                                System.out.println("0. Back");
                                                System.out.print("Choose: ");
                                                String profileOption = input.nextLine();

                                                switch (profileOption) {
                                                    case "1":
                                                        System.out.print("Enter new name: ");
                                                        String newUserName = input.nextLine();
                                                        lec.setUserName(newUserName);
                                                        System.out.println("Name updated successfully.");
                                                        break;


                                                    case "0":
                                                        break;

                                                    default:
                                                        System.out.println("Invalid option");
                                                }
                                                break;

                                            case "b":
                                                lec.viewCourses();
                                                break;

                                            case "c":
                                                System.out.print("Course code: ");
                                                String cc = input.nextLine();
                                                System.out.print("Course Name: ");
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
                                                System.out.println("Invalid option");
                                        }
                                    }
                                }
                            }
                        }
                    }

                    if (!loggedIn) {
                        System.out.println("Email or password does not match.");
                    }
                    break;
                }

                case 0:
                    System.out.println("Exiting program...");
                    return;

                default:
                    System.out.println("Invalid option");
            }
        }
    }
}
