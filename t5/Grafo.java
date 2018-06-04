
package javafxapplication1;

import java.awt.geom.Line2D;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

class Aresta{
  public ArrayList<Line> lline = new ArrayList();
  
  public void add_line(Line l){
    for(int i = 0; i < lline.size(); i++){
      if(same_pointIni(l, lline.get(i)) && same_pointFim(l, lline.get(i)) && same_pointIniFim(l, lline.get(i)))
          return;
    }
    lline.add(l);
  }
  
  public int numintersec(){
    int n = 0;
    for(int i = 0; i < lline.size(); i++){
      for(int j = i+1; j < lline.size(); j++){
        if(other_point(lline.get(i), lline.get(j)))
          if(Line2D.linesIntersect(lline.get(i).getStartX(), lline.get(i).getStartY(), lline.get(i).getEndX(),
            lline.get(i).getEndY(),lline.get(j).getStartX(), lline.get(j).getStartY(), lline.get(j).getEndX(),
            lline.get(j).getEndY()))
            n++;
      }
    }
    return n;
  }
  
  public boolean same_pointIni(Line line, Line line2){
    return (line.getStartX() == line2.getStartX() && line.getStartY() == line2.getStartY());
  }
  
  public boolean same_pointFim(Line line, Line line2){
    return ((line.getEndX() == line2.getEndX() && line.getEndY() == line2.getEndY()));
  }
  
  public boolean same_pointIniFim(Line line, Line line2){
    return (line.getStartX() != line2.getEndX() && line.getStartY() != line2.getEndY());
  }
  
  public boolean other_point(Line line, Line line2){
    if(!same_pointIni(line, line2))
      if(!same_pointFim(line,line2))
        if(same_pointIniFim(line, line2))
          if(same_pointIniFim(line2, line))
            return true;
    return false;
  }
  
  public void clear(){
    lline.clear();
  }
  
  public int num_elem(){
    return lline.size();
  }
} 

public class Grafo {
  public ArrayList<Circle> lno = new ArrayList();
  
  public void add_circle(Circle c){
    lno.add(c);
  }
  
  public Circle get_circle(int ind){
    return  lno.get(ind);
  }
  
  public int sobre_circ(double x, double y){
    for(int i = 0; i < lno.size(); i++){
      if(lno.get(i).contains(x, y)){
        return i;
      }
    }
    return -1;
  }
  
  public double posX(int ind){
    return lno.get(ind).getCenterX();
  }
  
  public double posY(int ind){
    return lno.get(ind).getCenterY();
  }
  
  public void clear(){
    lno.clear();
  }
  
  public int num_elem(){
    return lno.size();
  }
  public void saveSvg(String fileName){
      
  }
}
