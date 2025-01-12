module pl.polsl.calculator {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires lombok;

    opens pl.polsl.controller to javafx.fxml;
    
    exports pl.polsl.calculator;
    exports pl.polsl.controller;
    exports pl.polsl.model;
    
}
