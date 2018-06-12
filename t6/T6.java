import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class T6 extends Application{
  
  @Override
  public void start(Stage stage) {
    stage.setTitle("Planarity do Denes");
    BorderPane bp = new BorderPane();
    Menus buttons = new Menus();
    Pane panel = new Pane();
    panel.setStyle("-fx-background-color: #FFFFFF;");
    Grafo grafo = new Grafo();
    grafo.cria_fase(1, panel);
    buttons.cria_nivel(1);
    bp.setCenter(panel);
    buttons.setMenu(bp);
    buttons.pressiona(panel, grafo);
    buttons.press_statis(grafo, panel);
    buttons.press_Exit();
    Scene scene = new Scene(bp, 800, 600);
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
  
}
