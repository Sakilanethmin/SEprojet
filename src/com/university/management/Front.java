package com.university.management;
import java.util.Scanner;

public class Front {
    static Scanner input = new Scanner(System.in);

    private Front() {
    }

    public static int menu(){
        System.out.println("-------------------------------------Menu------------------------------------------------");
        System.out.println("Choose option: ");
        System.out.println("1. Attendance");
        System.out.println("2. Login");
        System.out.println("0. Exist");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.print("Choose: ");

        return input.nextInt();
    }
}
