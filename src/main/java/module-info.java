module com.mycompany.n2_prog3_mateusalmeida {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.n2_prog3_mateusalmeida to javafx.fxml;
    exports com.mycompany.n2_prog3_mateusalmeida;
}
