package view;

import control.BDFirstController;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class IntroView extends BorderPane{

    private BDFirstController controller;
    private VBox layout;
    private Label welcomeLabel;
    private Button startButton;
   
    public IntroView(BDFirstController controller) {
        
        this.controller = controller;
        initialize();
    }

    private void initialize() {
        layout = new VBox();
        layout.setPadding(new Insets(10));
        layout.setSpacing(10);

        welcomeLabel = new Label("Bienvenue dans notre application!");
        welcomeLabel.getStyleClass().add("label-title");

        startButton = new Button("Commencer");
        startButton.getStyleClass().add("button-start");
        startButton.setOnAction(controller);

        layout.getChildren().addAll(welcomeLabel, startButton);

        this.setCenter(layout);

    }

    public Button getStartButton() {
        return this.startButton;
    }


}
