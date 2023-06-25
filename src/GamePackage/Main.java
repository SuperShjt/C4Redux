package GamePackage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
            stage.setTitle("Connect 4");
            Scene sc=new Scene(SceneBuilder.BuildMenu(stage));
            stage.setScene(sc);
            stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}
