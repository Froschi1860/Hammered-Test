package se.hkr;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        User user = null;
        main.printMenu(user);
        main.drinkMenu(user);
    }

    void printMenu(User user) {
        boolean menuFLag = true;
        Scanner input = new Scanner(System.in);

        while (menuFLag) {
            System.out.println("--- Welcome to The Hammered Test ---");
            System.out.print("Height (in cm): ");
            double height = input.nextDouble();
            System.out.print("Weight (in kg): ");
            double weight = input.nextDouble();
            System.out.print("Duration (in hours): ");
            double duration = input.nextDouble();
            System.out.print("Gender (M/F): ");
            String gender = input.next().toUpperCase();

            user = new User(height, weight, duration, gender);
            menuFLag = false;
        }
    }

    void drinkMenu(User user) {
        boolean menuFlag = true;
        Scanner input = new Scanner(System.in);
        double volume, alcohol;
        String selectedDrink;

        while (menuFlag) {
            System.out.println("\n--- Select Drinks ---");
            System.out.println("1. Beer\n2. liquor\n3. Wine\n4. Calculate my result");
            System.out.print("Select options (1-4): ");
            int option = input.nextInt();

            switch (option) {
                case (1) -> {
                    selectedDrink = "Beer";
                }
                case (2) -> {
                    selectedDrink = "Liquor";
                }
                case (3) -> {
                    selectedDrink = "Wine";
                }
                case (4) -> System.out.println("Your choose display result");
            }


        }
    }
}
