package com.meinprojekt;

public class AkzeptablesRisiko extends Risiko {
	AkzeptablesRisiko(String bezeichnung, float eintrittswahrscheinlickeit, float kosten_im_schadensfall) {
		super(bezeichnung, eintrittswahrscheinlickeit, kosten_im_schadensfall);
	}

	@Override
	public float ermittleRuechstellung() {
		return 0.0f;
	}

	@Override
	public void druckeDaten() {

		System.out.printf("Id %d Akzeptables Risiko \"%s\" aus %d/%d/%d;" +
				" Risikowert %.2f; Rueckstellung %.2f\n",
				getId(), getBezeichnung(),
				getErstellungsdatum().getDayOfMonth(),
				getErstellungsdatum().getMonthValue(),
				getErstellungsdatum().getYear(),
				berechneRisikowert(), ermittleRuechstellung());
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
