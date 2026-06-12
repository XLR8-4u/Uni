package com.meinprojekt;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Risiko {
	private final int id;
	private static int idcounter = 0;
	private String bezeichnung;
	private float eintrittswahrscheinlichkeit;
	private float kosten_im_schadensfall;
	private LocalDate erstellungsdatum;

	public Risiko(String bezeichnung, float eintrittswahrscheinlichkeit, float kosten_im_schadenfall) {
		this.bezeichnung = bezeichnung;
		this.eintrittswahrscheinlichkeit = eintrittswahrscheinlichkeit;
		this.kosten_im_schadensfall = kosten_im_schadenfall;
		erstellungsdatum = LocalDate.now();
		id = idcounter;
		idcounter++;
	}

	public float berechneRisikowert() {

		return eintrittswahrscheinlichkeit * kosten_im_schadensfall;
	}

	public abstract float ermittleRuechstellung();

	public abstract void druckeDaten();

	/*
	 * public void druckeDaten() {
	 * System.out.
	 * printf("Id %f Akzeptables Risiko \"%S\" aus %s; Risikowert %f; Rueckstellung %f"
	 * , id, bezeichnung, this.getClass());
	 * }
	 */

	public int getId() {
		return id;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public float getEintrittswahrscheinlichkeit() {
		return eintrittswahrscheinlichkeit;
	}

	public void setEintrittswahrscheinlichkeit(float eintrittswahrscheinlichkeit) {
		this.eintrittswahrscheinlichkeit = eintrittswahrscheinlichkeit;
	}

	public float getKosten_im_schadensfall() {
		return kosten_im_schadensfall;
	}

	public void setKosten_im_schadensfall(float kosten_im_schadensfall) {
		this.kosten_im_schadensfall = kosten_im_schadensfall;
	}

	public LocalDate getErstellungsdatum() {
		return erstellungsdatum;
	}

	@Override
	public boolean equals(Object other) {
		if (other == null)
			return false;
		if (this == other)
			return true;
		if (this.getClass() != other.getClass())
			return false;

		Risiko r = (Risiko) other;
		return this.bezeichnung.equals(r.bezeichnung) &&
				(this.eintrittswahrscheinlichkeit == r.eintrittswahrscheinlichkeit)
				&&
				(this.kosten_im_schadensfall == r.kosten_im_schadensfall);

	}

	@Override
	public int hashCode() {
		return Objects.hash(bezeichnung, eintrittswahrscheinlichkeit, kosten_im_schadensfall);
	}

}
