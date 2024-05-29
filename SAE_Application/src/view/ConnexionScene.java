package view;

import control.BDFirstController;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class ConnexionScene extends BorderPane {

    private BDFirstController controller;
    private VBox layout;
    private TextField usernameField;
    private PasswordField passwordField;
    private Button loginButton;
    private Button backButton;
    private Label messageLabel;

    public ConnexionScene(BDFirstController controller) {
        this.controller = controller;
        initialize();
    }

    private void initialize() {
        layout = new VBox();
        layout.setPadding(new Insets(10));
        layout.setSpacing(10);

        usernameField = new TextField();
        usernameField.setPromptText("Nom d'utilisateur");

        passwordField = new PasswordField();
        passwordField.setPromptText("Mot de passe");

        loginButton = new Button("Se connecter");
        loginButton.getStyleClass().add("button-start");
        loginButton.setOnAction(controller);

        backButton = new Button("Retour");
        backButton.getStyleClass().add("button-back");
        backButton.setOnAction(controller);

        messageLabel = new Label();
        messageLabel.setStyle("-fx-text-fill: red;");

        layout.getChildren().addAll(usernameField, passwordField, loginButton, backButton, messageLabel);

        this.setCenter(layout);
    }

    public Button getLoginButton() {
        return loginButton;
    }

    public Button getBackButton() {
        return backButton;
    }
}
