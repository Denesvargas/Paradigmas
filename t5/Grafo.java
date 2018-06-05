import java.awt.geom.Line2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class Grafo {
  public ArrayList<Circle> lno = new ArrayList();
  public ArrayList<Line> lline = new ArrayList();
  
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
  
  public int makeSvg(File file) throws FileNotFoundException{
    PrintWriter pw = new PrintWriter(file);
    double width = 0, height = 0;
    for(int i = 0 ; i < lno.size(); i++) {
      if (lno.get(i).getCenterX() > width) 
        width = lno.get(i).getCenterX();
      if (lno.get(i).getCenterY() > height)
        height = lno.get(i).getCenterY();
    }
    width += 100; height += 100;
    pw.println("<svg height=\"" + height + "\" width=\"" + width + "\">");
    for (int i = 0; i < lline.size(); i++) {
      pw.print("  <line x1=\""+ lline.get(i).getStartX()+"\" y1=\"" + lline.get(i).getStartY()+
        "\" x2=\""+lline.get(i).getEndX()+"\" y2=\""+lline.get(i).getEndY() + "\" ");
      pw.print("style=\"stroke:" + getCorHex((Color) lline.get(i).getStroke()));
      pw.println(";stroke-width:"+ (lline.get(i).getStrokeWidth())+ "\" />");
    }
    for (int i = 0; i < lno.size(); i++) {
      double x = lno.get(i).getCenterX();
      double y = lno.get(i).getCenterY();
      double shapeSize = lno.get(i).getRadius();
      pw.println("  <circle id=\"" + i + "\" cx=\"" + x + "\" cy=\"" + y + "\" r=\"" + shapeSize + 
        "\" fill=\"" + getCorHex((Color) lno.get(i).getFill()) + "\" />");
    }
    pw.println("</svg>");
    pw.close();
    return 0;
  }
  
  public String getCorHex(Color cor) {
    return String.format("#%02X%02X%02X", (int)(cor.getRed() * 255), (int)(cor.getGreen() * 255), (int)(cor.getBlue() * 255));
  }
}
