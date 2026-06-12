package com.meinprojekt;

public class RisikoverwaltungMitArray {

	private Risiko[] risikos;
	private static int count;

	public RisikoverwaltungMitArray(int n) {
		risikos = new Risiko[n];
		count = 0;
	}

	public void aufnehmen(Risiko risiko) {

		if (count == risikos.length - 1) {
			System.out.println("Liste ist voll! Es können keine weiteren Risikos hinzugefügt werden.");
			return;
		}

		risikos[count] = risiko;
		count++;
	}

	public void zeigeRisiken() {
		for (Risiko a : risikos)
			a.druckeDaten();
	}

	public void sucheRisikoMitMaxRueckstellung() {
		Risiko max = risikos[0];
		for (Risiko a : risikos)
			if (max.ermittleRuechstellung() < a.ermittleRuechstellung())
				max = a;
		max.druckeDaten();
	}

	public float brechneSummeRueckstellungen() {
		float summe = 0.0f;

		Risiko a;
		for (int i = 0; i < risikos.length; i++) {
			a = risikos[i];
			summe += a.ermittleRuechstellung();
		}
		return summe;
	}
}
