module com.mycompany.tipcalculator {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.tipcalculator to javafx.fxml;
    exports com.mycompany.tipcalculator;
}
