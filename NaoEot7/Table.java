import java.util.List;
import java.util.Map;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;


public class Table {
  final private Label label = new Label("Dados da frota de ônibus do Rio de Janeiro");
  final private Label labelLeg;
  final private TableView<TableData> table = new TableView<TableData>();
  final private ObservableList<TableData> data = FXCollections.observableArrayList();
  final private BorderPane legTabel = new BorderPane();
  final private Button btn = new Button("Atualizar dados");
  private HttpJSONService http = new HttpJSONService();
  private List<List> jsondata;
  private int ntotal = 0;
  private int nMov = 0; 
  
  Table(VBox vbox){
    label.setFont(new Font("Arial", 20));
    labelLeg = new Label("Total de Ônibus: " + ntotal);
    defineColumns();
    table.setItems(data);
    legTabel.setLeft(btn);
    legTabel.setRight(labelLeg);
    addToVbox(vbox);
  }
  
  public void renewData(Grafic grafico){
    btn.setOnAction(ev -> {
      Map json = null;
      try {
        json = http.sendGet("http://dadosabertos.rio.rj.gov.br/apiTransporte/apresentacao/rest/index.cfm/obterTodasPosicoes");
      } catch (Exception e) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText("Connection failed");
        alert.setContentText("Please check your Internet connection!");
        alert.showAndWait();
      }
      if (json != null){
        ntotal = 0;
        nMov = 0;
        jsondata = (List) json.get("DATA");
        ntotal = jsondata.size();
        for(List o : jsondata){
          data.add(new TableData((List) o));
          double veloc = (double) o.get(5);
          if(veloc != 0)
            nMov += 1;
        }
        labelLeg.setText("Total de Ônibus: " + ntotal);
        grafico.addInfo(nMov, ntotal);
      }
    });
  }
  
  public void defineColumns(){
    TableColumn<TableData,String> dataCol = new TableColumn<TableData,String>("Data/Hora");
    dataCol.setCellValueFactory(cellData -> cellData.getValue().dataProperty());
    
    TableColumn<TableData,String> idCol = new TableColumn<TableData,String>("Id");
    idCol.setCellValueFactory(cellData -> cellData.getValue().idProperty());
    
    TableColumn<TableData,String> linhaCol = new TableColumn<TableData,String>("Linha");
    linhaCol.setCellValueFactory(cellData -> cellData.getValue().linhaProperty());
    
    TableColumn<TableData,String> LatCol = new TableColumn<TableData,String>("Latitude");
    LatCol.setCellValueFactory(cellData -> cellData.getValue().latProperty());
    
    TableColumn<TableData,String> longCol = new TableColumn<TableData,String>("Longitude");
    longCol.setCellValueFactory(cellData -> cellData.getValue().longiProperty());
    
    TableColumn<TableData,Number> velCol = new TableColumn<TableData,Number>("Velocidade");
    velCol.setCellValueFactory(cellData -> cellData.getValue().velProperty());
    
    table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    table.getColumns().add(dataCol);
    table.getColumns().add(idCol);
    table.getColumns().add(linhaCol);
    table.getColumns().add(LatCol);
    table.getColumns().add(longCol);
    table.getColumns().add(velCol);
  }
  
  public void addToVbox(VBox vbox){
    vbox.applyCss();
    vbox.layout();
    vbox.setSpacing(5);
    vbox.setPadding(new Insets(10, 10, 10, 10));
    vbox.getChildren().addAll(label, table, legTabel);
  }
}
