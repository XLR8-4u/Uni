package org.openjfx;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        Risikoverwaltung r = new Risikoverwaltung();
        r.start(stage);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
