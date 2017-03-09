package uni.bilkent.hai.graph.GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import uni.bilkent.hai.graph.Graph;

import java.util.Locale;

/**
 * Created by deniz on 09/03/17.
 */
public class Main extends Application
{
    public void start(Stage stage) {

        Locale.setDefault( new Locale( "en", "US"));

        stage.setTitle("aaaa");

        Scene scene = new Scene( new Graph());

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
