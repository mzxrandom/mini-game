package com.glavni;

import static com.sporedni.Grafika.*;

import org.newdawn.slick.opengl.Texture;

public class Plocica {
	
	private float x, y;
	private int sirina, visina;
	private Texture tekstura;
	private TipPlocice tipPlocice;
	private boolean zauzeta;
	
	public Plocica(float x, float y, int sirina, int visina, TipPlocice tip) {
		this.x = x;
		this.y = y;
		this.sirina = sirina;
		this.visina = visina;
		this.tipPlocice = tip;
		this.tekstura = UcitajTeksturuBrzo(tip.imeTeksture);
		if(tip.mozeGraditiToranj) {
			zauzeta = false;
		} else {
			zauzeta = true;
		}
	}
	
	public void crtaj() {
		CrtajQTeksturu(tekstura, x, y, sirina, visina);
	}

	public float dohvatiX() {
		return x;
	}
	
	public int dohvatiPozicijuX() {
		return (int) x / PLOCICA_SIZE;
	}
	
	public int dohvatiPozicijuY() { 
		return (int) y / PLOCICA_SIZE;
	}

	public void postaviX(float x) {
		this.x = x;
	}

	public float dohvatiY() {
		return y;
	}

	public void postaviY(float y) {
		this.y = y;
	}

	public int dohvatiSirinu() {
		return sirina;
	}

	public void postaviSirinu(int sirina) {
		this.sirina = sirina;
	}

	public int dohvatiVisinu() {
		return visina;
	}

	public void postaviVisinu(int visina) {
		this.visina = visina;
	}

	public Texture dohvatiTeksturu() {
		return tekstura;
	}

	public void postaviTeksturu(Texture tekstura) {
		this.tekstura = tekstura;
	}

	public TipPlocice dohvatiTipPlocice() {
		return tipPlocice;
	}

	public void postaviTipPlocice(TipPlocice tip) {
		this.tipPlocice = tip;
	}

	public boolean jeZauzeta() {
		return zauzeta;
	}

	public void postaviZauzetost(boolean zauzeta) {
		this.zauzeta = zauzeta;
	}	
	
	
	
}
