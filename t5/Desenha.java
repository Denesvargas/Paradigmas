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
  int tipo = 1;
  int ind_noIni = -1;
  double tam = 15;
  
  public void desenha(int t, Pane panel, ColorPicker cor, Grafo lnos, Aresta lline){
    tipo = t;
    panel.setOnMousePressed((MouseEvent e)-> {
      if(tipo == 1){
        c = new Circle(e.getX(), e.getY(), tam, cor.getValue());
        lnos.add_circle(c);
        panel.getChildren().add(c);
      }
      else if(tipo == 2){
        ind_noIni = lnos.sobre_circ(e.getX(), e.getY());
        if(ind_noIni != -1){
          l = new Line(lnos.posX(ind_noIni), lnos.posY(ind_noIni),lnos.posX(ind_noIni), lnos.posY(ind_noIni));
          panel.getChildren().add(l);
        }
      }
    });
    panel.setOnMouseDragged((MouseEvent e) -> {
      if(tipo == 2){
        int ind_noFim = lnos.sobre_circ(e.getX(), e.getY());
        if(ind_noFim != ind_noIni && ind_noFim != -1){
          l.setEndX(lnos.posX(ind_noFim));
          l.setEndY(lnos.posY(ind_noFim));
          l.setStrokeWidth(tam/10);
          l.setStroke(cor.getValue()); 
          Circle temp = lnos.get_circle(ind_noFim);
          c = new Circle(temp.getCenterX(), temp.getCenterY(), temp.getRadius(), temp.getFill());
          c.setStroke(temp.getStroke());
        }
        else if(ind_noIni != -1){
          l.setEndX(lnos.posX(ind_noIni));
          l.setEndY(lnos.posY(ind_noIni));
        }
      }
    });
    panel.setOnMouseReleased((MouseEvent e) -> {
      if(tipo == 2){
        if(l.getStartX() != l.getEndX() && l.getStartY() != l.getEndY())
          lline.add_line(l);
      }
    });
  }
  public void changeTam(double t){
    tam = t;
  }
}
