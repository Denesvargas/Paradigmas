import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class Menus {
  private Button vb = new Button("Verificar");
  private Button sb = new Button("Sair");
  private HBox box = new HBox();
  public int nivel;
  
  public void setMenu(BorderPane bp){
    editHboxTop();
    bp.setTop(box);
  }
 
  public void editHboxTop(){
    box.setSpacing(10);
    box.setPadding(new Insets(5,5,5,5));
    box.setStyle("-fx-background-color: #00008B;");
    box.setAlignment(Pos.CENTER);
    box.getChildren().add(vb);
    box.getChildren().add(sb);
  }

  public void pressiona(Pane panel, Grafo grafo){
    Move format = new Move();  
    format.move(panel, grafo);
  }
  
  public void press_statis(Grafo grafo, Pane panel){
    vb.setOnMousePressed((MouseEvent e) -> {
      Alert alert = new Alert(AlertType.INFORMATION);
      if(grafo.numintersec() > 0){
        alert.setTitle("Atenção");
        alert.setHeaderText(null);
        alert.setContentText("Nivel Ainda nao completo, restam " + grafo.numintersec() + " interseções.");
      }
      else{
        alert.setTitle("Parabéns");
        alert.setHeaderText(null);
        alert.setContentText("Nível concluido.");
        grafo.clear();
        panel.getChildren().clear();
        nivel = nivel + 1;
        grafo.cria_fase(nivel, panel);
        
      }
      alert.showAndWait();
    });
  }
  
  public void press_Exit(){
    sb.setOnAction((ActionEvent e) -> {
      Alert alert = new Alert(AlertType.CONFIRMATION);
      alert.setTitle("Sair");
      alert.setHeaderText("Sair :/");
      alert.setContentText("Tem certeza de que realmente deseja sair?");
      Optional<ButtonType> result = alert.showAndWait();
      if(result.get() == ButtonType.OK){
        System.exit(0);
      }
    });
  }
  
  public void cria_nivel(int fase){
    nivel = fase;
  }
}
