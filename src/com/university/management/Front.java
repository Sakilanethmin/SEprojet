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
        LOGGER.info("Choose option: ");
        LOGGER.info("1. Attendance");
        LOGGER.info("2. Login");
        LOGGER.info("0. Exist");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.print("Choose: ");

        return input.nextInt();
    }
}
