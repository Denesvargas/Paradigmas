package javafxapplication1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class JavaFXApplication1 extends Application {
  
  @Override
  public void start(Stage stage) {
    stage.setTitle("Editor de Grafos");
    BorderPane bp = new BorderPane();
    Menus buttons = new Menus();
    Pane panel = new Pane();
    bp.setCenter(panel);
    buttons.setMenu(bp);
    buttons.pressiona(panel);
    buttons.selecionaFormato();
    Scene scene = new Scene(bp, 600, 500);
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
  
}
