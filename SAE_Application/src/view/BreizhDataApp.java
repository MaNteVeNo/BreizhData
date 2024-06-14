package view;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class BreizhDataApp extends Application {


    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/utilities/SceneAccueille.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("BreizhData");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}
