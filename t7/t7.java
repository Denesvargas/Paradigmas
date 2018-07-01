import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
  
public class t7 extends Application {
  
  public static void main(String[] args) {
    launch(args);
  }
  
  @Override
  public void start(Stage stage) {
    HBox hbox = new HBox();                               
    VBox vbox = new VBox();
    Grafic grafico = new Grafic(hbox);
    Table tabela = new Table(hbox);                      
    vbox.getChildren().add(hbox);
    BarGraficData bd = new BarGraficData(vbox);
    tabela.renewData(stage, grafico, bd);                       
    hbox.setStyle("-fx-background-color: #FFFFFF;");
    stage.setScene(new Scene(vbox, 1024, 720));
    stage.show();  
  } 
}
