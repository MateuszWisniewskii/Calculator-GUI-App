module pl.polsl.calculator {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens pl.polsl.controller to javafx.fxml;
    exports pl.polsl.calculator;
}
