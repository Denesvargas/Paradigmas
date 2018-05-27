import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class ButtonTop {
  Button cb = new Button("Circle");
  Button lb = new Button("Line");  
  
  public void setPane(BorderPane bp){
    ArrayList<Button> buttons = new ArrayList();
    buttons.add(cb);
    buttons.add(lb);
    HBox box = new HBox();
    box.setSpacing(10);
    box.setAlignment(Pos.CENTER);
    box.setPadding(new Insets(5,5,5,5));
    box.setStyle("-fx-background-color: #00008B;");
    box.getChildren().addAll(buttons);
    bp.setTop(box);
  }
  
  public void pressiona(Pane panel){
    cb.setOnMousePressed((MouseEvent e) -> {
      Desenha circulo = new Desenha();
      circulo.desenha(1, panel);
    });
    lb.setOnMousePressed((MouseEvent e) -> {
      Desenha linha = new Desenha();
      linha.desenha(2, panel);
    });
  }  
}
