package com.meinprojekt;

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
	public void druckeDaten() {
		System.out.printf("Id %d Extremes Risiko \"%s\" aus %d/%d/%d;" +
				" Versicherungsbeitrag %.2f; Maßnahme \"%s\"\n",
				super.getId(), super.getBezeichnung(),
				super.getErstellungsdatum().getDayOfMonth(),
				super.getErstellungsdatum().getMonthValue(),
				super.getErstellungsdatum().getYear(),
				versicherungsbeitrag, super.getMassnahme());
	}
}
