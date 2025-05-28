package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class MainCoffeeMaker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> ingredients = new HashMap<>();
        ingredients.put("coffee", 10);
        ingredients.put("milk", 0);
        ingredients.put("sugar", 10);
        Machine machine = new Machine(ingredients);
        System.out.println("Select a coffee type:");
        System.out.println("1. Simple Coffee");
        System.out.println("2. Coffee with Milk");
        System.out.println("3. VIP Coffee");

        int choice = scanner.nextInt();
        CoffeeType selectedType;

        switch (choice) {
            case 1: selectedType = CoffeeType.SIMPLE_COFFEE; break;
            case 2: selectedType = CoffeeType.COFFEE_WITH_MILK; break;
            case 3: selectedType = CoffeeType.VIP_COFFEE; break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        System.out.print("Enter amount paid (Ar): ");
        double amountPaid = scanner.nextDouble();

        double price = switch (selectedType) {
            case SIMPLE_COFFEE -> 2.0;
            case COFFEE_WITH_MILK -> 3.0;
            case VIP_COFFEE -> 5.0;
        };

        double discountedPrice = machine.applyDiscount(price);

        if (amountPaid < discountedPrice) {
            System.out.println("Payment failed");
            return;
        }

        Map<String, Integer> recipe = machine.getCoffee(selectedType);
        boolean success = machine.createCoffee(recipe);

        if (success) {
            System.out.println("Preparing your coffee...");
            System.out.println("Here it is your coffee!");
        } else {
            System.out.println("Insufficient ingredients");
        }
    }
}



