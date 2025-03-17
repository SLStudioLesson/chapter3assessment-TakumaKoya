import com.recipeapp.datahandler.CSVDataHandler;
import com.recipeapp.datahandler.DataHandler;
import com.recipeapp.datahandler.JSONDataHandler;
import com.recipeapp.ui.RecipeUI;
import java.io.*;
import java.util.ArrayList;

import javax.xml.crypto.Data;

public class App {

    public static void main(String[] args) {

        /*
         * ユーザーの選択に応じて、CSVDataHandlerまたはJSONDataHandlerのインスタンスを生成する
            ・「1」を選択した場合、CSVDataHandlerインスタンスを生成する
                引数が0個のコンストラクタを実行するものとする
            ・「2」を選択した場合、JSONDataHandlerインスタンスを生成する

            ・不正な入力（「1」「2」以外）が与えられた場合、CSVDataHandlerインスタンスを生成する
            ・選択されたデータハンドラーをcom/recipeappパッケージのRecipeUIに渡し、displayMenuメソッドを呼び出してメインメニューを表示します。
         */

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Choose the file format:");
            System.out.println("1. CSV");
            System.out.println("2. JSON");
            System.out.print("Select (1/2): ");
            String choice = reader.readLine();

            switch (choice) {
                case "1": {
                    CSVDataHandler csvDataHandler = new CSVDataHandler();
                    DataHandler dataHandler = (DataHandler)csvDataHandler;
                    RecipeUI recipeUI = new RecipeUI(dataHandler);
                    recipeUI.displayMenu();
                    break;
                }
                case "2": {
                    JSONDataHandler jsonDataHandler = new JSONDataHandler();
                    DataHandler dataHandler = (DataHandler)jsonDataHandler;
                    RecipeUI recipeUI = new RecipeUI(dataHandler);
                    recipeUI.displayMenu();
                    break;
                }
                default: {
                    CSVDataHandler csvDataHandler = new CSVDataHandler();
                    DataHandler dataHandler = (DataHandler)csvDataHandler;
                    RecipeUI recipeUI = new RecipeUI(dataHandler);
                    recipeUI.displayMenu();
                    break;
                }
            }

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}