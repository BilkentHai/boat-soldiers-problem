package uni.bilkent.hai;

import javafx.application.Application;
import javafx.scene.Scene;
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
