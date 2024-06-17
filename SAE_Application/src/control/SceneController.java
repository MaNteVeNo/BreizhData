package control;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import 

import java.awt.event.ActionEvent;
import javafx.scene.control.Button;


public class SceneController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button accueilleMapButton;

    @FXML
    void clickMapAccueille(ActionEvent event) {
        Parent root = FXMLLoader.Load(getClass().getResource("Page Map.fxml"));
        stage = ((Stage)(Node)event.getSource()).getScene().getWindow();
        scene = new scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
