package control;

import view.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BDFirstController implements EventHandler<ActionEvent> {

    private BreizhDataApp view;
    private Stage stage;

    public BDFirstController(Stage stage, BreizhDataApp view) {
        this.view = view;
        this.stage = stage;
    }
 
    public void handle(ActionEvent event) {
        // Pour passer à la page de connexion
        if (event.getSource() == view.getIntroScene().getStartButton()) {
            Scene connexionScene = new Scene(view.getConnexionScene(), 1500, 1000);
            stage.setScene(connexionScene);
        } else if (event.getSource() == view.getConnexionScene().getBackButton()) {
            Scene introScene = new Scene(view.getIntroScene(), 1500, 1000);
            stage.setScene(introScene);
        }
    }
}
