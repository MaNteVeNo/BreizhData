package control;

import view.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class BDFirstController implements EventHandler<ActionEvent> {

    private BreizhDataApp view;
    private Stage stage;

    public BDFirstController(Stage stage, BreizhDataApp view) {
        this.view = view;
        this.stage = stage;
    }

    public void handle(ActionEvent event) {
        if (event.getSource() == view.getIntroView().getStartButton()) {
            stage.setScene(view.getConnexionScene());
        } else if (event.getSource() == view.getConnexionView().getBackButton()) {
            stage.setScene(view.getIntroScene());
        }
    }
}
