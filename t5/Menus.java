package javafxapplication1;

import java.util.Optional;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class Menus {
  private Button gb = new Button("Grafo");
  private Button ab = new Button("Aresta");
  private Button ng = new Button("Novo Grafo");
  private Button estb = new Button("Estatísticas");
  private Button svgb = new Button("Salvar em SVG");
  private Button sb = new Button("Sair");
  private ComboBox combob = new ComboBox();
  private Slider sl = new Slider();
  private ColorPicker cp = new ColorPicker();
  private HBox box = new HBox();
  private VBox vbox = new VBox();
  
  public void setMenu(BorderPane bp){
    vbox.getChildren().addAll(gb, ab);
    editSlider();
    editHboxLeft();
    editHboxTop();
    bp.setLeft(vbox);
    bp.setTop(box);
  }
  
  public void editHboxLeft(){
    vbox.setSpacing(10);
    vbox.setPadding(new Insets(5,5,5,5));
    vbox.setStyle("-fx-background-color: #00008B;");
    cp.setMaxWidth(60);
    gb.setMaxWidth(80);
    ab.setMaxWidth(80);
    vbox.getChildren().add(cp);
    vbox.getChildren().add(sl);
  }
 
  public void editHboxTop(){
    box.setSpacing(10);
    box.setPadding(new Insets(5,5,5,5));
    box.setStyle("-fx-background-color: #00008B;");
    box.getChildren().add(ng);
    box.getChildren().add(estb);
    box.getChildren().add(svgb);
    box.getChildren().add(sb);
  }
  public void editSlider(){
    sl.setMin(5);
    sl.setMax(50);
    sl.setValue(15);
    sl.setShowTickLabels(true);
    sl.setShowTickMarks(true);
    sl.setMinorTickCount(5);
    sl.setOrientation(Orientation.VERTICAL);
  }
  
  public void pressiona(Pane panel, Grafo lnos, Aresta lline){
    Desenha format = new Desenha();
    gb.setOnMousePressed((MouseEvent e) -> {
      format.desenha(1, panel, cp, lnos, lline);
    });
    ab.setOnMousePressed((MouseEvent e) -> {
      format.desenha(2, panel, cp, lnos, lline);
    });
    sl.valueProperty().addListener(new ChangeListener<Number>() {
      public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val){
        format.changeTam((double) new_val);
      }
    });
    ng.setOnMousePressed((MouseEvent e) -> {
      panel.getChildren().clear();
      lnos.clear();
      lline.clear();
    });
    estb.setOnMousePressed((MouseEvent e) -> {
      Alert alert = new Alert(AlertType.INFORMATION);
      alert.setTitle("Estatisticas");
      alert.setHeaderText(null);
      alert.setContentText("Numero de Vertices: " + lnos.num_elem() + "\nNumero de arestas: " 
        + lline.num_elem() + "\nNumero de arestas sobrepostas: " + lline.numintersec());
      alert.showAndWait();
    });
    svgb.setOnAction((ActionEvent e) -> {
        TextInputDialog dialog = new TextInputDialog("grafo");
        dialog.setTitle("Salvar Grafo");
        dialog.setHeaderText("Salvar grafo em SVG");
        dialog.setContentText("Digite o nome do arquivo:");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            //lnos.saveSvg(result.get());
            //lline.saveSvg(result.get());
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Salvar");
            alert.setHeaderText(null);
            alert.setContentText(result.get() + ".html" + " salvo com sucesso.");
            alert.showAndWait();
        }
    });
    sb.setOnAction((ActionEvent e) -> {
      Alert alert = new Alert(AlertType.CONFIRMATION);
      alert.setTitle("Sair");
      alert.setHeaderText("Sair :/");
      alert.setContentText("Tem certeza de que realmente deseja sair?");
      Optional<ButtonType> result = alert.showAndWait();
      if(result.get() == ButtonType.OK){
        System.exit(0);
      }
    });
  }
  
}
