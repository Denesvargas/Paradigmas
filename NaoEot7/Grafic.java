import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;


public class Grafic {
  final private VBox vbox = new VBox();
  final private Label lb = new Label();
  final private PieChart chart = new PieChart();
  
  Grafic (BorderPane bp){
    lb.setFont(new Font("Arial", 16));
    addToVbox(vbox);
    bp.setLeft(vbox);
  }
  
  public void addInfo(int nMov, int nTotal){
    ObservableList<PieChart.Data> pieChartData =
    
    FXCollections.observableArrayList(
      new PieChart.Data("Parados", nMov - nTotal),
      new PieChart.Data("Em movimento", nMov));
    
    chart.setTitle("Ônibus em Circulação");
    chart.setData(pieChartData);
  }
  
  public void addToVbox(VBox vbox){
    vbox.applyCss();
    vbox.layout();
    vbox.setSpacing(5);
    vbox.setPadding(new Insets(10, 10, 10, 10));
    vbox.getChildren().addAll(lb, chart);
  }
}
