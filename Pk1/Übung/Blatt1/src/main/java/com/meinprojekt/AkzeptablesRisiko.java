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

}
