package com.meinprojekt;

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
	public void druckeDaten() {

		System.out.printf("Id %d Inakzeptables Risiko \"%s\" aus %d/%d/%d;" +
				" Risikowert %.2f; Rueckstellung %.2f; Massnahme \"%s\"\n",
				super.getId(), super.getBezeichnung(),
				super.getErstellungsdatum().getDayOfMonth(),
				super.getErstellungsdatum().getMonthValue(),
				super.getErstellungsdatum().getYear(),
				super.berechneRisikowert(), ermittleRuechstellung(),
				massnahme);
	}

	public String getMassnahme() {
		return massnahme;
	}

	public void setMassnahme(String massnahme) {
		this.massnahme = massnahme;
	}
}
