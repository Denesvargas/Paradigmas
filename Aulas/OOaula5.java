import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MouseCircles extends Application {
   @Override
   public void start(Stage stage) {
      BorderPane bp = new BorderPane();
      ButtonTop buttons = new ButtonTop();
      Pane panel = new Pane();
      bp.setCenter(panel);
      buttons.setPane(bp);
      buttons.pressiona(panel);
      Scene scene = new Scene(bp, 600, 500);
      stage.setScene(scene);
      stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
