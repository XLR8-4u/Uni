package com.meinprojekt;

import java.io.OutputStream;
import java.util.Objects;
import java.io.StringReader;
import java.io.IOException;

public class InakzeptablesRisiko extends Risiko {

	private String massnahme;

	InakzeptablesRisiko(String bezeichnung, float eintrittswahrscheinlichkeit, float kosten_im_schadensfall,
			String massnahme) {
		super(bezeichnung, eintrittswahrscheinlichkeit, kosten_im_schadensfall);
		this.massnahme = massnahme;
	}

	@Override
	public float ermittleRuechstellung() {
		return super.berechneRisikowert();
	}

	@Override
	public void druckeDaten(OutputStream os) {

		String s = String.format("Id %d Inakzeptables Risiko \"%s\" aus %d/%d/%d;" +
				" Risikowert %.2f; Rueckstellung %.2f; Massnahme \"%s\"\n",
				super.getId(), super.getBezeichnung(),
				super.getErstellungsdatum().getDayOfMonth(),
				super.getErstellungsdatum().getMonthValue(),
				super.getErstellungsdatum().getYear(),
				super.berechneRisikowert(), ermittleRuechstellung(),
				massnahme);

		try (StringReader sr = new StringReader(s)) {

			for (int c = sr.read(); c != -1; c = sr.read())
				os.write(c);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String getMassnahme() {
		return massnahme;
	}

	public void setMassnahme(String massnahme) {
		this.massnahme = massnahme;
	}

	@Override
	public boolean equals(Object other) {
		if (other == null)
			return false;
		if (super.equals(other) == false)
			return false;
		if (other.getClass() != InakzeptablesRisiko.class)
			return false;
		InakzeptablesRisiko ir = (InakzeptablesRisiko) other;
		return massnahme.equals(ir.massnahme);

	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), massnahme);
	}

}
