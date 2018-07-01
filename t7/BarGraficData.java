import java.util.ArrayList;
import javafx.geometry.Side;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;

public class BarGraficData {
  private ArrayList<String> linhas = new ArrayList();
  private CategoryAxis xAxis = new CategoryAxis();
  private NumberAxis yAxis = new NumberAxis();
  BarChart<String,Number> bc = new BarChart<String,Number>(xAxis,yAxis);
  XYChart.Series serie;
  
  BarGraficData(VBox vbox){
    xAxis.setLabel("Linha");     
    yAxis.setLabel("Quantidade");
    bc.setLegendSide(Side.TOP);
    vbox.getChildren().add(bc);
  }
  
  public boolean noInList(String linha){
    for(String s: linhas){
      if(String.valueOf(s).compareTo(linha) == 0)
        return false;
    }
    linhas.add(linha);
    return true;
  }
  
  public ArrayList<String> getLinhas(){
    return linhas;
  }
  
  public void add(String linha, int tamLinha){
    if(tamLinha > 0)
      serie.getData().add(new XYChart.Data(linha, tamLinha));
  }
  
  public void clearData(){
    linhas.clear();
    serie = new XYChart.Series();
    serie.setName("Ônibus por linha");
    bc.getData().clear();
    bc.getData().add(serie);
  }
}
