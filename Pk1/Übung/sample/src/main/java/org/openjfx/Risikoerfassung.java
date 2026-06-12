package org.openjfx;

import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Risikoerfassung extends Stage {

	Risikoerfassung(Risiko r, Stage stage) {
		this.initOwner(stage);
		this.initModality(Modality.WINDOW_MODAL);

	}
}
