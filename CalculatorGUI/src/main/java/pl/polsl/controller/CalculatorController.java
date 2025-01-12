/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pl.polsl.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import pl.polsl.calculator.App;
import pl.polsl.model.CalculatorModel;

/**
 * FXML Controller class
 *
 * @author mdw18
 */
public class CalculatorController {

    private CalculatorModel calculatorModel;
    @FXML
    private TextField firstNumberField;
    @FXML
    private TextField secondNumberField;
    @FXML
    private TextField resultField;
    @FXML
    private Button calculateButton;
    @FXML
    private Button historyButton;
    @FXML
    private TextField operatorField;

    public CalculatorController(CalculatorModel calculatorModel){
        this.calculatorModel = calculatorModel;
    }
    /**
     * Initializes the controller class.
     */
     public void initialize() {
        // TODO
    }    

    @FXML
    private void calculation(ActionEvent event) {
    }

    @FXML
    private void goToHistory(ActionEvent event) throws IOException {
          App.setRoot("/pl/polsl/view/HistoryView");
    }
    
}
