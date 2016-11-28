package org.uma.jmetal.workingTest;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class ScatterPlot extends Application {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override public void start(Stage stage) {
        stage.setTitle("Product - Service Package");
        final NumberAxis xAxis = new NumberAxis(0, 30, 2);
        final NumberAxis yAxis = new NumberAxis(0,  120, 5);        
        final ScatterChart<Number,Number> sc = new ScatterChart<>(xAxis,yAxis);
        xAxis.setLabel("Service Cost (RM)");                
        yAxis.setLabel("Product Cost (RM)");
        sc.setTitle("Product - Service Package");
       
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("0.9");
        series1.getData().add(new XYChart.Data(10.15,125,14));
        series1.getData().add(new XYChart.Data(12.42,100.52));
        series1.getData().add(new XYChart.Data(12.44,80.21));
        series1.getData().add(new XYChart.Data(21.17,79.80));
//        series1.getData().add(new XYChart.Data(20.88,21.88));
//        series1.getData().add(new XYChart.Data(15.40,33.29));
//        series1.getData().add(new XYChart.Data(14.73,103.31));
//        series1.getData().add(new XYChart.Data(51.41,43.21));
//        series1.getData().add(new XYChart.Data(17.66,56.71));
//        series1.getData().add(new XYChart.Data(12.05,160.73));
//        series1.getData().add(new XYChart.Data(16.25,74.78));
        
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("0.8");
        series2.getData().add(new XYChart.Data(9.6, 125.32));
        series2.getData().add(new XYChart.Data(17.17,92.20));
        series2.getData().add(new XYChart.Data(12.36,93.68));
        series2.getData().add(new XYChart.Data(18.29,77.36));
        series2.getData().add(new XYChart.Data(17.75,84.89));
        series2.getData().add(new XYChart.Data(8.75,140.42));
//        series2.getData().add(new XYChart.Data(18.35,47.88));
//        series2.getData().add(new XYChart.Data(20.08,46.17));
//        series2.getData().add(new XYChart.Data(26.46,42.16));
//        series2.getData().add(new XYChart.Data(15.18,182.02));
//        series2.getData().add(new XYChart.Data(25.24, 43.87));
//        series2.getData().add(new XYChart.Data(18.15,80.89));
//        series2.getData().add(new XYChart.Data(15.23,144.48));
//        
//        
//        
      XYChart.Series series3 = new XYChart.Series();
      series3.setName("0.7");
      series3.getData().add(new XYChart.Data(10.0,131.75));
      series3.getData().add(new XYChart.Data(12.81,94.17));
      series3.getData().add(new XYChart.Data( 24.97, 91.8));
      series3.getData().add(new XYChart.Data (11.46,117.46));
//      series3.getData().add(new XYChart.Data(57.89,49));
//        series3.getData().add(new XYChart.Data(15.82,72.58));
//        series3.getData().add(new XYChart.Data(13.56,46.79));
//        series3.getData().add(new XYChart.Data(15.82, 88.66));
//      series3.getData().add(new XYChart.Data(15.79,73.56));
//       series3.getData().add(new XYChart.Data(18.30, 47.90));
//        
        sc.getData().addAll(series1,series2, series3);
        Scene scene  = new Scene(sc, 500, 400);
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}
