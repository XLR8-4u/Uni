package com.meinprojekt;

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.File;
import java.io.FileInputStream;
//import java.util.Collections;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Risikoverwaltung implements Serializable {

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

	public void zeigeRisiken(OutputStream os) {
		risikos.sort(null);
		// Collections.sort(risikos);
		for (Risiko a : risikos)
			a.druckeDaten(os);
	}

	public void sucheRisikoMitMaxRueckstellung(OutputStream os) {

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
			max.druckeDaten(os);
	}

	public float brechneSummeRueckstellungen() {
		float summe = 0.0f;

		for (Risiko a : risikos)
			summe += a.ermittleRuechstellung();

		return summe;
	}

	public List<Risiko> getList() {
		return risikos;
	}

	public void serialise() {

		File f = new File("./save.txt");

		try (FileOutputStream fos = new FileOutputStream(f);
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {

			oos.writeObject(risikos);

		} catch (IOException e) {
			System.out.println("Fehler bei der Serialisierung");
		}
	}

	public void deserialisierung() {

		try (FileInputStream fis = new FileInputStream("./save.txt");
				ObjectInputStream ois = new ObjectInputStream(fis)) {

			Object obj = ois.readObject();

			if (obj instanceof List) {
				List<?> l = (List<?>) obj;
				List<Risiko> lr = new ArrayList<>();

				for (Object element : l) {
					if (element instanceof Risiko) {
						lr.add((Risiko) element);
					} else {
						System.err.println(
								"Warnung: Unerwarteter Objekttyp in der Liste gefunden!");
					}
				}
				this.risikos = lr;
			}
		} catch (IOException e) {
			System.out.println("IO-Fehler bei der Deserialisierung");
		} catch (ClassNotFoundException e) {
			System.out.println("Fehler: class-Datei nicht gefunden");
		}

	}
}
