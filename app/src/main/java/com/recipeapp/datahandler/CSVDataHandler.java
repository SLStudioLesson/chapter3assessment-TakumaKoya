package com.recipeapp.datahandler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;

import com.recipeapp.model.Ingredient;
import com.recipeapp.model.Recipe;

public class CSVDataHandler implements DataHandler {
    private String filePath; //レシピデータを格納するCSVファイルのパス。

    //コンストラクタ
    public CSVDataHandler() {
        this.filePath = "app/src/main/resources/recipes.csv";
    }

    public CSVDataHandler(String filePath) {
        this.filePath = filePath;
    }

    //メソッド
    public String getMode() {
        return "CSV";
    }

    //recipes.csvからデータ読み込み
    public ArrayList<Recipe> readData() {
        ArrayList<Recipe> recipes = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String element[] = line.split(",");
                if (element.length > 1) {
                    String recipeName = element[0];
                    ArrayList<Ingredient> ingredients = new ArrayList<>();
                    for(int i = 1; i < element.length; i++){
                        ingredients.add(new Ingredient(element[i]));
                    }
                    recipes.add(new Recipe(recipeName, ingredients));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return recipes;
    }

    public void writeData(Recipe recipe) {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(filePath, true)))) {
            StringBuilder line = new StringBuilder();
            line.append(recipe.getName());

            for (Ingredient ingredient : recipe.getIngredients()) {
                line.append(", ").append(ingredient.getName());
            }
            out.println(line.toString());
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public ArrayList<Recipe> searchData(String keyword) {
        return null;
    }

    
}
