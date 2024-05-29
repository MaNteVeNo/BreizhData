package view;
import control.BDFirstController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BreizhDataApp extends Application {

    private BDFirstController controller;
    private IntroScene introScene;
    

    public void start(Stage primaryStage) {
        this.controller = new BDFirstController(primaryStage, this);
        this.introScene = new IntroScene(controller);
        Scene scene = new Scene(introScene, 1500, 1000);

        primaryStage.setTitle("BreizhData");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public IntroScene getIntroScene() {
        return this.introScene;
    }

}

