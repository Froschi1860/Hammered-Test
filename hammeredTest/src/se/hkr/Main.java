package se.hkr;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        User user = main.userMenu();
        main.drinkMenu(user);
    }

    User userMenu() {
        boolean menuFLag = true;
        Scanner input = new Scanner(System.in);
        User user = null;

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
        return user;
    }

    void drinkMenu(User user) {
        boolean menuFlag = true;
        Scanner input = new Scanner(System.in);

        while (menuFlag) {
            System.out.println("\n--- Select Drinks ---");
            System.out.println("1. Beer\n2. liquor\n3. Wine\n4. Calculate my result");
            System.out.print("Select options (1-4): ");
            int option = input.nextInt();

            switch (option) {
                case (1) -> { addDrink("Beer", 0.33, 1, 2, 9, user); }
                case (2) -> { addDrink("Liquor", 0.04, 0.10, 15, 70,user); }
                case (3) -> { addDrink("Wine", 0.2, 0.5, 7, 15, user); }
                case (4) -> {
                    System.out.println("Your choose display result");
                    System.out.printf("It will take you %.2f hours to get sober", User.calculateTimeToSobrietyInHours(user));
                    menuFlag = false;
                }
            }
        }
    }

    void addDrink(String drink, double volumeFloor, double volumeTop, double alcoholFloor, double alcoholTop, User user) {
        Scanner input = new Scanner(System.in);

        System.out.printf("\n --- Add %s Details ---\n", drink);
        boolean correctInput = false;
        while (!correctInput) {
            System.out.printf("Volume (%.2f - %.2f cl): ", volumeFloor, volumeTop);
            double volume = input.nextDouble();
            System.out.printf("Alcohol percentage:  (%.2f - %.2f%%): ", alcoholFloor, alcoholTop);
            double alcohol = input.nextDouble() / 100;

            if ((volume >= volumeFloor && volume <= volumeTop) && (alcohol >= alcoholFloor / 100 && alcohol <= alcoholTop / 100)) {
                correctInput = true;

                switch (drink) {
                    case ("Beer") -> user.getConsumedDrinks().add(new Beer(volume, alcohol));
                    case ("Liquor") -> user.getConsumedDrinks().add(new Liquor(volume, alcohol));
                    case ("Wine") -> user.getConsumedDrinks().add(new Wine(volume, alcohol));
                }

                System.out.printf("%s added!\n", drink);

            } else System.out.println("Error Input out of range");
        }
    }
}
