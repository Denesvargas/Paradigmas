package javafxapplication1;

import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class Desenha {
  public Circle c = new Circle();
  public Line l = new Line();
  public Rectangle rt = new Rectangle();
  int tipo = 0;
  
  public void desenha(int t, Pane panel, ColorPicker cor){
    tipo = t;
    panel.setOnMousePressed((MouseEvent e)-> {
      if(tipo == 1){
        c = new Circle(e.getX(), e.getY(), 15, cor.getValue());
        panel.getChildren().add(c);
      }
      else if(tipo == 2){
        l = new Line(e.getX(), e.getY(), e.getX(), e.getY());
        l.setFill(cor.getValue());
        panel.getChildren().add(l);
      }
      else if(tipo == 3){
        rt = new Rectangle(e.getX() - 14, e.getY()-14, 28, 28);
        rt.setFill(cor.getValue());
        panel.getChildren().add(rt);
      }
    });

    panel.setOnMouseDragged((MouseEvent e) -> {
      if(tipo == 2){
        l.setEndX(e.getX());
        l.setEndY(e.getY());
      }
    });
  }
}
