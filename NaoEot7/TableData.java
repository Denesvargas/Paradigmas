import java.util.List;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class TableData {
    private final SimpleStringProperty data;
    private final SimpleStringProperty id;
    private final SimpleStringProperty linha;
    private final SimpleStringProperty lat;
    private final SimpleStringProperty longi;
    private final SimpleDoubleProperty vel;
    private int total = 0;
    private int parados = 0;
    
    TableData(List data) {
      this.data = new SimpleStringProperty((String) data.get(0).toString());
      this.id = new SimpleStringProperty((String) data.get(1).toString());
      this.linha = new SimpleStringProperty((String) data.get(2).toString());
      this.lat = new SimpleStringProperty(String.valueOf(data.get(3)));
      this.longi = new SimpleStringProperty(String.valueOf(data.get(4)));
      this.vel = new SimpleDoubleProperty((double) data.get(5));
    }
    
    public void setinfo(List data){
      total = data.size();
      // parados = 
      // implementar
    }
    
    public SimpleStringProperty dataProperty() {
      return data;
    }
    public String getData() {
      return data.get();
    }
    public void setData(String jk) {
      this.data.set(jk);
    }
    public SimpleStringProperty idProperty() {
      return id;
    }
    public String getId() {
      return id.get();
    }
    public void setId(String id) {
      this.id.set(id);
    }
    public SimpleStringProperty linhaProperty() {
      return linha;
    }
    public String getLinha() {
      return linha.get();
    }
    public void setLinha(String jk) {
      this.linha.set(jk);
    }
    public SimpleStringProperty latProperty() {
      return lat;
    }
    public String getlat() {
      return lat.get();
    }
    public void setLat(String jk) {
      this.lat.set(jk);
    }
    public SimpleStringProperty longiProperty() {
      return longi;
    }
    public String getLongi() {
      return longi.get();
    }
    public void setLongi(String jk) {
      this.longi.set(jk);
    }
    public SimpleDoubleProperty velProperty() {
      return vel;
    }
    public double getVel() {
      return vel.get();
    }
    public void setVel(double jk) {
      this.vel.set(jk);
    }
 }
