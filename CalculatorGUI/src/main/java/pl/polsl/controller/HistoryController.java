/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pl.polsl.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import pl.polsl.model.CalculationData;
import pl.polsl.calculator.App;
import pl.polsl.model.HistoryModel;

/**
 * FXML Controller class
 *
 * @author mdw18
 */
public class HistoryController  {

    private HistoryModel historyModel;
    private final ObservableList<CalculationData> data;   
    @FXML
    private TableView<CalculationData> table;
    @FXML
    private TableColumn<CalculationData, Double> firstNumberColumn;
    @FXML
    private TableColumn<CalculationData, String> operatorColumn;
    @FXML
    private TableColumn<CalculationData, Double> secondNumberColumn;
    @FXML
    private TableColumn<CalculationData, Double> resultColumn;
    @FXML
    private Button calculatorButton;
    @FXML
    private Button additionButton;
    @FXML
    private Button subtractionButton;
    @FXML
    private Button multiplicationButton;
    @FXML
    private Button divisionButton;

    public HistoryController(HistoryModel historyModel){
        this.historyModel = historyModel;
        data = FXCollections.observableArrayList(historyModel.getHistory());
    }
 
    public void initialize() {
        table.setItems(data);
         firstNumberColumn.setCellValueFactory(cellData -> 
            new SimpleDoubleProperty(cellData.getValue().firstNumber()).asObject());
        operatorColumn.setCellValueFactory(cellData -> 
            new SimpleStringProperty(cellData.getValue().operator()));
        secondNumberColumn.setCellValueFactory(cellData -> 
            new SimpleDoubleProperty(cellData.getValue().secondNumber()).asObject());
        resultColumn.setCellValueFactory(cellData -> 
            new SimpleDoubleProperty(cellData.getValue().result()).asObject());
    }

    @FXML
    private void backToCalculator(ActionEvent event) throws IOException {
          App.setRoot("/pl/polsl/view/CalculatorView");
    }

    @FXML
    private void filterResults(ActionEvent event) {
    }

}
