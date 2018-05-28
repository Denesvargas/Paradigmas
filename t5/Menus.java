package javafxapplication1;

import java.util.ArrayList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class Menus {
  Button gb = new Button("Grafo");
  Button ab = new Button("Aresta");
  ComboBox combob = new ComboBox();
  ColorPicker cp = new ColorPicker();
  
  public void setMenu(BorderPane bp){
    combob.getItems().addAll(
                "Circle",
                "Square");
    ArrayList<Button> buttons = new ArrayList();
    buttons.add(gb);
    buttons.add(ab);
    HBox box = new HBox();
    box.setSpacing(10);
    box.setAlignment(Pos.CENTER);
    box.setPadding(new Insets(5,5,5,5));
    box.setStyle("-fx-background-color: #00008B;");
    box.getChildren().addAll(buttons);
    box.getChildren().add(combob);
    box.getChildren().add(cp);
    bp.setTop(box);
  }
  
  public void pressiona(Pane panel){
    System.out.println("pressiona");
    Desenha format = new Desenha();
    gb.setOnMousePressed((MouseEvent e) -> {
      if(combob.getValue() == "Circle")
        format.desenha(1, panel, cp);
      else if(combob.getValue() == "Square")        
        format.desenha(3, panel, cp);
    });
    
    ab.setOnMousePressed((MouseEvent e) -> {
      format.desenha(2, panel, cp);
    });
    combob.valueProperty().addListener(new ChangeListener<String>(){
      public void changed(ObservableValue ov, String ant, String atual){
        if(atual == "Circle")
          format.desenha(1, panel, cp);
        else if(atual == "Square")
          format.desenha(3, panel, cp);
      }
    });
  }
}
