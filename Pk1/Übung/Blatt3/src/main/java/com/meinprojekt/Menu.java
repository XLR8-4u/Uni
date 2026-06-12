package com.meinprojekt;

import java.util.Scanner;
import java.util.Formatter;
import javax.swing.JOptionPane;

public class Menu {

	private boolean laufen;
	private static float LIMIT;
	private static float KOSTENLIMIT;
	private Risikoverwaltung verwaltung;

	private void erstelleRisiko() {
		String b = parseString("Bezeichnung");
		float e = parsefloat("Eintrittswahrscheinlichkeit");
		float k = parsefloat("Kosten im Schadensfall");

		if (KOSTENLIMIT < k) {
			String m = parseString(
					"Es handelt sich um ein extremes Risiko,\n" +
							"eine Massnahme ist erfolderlich");
			float v = parsefloat("versicherungsbeitrag");
			verwaltung.aufnehmen(new ExtremesRisiko(b, e, k, m, v));

		} else if (LIMIT < e * k) {
			String m = parseString(
					"Es handelt sich um ein inakzeptables Risiko,\n" +
							"eine Massnahme ist erfolderlich: ");
			verwaltung.aufnehmen(new InakzeptablesRisiko(b, e, k, m));
		} else
			verwaltung.aufnehmen(new AkzeptablesRisiko(b, e, k));
	}

	private String parseString(String message) {
		return JOptionPane.showInputDialog(message);
	}

	private float parsefloat(String messeage) {
		return Float.parseFloat(JOptionPane.showInputDialog(messeage));
	}

	public Menu(Risikoverwaltung verwaltung) {
		laufen = true;
		LIMIT = 10000.0f;
		KOSTENLIMIT = 1000000.0f;
		this.verwaltung = verwaltung;
	}

	public void printMenu() {
		Scanner sc = new Scanner(System.in);

		while (laufen) {
			System.out.printf(
					"\nRisikoverwaltung \n\n" +
							"1. Risiko aufnehmen\n" +
							"2. Zeige alle Risiken\n" +
							"3. Zeige Risiko mit maximaler R¨uckstellung\n" +
							"4. Berechne Summe aller R¨uckstellungen\n" +
							"5. Beenden\n\n" +
							"Bitte Men¨upunkt w¨ahlen:\n");

			switch (sc.nextInt()) {
				case 1:
					erstelleRisiko();
					break;
				case 2:
					System.out.println();
					verwaltung.zeigeRisiken();
					break;
				case 3:
					System.out.println();
					verwaltung.sucheRisikoMitMaxRueckstellung();
					break;
				case 4:
					System.out.println();
					float sum = 0.0f;
					for (Risiko a : verwaltung.getList())
						sum += a.ermittleRuechstellung();
					Formatter f = new Formatter();
					f.format("Die Summe der Rückstellungen beträgt: %.2f", sum);
					JOptionPane.showMessageDialog(null, f);
					break;

				case 5:
					laufen = false;
			}
		}
		sc.close();
	}
}
