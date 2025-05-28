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
        for (Map.Entry<String, Integer> entry : requiredIngredients.entrySet()) {
            String ingredient = entry.getKey();
            int quantityNeeded = entry.getValue();
            if (ingredients.getOrDefault(ingredient, 0) < quantityNeeded) {
                return false;
            }
        }

        for (Map.Entry<String, Integer> entry : requiredIngredients.entrySet()) {
            ingredients.put(entry.getKey(), ingredients.get(entry.getKey()) - entry.getValue());
        }

        return true;
    }

    public Map<String, Integer> getCoffeeRecipe(CoffeeType type) {
        Map<String, Integer> recipe = new HashMap<>();
        switch (type) {
            case SIMPLE_COFFEE:
                recipe.put("coffee", 1);
                recipe.put("sugar", 1);
                break;
            case COFFEE_WITH_MILK:
                recipe.put("coffee", 1);
                recipe.put("milk", 1);
                recipe.put("sugar", 1);
                break;
            case VIP_COFFEE:
                recipe.put("coffee", 2);
                recipe.put("milk", 2);
                recipe.put("sugar", 2);
                break;
        }
        return recipe;
    }
}
