package com.meinprojekt;

import java.util.ArrayList;

public class RisikoverwaltungNichtTypsicher {

	private ArrayList risikos = new ArrayList();

	public void aufnehmen(Object risiko) {
		if (risiko == null)
			return;
		if (risiko.getClass() == Risiko.class)
			risikos.add(risiko);
	}

	public void zeigeRisiken() {
		for (Object a : risikos) {
			Risiko r = (Risiko) a;
			r.druckeDaten();
		}

	}

	public void sucheRisikoMitMaxRueckstellung() {
		Risiko max = (Risiko) risikos.get(1);
		for (Object a : risikos) {
			Risiko r = (Risiko) a;
			if (max.ermittleRuechstellung() < r.ermittleRuechstellung())
				max = r;
			max.druckeDaten();
		}
	}

	public float brechneSummeRueckstellungen() {
		float summe = 0.0f;

		Risiko a;
		for (int i = 0; i < risikos.size(); i++) {
			a = (Risiko) risikos.get(i);
			summe += a.ermittleRuechstellung();
		}
		return summe;
	}
}
