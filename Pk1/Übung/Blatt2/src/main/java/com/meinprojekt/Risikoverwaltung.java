package com.meinprojekt;

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

public class Risikoverwaltung {

	private List<Risiko> risikos;

	public Risikoverwaltung() {
		risikos = new ArrayList<Risiko>();
	}

	public Risikoverwaltung(List<Risiko> risikos) {
		this.risikos = risikos;
	}

	public void aufnehmen(Risiko risiko) {
		risikos.add(risiko);
	}

	public void zeigeRisiken() {
		for (Risiko a : risikos)
			a.druckeDaten();
	}

	public void sucheRisikoMitMaxRueckstellung() {

		Risiko max = null;
		Iterator<Risiko> it = risikos.iterator();
		if (it.hasNext()) {
			max = it.next();
		}
		while (it.hasNext()) {
			Risiko next = it.next();

			if (max.ermittleRuechstellung() < next.ermittleRuechstellung())
				max = next;
		}

		if (max != null)
			max.druckeDaten();
	}

	public float brechneSummeRueckstellungen() {
		float summe = 0.0f;

		for (Risiko a : risikos)
			summe += a.ermittleRuechstellung();

		return summe;
	}
}
