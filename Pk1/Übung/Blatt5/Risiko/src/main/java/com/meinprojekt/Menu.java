package com.meinprojekt;

import java.io.File;
import java.io.FileWriter;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Menu {

	private boolean laufen;
	private static float LIMIT;
	private static float KOSTENLIMIT;
	private Risikoverwaltung verwaltung;

	private void erstelleRisiko() throws NullPointerException {
		String b = parseString("Bezeichnung");
		float e = parseFloat("Eintrittswahrscheinlichkeit");
		float k = parseFloat("Kosten im Schadensfall");

		if (KOSTENLIMIT < k) {
			String m = parseString("Es handelt sich um ein extremes Risiko,\n" +
					"eine Massnahme ist erfolderlich");

			float v = parseFloat("versicherungsbeitrag");

			verwaltung.aufnehmen(new ExtremesRisiko(b, e, k, m, v));

		} else if (LIMIT < e * k) {
			String m = parseString(
					"Es handelt sich um ein inakzeptables Risiko,\n" +
							"eine Massnahme ist erfolderlich: ");
			verwaltung.aufnehmen(new InakzeptablesRisiko(b, e, k, m));
		} else
			verwaltung.aufnehmen(new AkzeptablesRisiko(b, e, k));
	}

	private String parseString(String message) throws NullPointerException {
		return JOptionPane.showInputDialog(message);
	}

	private float parseFloat(String message) throws NullPointerException {

		while (true)
			try {
				float f = Float.parseFloat(JOptionPane.showInputDialog(message));
				if (f < 0)
					throw new NegativeNumberException(String.format("%s ist negativ.", message));
				return f;

			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null,
						String.format("Bitte gültige %s eingeben", message));
			} catch (NegativeNumberException e) {
				JOptionPane.showMessageDialog(null,
						String.format("%s ist negativ", message));

			}

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
							"3. Risikoliste in Datei schreiben\n" +
							"4. Zeige Risiko mit maximaler R¨uckstellung\n" +
							"5. Berechne Summe aller R¨uckstellungen\n" +
							"6. Beenden\n\n" +
							"Bitte Menüpunkt wählen:\n");
			int i;
			try {
				i = sc.nextInt();
			} catch (InputMismatchException e) {
				sc.nextLine();
				System.out.println("\nmachen sie eine Gültige eingabe!!");
				continue;
			}

			switch (i) {
				case 1:
					try {
						erstelleRisiko();
					} catch (NullPointerException e) {
						JOptionPane.showMessageDialog(null,
								"Risikoerstellung wurde unterbrochen");
					}
					break;
				case 2:
					System.out.println();
					verwaltung.zeigeRisiken(System.out);
					break;
				case 3:
					String s = parseString("Dateinamen angeben.");
					File f = new File("./" + s);

					break;
				case 4:
					System.out.println();
					verwaltung.sucheRisikoMitMaxRueckstellung(System.out);
					break;
				case 5:
					System.out.println();
					float sum = 0.0f;
					for (Risiko a : verwaltung.getList())
						sum += a.ermittleRuechstellung();
					String sf = String.format("Die Summe der Rückstellungen beträgt: %.2f",
							sum);
					JOptionPane.showMessageDialog(null, sf);
					break;
				case 6:
					laufen = false;
					break;
			}
		}
		sc.close();
	}
}
