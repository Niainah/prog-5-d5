package org.example;

import java.util.HashMap;
import java.util.Map;

public class Machine {
    private final Map<String, Integer> ingredients;

    public Machine() {
        ingredients = new HashMap<>();
        ingredients.put("coffee", 10);
        ingredients.put("milk", 10);
        ingredients.put("sugar", 10);
    }

    public double applyDiscount(double amount) {
        if (amount >= 10) return amount * 0.9;
        return amount;
    }

    public boolean createCoffee(Map<String, Integer> requiredIngredients) {
        for (String ingredient : requiredIngredients.keySet()) {
            int quantityNeeded = requiredIngredients.get(ingredient);
            int quantityAvailable = ingredients.getOrDefault(ingredient, 0);

            if (quantityAvailable < quantityNeeded) {
                return false;
            }
        }

        for (String ingredient : requiredIngredients.keySet()) {
            int quantityUsed = requiredIngredients.get(ingredient);
            int currentStock = ingredients.get(ingredient);
            ingredients.put(ingredient, currentStock - quantityUsed);
        }
        return true;
    }


    public Map<String, Integer> getCoffee(CoffeeType type) {
        Map<String, Integer> recipe = new HashMap<>();
        if (type == CoffeeType.SIMPLE_COFFEE) {
            recipe.put("coffee", 1);
            recipe.put("sugar", 1);
        } else if (type == CoffeeType.COFFEE_WITH_MILK) {
            recipe.put("coffee", 1);
            recipe.put("milk", 1);
            recipe.put("sugar", 1);
        } else if (type == CoffeeType.VIP_COFFEE) {
            recipe.put("coffee", 2);
            recipe.put("milk", 2);
            recipe.put("sugar", 2);
        }
        return recipe;
    }

}
