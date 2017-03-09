package uni.bilkent.hai.graph;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.scene.Parent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Screen;
import netscape.javascript.JSObject;

public class Graph extends Parent {

    //####################### Instance variables #######################
    private JSObject doc;
    private WebView webView;
    private WebEngine webEngine;
    private boolean ready;

    //####################################################################

    /**
     * Constructor
     * Initiation of following methods
     * initMap() iniCommunication() getChildren().add(webView)
     */
    public Graph() {
        initMap();
        initCommunication();
        Screen screen = Screen.getPrimary();
        webView.setPrefSize(screen.getBounds().getWidth(),screen.getBounds().getHeight() - 100);
        getChildren().add(webView); // Will be change as JavaFx Elements change

      //  invokeJS("$('body').html(\"qwewqeqw\")s");
    }


    /**
     * Initialize the Map
     * Creates a webview which is for calling google map from html.
     **/
    private void initMap() {
        ready = false;

        //####################### Initialize Web View #######################
        webView = new WebView();
        webEngine = webView.getEngine();
        webEngine.setJavaScriptEnabled(true);
        webEngine.load(getClass().getResource("web/index.html").toExternalForm());
        webEngine.getLoadWorker().stateProperty().addListener(new ChangeListener<Worker.State>()
        {
            @Override
            public void changed(final ObservableValue<? extends Worker.State> observableValue,
                                final Worker.State oldState,
                                final Worker.State newState)
            {
                if (newState == Worker.State.SUCCEEDED)
                {
                    System.out.println("readyy");
                    ready = true;
                }
            }
        });
        //####################################################################

    }

    /**
     * Initialize Communication
     * Initialize communication between Java and Javascript
     * Define and send reference of this class
     * */
    private void initCommunication() {
        webEngine.getLoadWorker().stateProperty().addListener(new ChangeListener<Worker.State>()
        {
            @Override
            public void changed(final ObservableValue<? extends Worker.State> observableValue,
                                final Worker.State oldState,
                                final Worker.State newState)
            {
                if (newState == Worker.State.SUCCEEDED)
                {
                    doc = (JSObject) webEngine.executeScript("window");
                    doc.setMember("app", Graph.this); // Set app variable into Javascript code which is referring to this class
                }
            }
        });
    }

    /**
     * Invoke Javascript
     * Invoke javascript code in the our map view. Eval javascript.
     * @param jsCode javascript code
     * */
    private void invokeJS(final String jsCode) {
        if(ready) {
            // If initialize succeeded
            doc.eval(jsCode); // Add and run the script
        }
        else {
            // Check again, If everything is ok, eval the script
            webEngine.getLoadWorker().stateProperty().addListener(new ChangeListener<Worker.State>()
            {
                @Override
                public void changed(final ObservableValue<? extends Worker.State> observableValue,
                                    final Worker.State oldState,
                                    final Worker.State newState)
                {
                    if (newState == Worker.State.SUCCEEDED)
                    {
                        doc.eval(jsCode); // Add and run the script
                    }
                }
            });
        }
    }

}