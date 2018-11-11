/*
 * NICOLAS TEST PROGRAM FOR GRAPHING FUNCTIONS
 */
package chartline;

import java.util.ArrayList;
import java.util.Map;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
 
/**
 * A chart in which lines connect a series of data points. Useful for viewing
 * data trends over time.
 *
 * @see javafx.scene.chart.LineChart
 * @see javafx.scene.chart.Chart
 * @see javafx.scene.chart.Axis
 * @see javafx.scene.chart.NumberAxis
 * @related charts/area/AreaChart
 * @related charts/scatter/ScatterChart
 */
public class NNChartLine extends Application {
 
    private void init(Stage primaryStage) {
        Group root = new Group();
        primaryStage.setScene(new Scene(root));
        NumberAxis xAxis = new NumberAxis("Values for X-Axis", -3., 3, 1);
        NumberAxis yAxis = new NumberAxis("Values for Y-Axis", -5., 5., 1);
          ArrayList<XYChart.Data<Double,Double>> xy = new ArrayList<XYChart.Data<Double,Double>>();
        double yy[] = new double[10];
        int i = 0;
        for (double x = -2.0; x<2.0; x+= 0.01) {
            // HERE IS THE FUNCTION
            Double f = Math.pow(x,3.0) - 3.0*Math.pow(x,2.0) + 2.0*x + 1.0 ;
             xy.add(new XYChart.Data<Double,Double>(x,f));
        }
        // THIS FIRST SERIES IS JUST LEFT AS AN EXAMPLE
        ObservableList<XYChart.Series<Double,Double>> lineChartData = FXCollections.observableArrayList(
            new LineChart.Series<Double,Double>("Series 1", FXCollections.observableArrayList(
                new XYChart.Data<Double,Double>(0.0, 1.0),
                new XYChart.Data<Double,Double>(1.2, 1.4),
                new XYChart.Data<Double,Double>(2.2, 1.9),
                new XYChart.Data<Double,Double>(2.7, 2.3),
                new XYChart.Data<Double,Double>(2.9, 0.5)
            )),
                
                // THIS PLOT YOUR FUNCTION
            new LineChart.Series<Double,Double>("Series 3", FXCollections.observableArrayList(xy))


                /*,                
            new LineChart.Series<Double,Double>("Series 2", FXCollections.observableArrayList(
                new XYChart.Data<Double,Double>(0.0, 1.6),
                new XYChart.Data<Double,Double>(0.8, 0.4),
                new XYChart.Data<Double,Double>(1.4, 2.9),
                new XYChart.Data<Double,Double>(2.1, 1.3),
                new XYChart.Data<Double,Double>(2.6, 0.9)
            ))*/
        );
        LineChart chart = new LineChart(xAxis, yAxis, lineChartData);
        root.getChildren().add(chart);
    }

    public NNChartLine() {
    }
 
    @Override public void start(Stage primaryStage) throws Exception {
        init(primaryStage);
        primaryStage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX 
     * application. main() serves only as fallback in case the 
     * application can not be launched through deployment artifacts,
     * e.g., in IDEs with limited FX support. NetBeans ignores main().
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}