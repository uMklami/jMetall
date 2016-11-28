package org.uma.jmetal.workingTest;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class LineGraphMain extends Application {
	Map<String, Set<Double>> objectives;
	public void setData(Map<String, Set<Double>> map){
    	objectives = map;
    }
    @Override public void start(Stage stage) {
        stage.setTitle("Graph");
        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("x axis label");
        //creating the chart
        final LineChart<Number,Number> lineChart = 
                new LineChart<Number,Number>(xAxis,yAxis);
                
        lineChart.setTitle("Service Package Graph");
        
        for (Map.Entry<String, Set<Double>> entry : objectives.entrySet()) {
        	XYChart.Series series = new XYChart.Series();
        	series.setName(entry.getKey().toString());
            Set<Double> value = entry.getValue();
            for(int i=0; i < value.size(); i++){
            	
            }
            
        }
        

        XYChart.Series series = new XYChart.Series();
        series.setName("device");
        series.getData().add(new XYChart.Data(1, 23));
        series.getData().add(new XYChart.Data(2, 14));
        series.getData().add(new XYChart.Data(3, 15));
        series.getData().add(new XYChart.Data(4, 24));
        series.getData().add(new XYChart.Data(5, 34));
        series.getData().add(new XYChart.Data(6, 36));
        series.getData().add(new XYChart.Data(7, 22));
        series.getData().add(new XYChart.Data(8, 45));
        series.getData().add(new XYChart.Data(9, 43));
        series.getData().add(new XYChart.Data(10, 17));
        series.getData().add(new XYChart.Data(11, 29));
        series.getData().add(new XYChart.Data(12, 25));
        
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("internet quota");
        series1.getData().add(new XYChart.Data(1, 13));
        series1.getData().add(new XYChart.Data(2, 24));
        series1.getData().add(new XYChart.Data(3, 35));
        series1.getData().add(new XYChart.Data(4, 14));
        series1.getData().add(new XYChart.Data(5, 17));
        series1.getData().add(new XYChart.Data(6, 28));
        series1.getData().add(new XYChart.Data(7, 23));
        series1.getData().add(new XYChart.Data(8, 14));
        series1.getData().add(new XYChart.Data(9, 15));
        series1.getData().add(new XYChart.Data(10, 24));
        series1.getData().add(new XYChart.Data(11, 34));
        
        XYChart.Series series12 = new XYChart.Series();
        series12.setName("retail price");
        series12.getData().add(new XYChart.Data(1, 11));
        series12.getData().add(new XYChart.Data(2, 21));
        series12.getData().add(new XYChart.Data(3, 31));
        series12.getData().add(new XYChart.Data(4, 11));
        series12.getData().add(new XYChart.Data(5, 13));
        series12.getData().add(new XYChart.Data(6, 15));
        series12.getData().add(new XYChart.Data(7, 17));
        series12.getData().add(new XYChart.Data(8, 19));
        series12.getData().add(new XYChart.Data(9, 20));
        series12.getData().add(new XYChart.Data(10, 24));
        series12.getData().add(new XYChart.Data(11, 26));
        
        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().addAll(series, series1,series12);
       
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}