package com.recipeapp.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import com.recipeapp.datahandler.DataHandler;
import com.recipeapp.model.Ingredient;
import com.recipeapp.model.Recipe;
import com.recipeapp.datahandler.CSVDataHandler;

public class RecipeUI {
    private BufferedReader reader;
    private DataHandler dataHandler;

    public RecipeUI(DataHandler dataHandler) {
        reader = new BufferedReader(new InputStreamReader(System.in));
        this.dataHandler = dataHandler;
    }
    
    public void displayMenu() {

        System.out.println("Current mode: " + dataHandler.getMode());

        while (true) {
            try {
                System.out.println();
                System.out.println("Main Menu:");
                System.out.println("1: Display Recipes");
                System.out.println("2: Add New Recipe");
                System.out.println("3: Search Recipe");
                System.out.println("4: Exit Application");
                System.out.print("Please choose an option: ");

                String choice = reader.readLine();

                switch (choice) {
                    case "1":
                        displayRecipes();
                        break;
                    case "2":
                        addNewRecipe();
                        break;
                    case "3":
                        break;
                    case "4":
                        System.out.println("Exiting the application.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please select again.");
                        break;
                }
            } catch (IOException e) {
                System.out.println("Error reading input from user: " + e.getMessage());
            }
        }
    }

    //DataHndllerから読み込んだレシピデータを整形してコンソールに表示します。
    private void displayRecipes() {
        try {

            ArrayList<Recipe> recipis = dataHandler.readData();
    
            if (recipis.isEmpty()) {
                System.out.println("No recipes available.");
            }
    
            System.out.println("Recipes:");
            System.out.println("-----------------------------------");
    
            for (Recipe recipe : recipis) {
                System.out.println("Recipe Name: " + recipe.getName());
    
                System.out.print("Main Ingredients: ");
    
                ArrayList<Ingredient> ingredients = recipe.getIngredients();
                for (int i = 0; i < ingredients.size(); i++) {
                    System.out.print(ingredients.get(i).getName());
                    if(i < ingredients.size() - 1) {
                        System.out.print(",");
                    }
                }
                System.out.println();
                System.out.println("-----------------------------------");
            }
        } catch(IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // DataHandlerを使用してrecipes.csvに新しいレシピを追加。
    private void addNewRecipe() {
        try {
            System.out.println("Adding a new recipe.");
            //レシピ名
            System.out.print("Enter recipe name: ");
            String recipeName = reader.readLine();
    
            //材料リスト
            ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
            System.out.println("Enter ingredients (type 'done' when finished): ");
    
            while (true) {
                System.out.print("Ingredient: ");
                String ingredientName = reader.readLine();
    
                if(ingredientName.equals("done")) {
                    break;
                }
                ingredients.add(new Ingredient(ingredientName));
            }
    
            //CSVに保存
            Recipe recipe = new Recipe(recipeName, ingredients);
            dataHandler.writeData(recipe);
    
            System.out.println("Recipe added successfully.");
        } catch(IOException e) {
            System.out.println("Failed to add new recipe: " + e.getMessage());
        }
    }
}
