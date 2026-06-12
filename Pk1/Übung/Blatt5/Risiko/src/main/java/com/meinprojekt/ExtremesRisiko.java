package com.meinprojekt;

import java.util.Objects;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.IOException;

public class ExtremesRisiko extends InakzeptablesRisiko {
	private float versicherungsbeitrag;

	ExtremesRisiko(String bezeichnung, float eintrittswahrscheinlickeit, float kosten_im_schadensfall,
			String massnahme, float versicherungsbeitrag) {
		super(bezeichnung, eintrittswahrscheinlickeit, kosten_im_schadensfall, massnahme);
		this.versicherungsbeitrag = versicherungsbeitrag;
	}

	@Override
	public float ermittleRuechstellung() {
		return versicherungsbeitrag;
	}

	@Override
	public void druckeDaten(OutputStream os) {
		String s = String.format("Id %d Extremes Risiko \"%s\" aus %d/%d/%d;" +
				" Versicherungsbeitrag %.2f; Maßnahme \"%s\"\n",
				super.getId(), super.getBezeichnung(),
				super.getErstellungsdatum().getDayOfMonth(),
				super.getErstellungsdatum().getMonthValue(),
				super.getErstellungsdatum().getYear(),
				versicherungsbeitrag, super.getMassnahme());

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
		if (other.getClass() != ExtremesRisiko.class)
			return false;
		ExtremesRisiko er = (ExtremesRisiko) other;
		return this.versicherungsbeitrag == er.versicherungsbeitrag;

	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), versicherungsbeitrag);
	}
}
