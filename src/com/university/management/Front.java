package com.university.management;
import java.util.Scanner;
import java.util.logging.Logger;

public class Front {
    private static final Logger LOGGER = Logger.getLogger(Front.class.getName());
    static Scanner input = new Scanner(System.in);

    private Front() {
    }

    public static int menu(){
        LOGGER.info("-------------------------------------Menu------------------------------------------------");
        System.out.println("Choose option: ");
        System.out.println("1. Attendance");
        System.out.println("2. Login");
        System.out.println("0. Exist");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.print("Choose: ");

        return input.nextInt();
    }
}
