package com.recipeapp.datahandler;

import java.util.ArrayList;

import com.recipeapp.model.Recipe;

public interface DataHandler {
    public String getMode(); //現在のモードを返します。
    public ArrayList<Recipe> readData(); //レシピデータを読み込み、Recipeオブジェクトのリストとして返します。
    public void writeData(Recipe recipe); //指定されたRecipeオブジェクトを追加します。
    public ArrayList<Recipe> searchData(String keyword); //指定されたキーワードでレシピを検索し、一致するRecipeオブジェクトのリストを返します。
}
