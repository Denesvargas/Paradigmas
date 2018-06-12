import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Random;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class Grafo {
  public ArrayList<Circle> lno = new ArrayList();
  public ArrayList<Line> lline = new ArrayList();
  
  public void cria_fase(int fase, Pane panel){
    int n = fase + 3;
    int vertices = (n*(n-1))/2;
    // numero maximo de arestas para um grafo planar narestas = n*(n-2)
    for(int i = 0; i < vertices; i++)
      criavertrandom();
    criarestrandom(vertices);
    while(numintersec() == 0 && vertices > 3){
      lno.clear();
      lline.clear();
      for(int i = 0; i < vertices; i++)
        criavertrandom();
      criarestrandom(vertices);
    }
    for(int i = 0; i < lno.size(); i++)
      panel.getChildren().add(lno.get(i));
    for(int i = 0; i < lline.size(); i++)
      panel.getChildren().add(lline.get(i));
  }
  
  public void criavertrandom(){
     Random gerador = new Random();
     double x = 750*gerador.nextDouble() + 25;
     double y = 500*gerador.nextDouble() + 25;
     Circle c = new Circle(x, y, 25, Color.RED);
     add_circle(c);
  }
  
  public void criarestrandom(int nvertices){
    if(nvertices > 2){
      Line li = new Line(posX(0), posY(0), posX(1), posY(1));
      add_line(li);
    }
    for(int i = 2; i < lno.size(); i++){
      Line l1 = new Line(posX(i-2), posY(i-2), posX(i), posY(i));
      Line l2 = new Line(posX(i-1), posY(i-1), posX(i), posY(i));
      add_line(l1);
      add_line(l2);
    }
  }
  
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
  
  public void setpos(int ind, double x, double y){
    lno.get(ind).setCenterX(x);
    lno.get(ind).setCenterY(y);
  }
  
  public void clear(){
    lno.clear();
    lline.clear();
  }
  
  public int size_no(){
    return lno.size();
  }
  
  public void add_line(Line l){
    for(int i = 0; i < lline.size(); i++){
      if(same_pointIni(l, lline.get(i)) && same_pointFim(l, lline.get(i)))
        return;
      else if(l.getStartX() == lline.get(i).getEndX() && l.getStartY() == lline.get(i).getEndY() &&
        l.getEndX() == lline.get(i).getStartX() && l.getEndY() == lline.get(i).getStartY())
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
  
  public int size_lines(){
    return lline.size();
  }
  
  public void linhasIni(int ind, ArrayList<Integer> linhasIni){
    for(int i = 0; i < lline.size(); i++){
      if(lline.get(i).getStartX() == posX(ind) && lline.get(i).getStartY() == posY(ind))
        linhasIni.add(i);
    }
  }
  
  public void linhasFim(int ind, ArrayList<Integer> linhasFim){
    for(int i = 0; i < lline.size(); i++){
      if(lline.get(i).getEndX() == posX(ind) && lline.get(i).getEndY() == posY(ind))
        linhasFim.add(i);
    }
  }
  
  public void setposLineIni(ArrayList<Integer> lposIni, double x, double y){
    for(int i = 0; i < lposIni.size(); i++){
      lline.get(lposIni.get(i)).setStartX(x);
      lline.get(lposIni.get(i)).setStartY(y);
    } 
  }
  
  public void setposLineFim(ArrayList<Integer> lposFim, double x, double y){
    for(int i = 0; i < lposFim.size(); i++){
      lline.get(lposFim.get(i)).setEndX(x);
      lline.get(lposFim.get(i)).setEndY(y);
    } 
  }
}
