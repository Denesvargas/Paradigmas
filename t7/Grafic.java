import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;


public class Grafic {
  private VBox vbox = new VBox();
  private Label lbTitle = new Label();
  private PieChart chart = new PieChart();
  private ObservableList<PieChart.Data> pieChartData;
  private Label lastDateLb = new Label();
  private BorderPane bpTime = new BorderPane();
  private String time = "dia/mes/ano hora:min";
  private int nTotal = 0;
  private int nMov = 0;
  
  Grafic (HBox hbox){
    lbTitle.setFont(new Font("Arial", 16));
    lastDateLb.setText("Ultima atualzação: " + time);
    lastDateLb.setTextAlignment(TextAlignment.CENTER);
    lastDateLb.setAlignment(Pos.CENTER);
    bpTime.setCenter(lastDateLb);
    chart.setTitle("Ônibus em Circulação");
    addToVbox(vbox);
    refreshPie();
    hbox.getChildren().add(vbox);
  }
  
  public void addInfo(int nMov, int nTotal){
    this.nMov = nMov;
    this.nTotal = nTotal;
    refreshPie();
  }
  
  public void addToVbox(VBox vbox){
    vbox.applyCss();
    vbox.layout();
    vbox.setSpacing(5);
    vbox.setPadding(new Insets(10, 10, 10, 10));
    vbox.getChildren().addAll(lbTitle, chart, bpTime);
  }
  
  public void refreshPie(){
    pieChartData = FXCollections.observableArrayList(
      new PieChart.Data("Parados", nTotal - nMov),
      new PieChart.Data("Em movimento", nMov));
    
    chart.setData(pieChartData);
  }
  
  public void refreshTime(){
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    time = sdf.format(new Date());
    lastDateLb.setText("Ultima atualzação: " + time);
  }
}
