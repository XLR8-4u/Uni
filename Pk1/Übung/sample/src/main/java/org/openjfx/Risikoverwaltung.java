package org.openjfx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Risikoverwaltung extends Application {

	@Override
	public void start(Stage stage) {
		Risikoerfassung re = new Risikoerfassung(new Risiko(), stage);
		re.show();

		stage.setScene(new Scene(new Label("Hallo")));
		Extrem e = new Extrem();
		e.show();

		Inakzeptables i = new Inakzeptables();
		i.show();

		stage.show();
	}

}
