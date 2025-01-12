/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mdw18
 */
public class HistoryModel {
       private List<CalculationData> history;
        
        public HistoryModel(){
            history = new ArrayList<>();
        }
        
        public void add(CalculationData data){
            history.add(data);
        }
        
        public List<CalculationData> getHistory(){
            return history;
        }
}
