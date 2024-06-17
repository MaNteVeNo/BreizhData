package control;

public class main {
    public void start(Stage stage){
        try{
            Parent root = FXMLLoader.Load(getClass().getResource("SceneAcceille.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }catch (Exception e ){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        Launch(args);
    }
}
