import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
  
public class t7 extends Application {
  
  public static void main(String[] args) {
    launch(args);
  }
  
  @Override
  public void start(Stage stage) {
    BorderPane bp = new BorderPane(); // contem no centro a tabela e a esquerda o gráfico 
    VBox vbox = new VBox();             // contem todos os elementos da tabela
    Table tabela = new Table(vbox);     // tabela onde estão os dados listados e suas funções
    Grafic grafico = new Grafic(bp);    // grafico de pizza dos onibus em movimento
    tabela.renewData(grafico);                 // ação de atualizar os dados da tabela
    bp.setCenter(vbox);
    stage.setScene(new Scene(bp, 1000, 700));
    stage.show();  
  } 
}
