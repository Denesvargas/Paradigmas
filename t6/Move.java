import java.util.ArrayList;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;


public class Move {
  public boolean movendo = false;
  public int ind = -1;
  ArrayList<Integer> lposIni = new ArrayList();
  ArrayList<Integer> lposFim = new ArrayList();
  
  public void move(Pane panel, Grafo grafo){
    panel.setOnMousePressed((MouseEvent e)-> {
      ind = grafo.sobre_circ(e.getX(), e.getY());
      if(ind != -1){
        grafo.linhasIni(ind, lposIni);
        grafo.linhasFim(ind, lposFim);
        movendo = true;
      }
    });
    panel.setOnMouseDragged((MouseEvent e) -> {
      if(ind != -1 && movendo){
        grafo.setpos(ind , e.getX(), e.getY());
        grafo.setposLineIni(lposIni, e.getX(), e.getY());
        grafo.setposLineFim(lposFim, e.getX(), e.getY());
      }
    });
    panel.setOnMouseReleased((MouseEvent e) -> {
      if(movendo){
        lposIni.clear();
        lposFim.clear();
      }
      movendo = false;
      
    });
  }
}
