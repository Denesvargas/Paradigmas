package javafxapplication1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Editor extends Application {
  
  @Override
  public void start(Stage stage) {
    stage.setTitle("Editor de Grafos");
    BorderPane bp = new BorderPane();
    Menus buttons = new Menus();
    Pane panel = new Pane();
    panel.setStyle("-fx-background-color: #FFFFFF;");
    Grafo grafo = new Grafo();
    bp.setCenter(panel);
    buttons.setMenu(bp);
    buttons.pressiona(panel, grafo);
    buttons.press_newGraph(panel, grafo);
    buttons.press_statis(grafo);
    buttons.press_save(stage, grafo);
    buttons.press_Exit();
    Scene scene = new Scene(bp, 600, 500);
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
  
}
