package com.recipeapp.datahandler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
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
        ArrayList<Recipe> name = new ArrayList<>();
        ArrayList<Recipe> ingredients = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for(int i = line.length(); i < line.length(); i++) {
                    String[] element = line.split(",");
                    
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return name;
    }

    public void writeData(Recipe recipe) {

    }

    public ArrayList<Recipe> searchData(String keyword) {
        return null;
    }

    
}
