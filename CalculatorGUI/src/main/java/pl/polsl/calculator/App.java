package pl.polsl.calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import pl.polsl.controller.CalculatorController;
import pl.polsl.model.CalculatorModel;
import pl.polsl.model.HistoryModel;
import pl.polsl.controller.HistoryController;
import pl.polsl.model.CalculationData;


/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static CalculatorModel calculatorModel;
    private static CalculatorController calculatorController;
    private static HistoryModel historyModel;
    private static HistoryController historyController;
    
    @Override
    public void start(Stage stage) throws IOException {
        loadFXML("/pl/polsl/view/CalculatorView");
        scene = new Scene(loadFXML("/pl/polsl/view/HistoryView"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

     public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
          FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        fxmlLoader.setControllerFactory(param -> {
            if (param == CalculatorController.class) {
                return new CalculatorController(calculatorModel);
            } else if (param == HistoryController.class) {
                return new HistoryController(historyModel);
            } else {
                throw new IllegalArgumentException("Nieznany kontroler: " + param);
            }
        }); return fxmlLoader.load();
    }

    public static void main(String[] args) {
        historyModel = new HistoryModel();
        
        historyModel.add(new CalculationData(1,"+",1,2));
        historyModel.add(new CalculationData(1,"-",1,0));
        historyModel.add(new CalculationData(1,"*",5,5));
        historyModel.add(new CalculationData(22,"+",1,23));
        historyModel.add(new CalculationData(2,"/",2,1));
        
        historyController = new HistoryController(historyModel);
        calculatorModel = new CalculatorModel();
        calculatorController = new CalculatorController(calculatorModel);
        launch();
    }

}