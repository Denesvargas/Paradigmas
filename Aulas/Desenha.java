import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class Desenha {
  public Circle c;
  public Line l;
  int tipo = 0;
  
  public void desenha(int t,Pane panel){
    tipo = t;
    panel.setOnMousePressed((MouseEvent e)-> {
      if(tipo == 1){
        c = new Circle(e.getX(), e.getY(), 1, Color.RED);
        panel.getChildren().add(c);
      }
      else if(tipo == 2){
        l = new Line(e.getX(), e.getY(), e.getX(), e.getY());
        panel.getChildren().add(l);
      }
    });

    panel.setOnMouseDragged((MouseEvent e) -> {
      if(tipo == 1)
        c.setRadius(Math.sqrt(Math.pow(c.getCenterX()-e.getX(),2)+Math.pow(c.getCenterY()-e.getY(),2)));
      else if(tipo == 2){
        l.setEndX(e.getX());
        l.setEndY(e.getY());
      }
    });
  }
}
