package com.meinprojekt;

import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;

public class AkzeptablesRisiko extends Risiko {
	AkzeptablesRisiko(String bezeichnung, float eintrittswahrscheinlickeit, float kosten_im_schadensfall) {
		super(bezeichnung, eintrittswahrscheinlickeit, kosten_im_schadensfall);
	}

	@Override
	public float ermittleRuechstellung() {
		return 0.0f;
	}

	@Override
	public void druckeDaten(OutputStream os) {

		String s = String.format("Id %d Akzeptables Risiko \"%s\" aus %d/%d/%d;" +
				" Risikowert %.2f; Rueckstellung %.2f\n",
				getId(), getBezeichnung(),
				getErstellungsdatum().getDayOfMonth(),
				getErstellungsdatum().getMonthValue(),
				getErstellungsdatum().getYear(),
				berechneRisikowert(), ermittleRuechstellung());

		try (StringReader sr = new StringReader(s)) {

			for (int c = sr.read(); c != -1; c = sr.read())
				os.write(c);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean equals(Object other) {
		if (other == null)
			return false;
		if (super.equals(other) == false)
			return false;
		if (other.getClass() != AkzeptablesRisiko.class)
			return false;
		return true;

	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
