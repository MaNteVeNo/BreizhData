package view;
import control.BDFirstController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BreizhDataApp extends Application {

    private BDFirstController controller;
    private IntroView introView;
    private ConnexionView connexionView;
    private Scene introScene;
    private Scene connexionScene;

    public void start(Stage primaryStage) {
        this.controller = new BDFirstController(primaryStage, this);
        this.introView = new IntroView(controller);
        this.connexionView = new ConnexionView(controller);

        this.introScene = new Scene(introView, 1500, 1000);
        this.connexionScene = new Scene(connexionView, 1500, 1000);


        primaryStage.setTitle("BreizhData");
        primaryStage.setScene(introScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public IntroView getIntroView() {
        return this.introView;
    }

    public ConnexionView getConnexionView() {
        return this.connexionView;
    }

    public Scene getIntroScene() {
        return this.introScene;
    }

    public Scene getConnexionScene() {
        return this.connexionScene;
    }
}
