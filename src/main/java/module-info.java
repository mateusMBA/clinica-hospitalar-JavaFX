module com.mycompany.n2_prog3_mateusalmeida {
    exports com.mycompany.n2_prog3_mateusalmeida.models;
    requires javafx.controls;
    requires javafx.fxml;
    opens com.mycompany.n2_prog3_mateusalmeida to javafx.fxml;
    opens com.mycompany.n2_prog3_mateusalmeida.models to java.xml.bind;
    exports com.mycompany.n2_prog3_mateusalmeida;
    requires org.apache.poi.poi;
    requires org.apache.poi.ooxml;
    requires org.json;
    requires java.xml.bind;
    requires java.activation;
}
