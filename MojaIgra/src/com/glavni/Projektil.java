package com.glavni;

import static com.sporedni.Grafika.*;
import static com.sporedni.Vrijeme.*;

import org.newdawn.slick.opengl.Texture;

public abstract class Projektil implements Jedinka {
	
	private Texture tekstura;
	private float x, y, brzina, brzinaX, brzinaY;
	private int snaga, sirina, visina;
	private Neprijatelj meta;
	private boolean ziv;
	
	public Projektil(TipProjektila tip, Neprijatelj meta, float x, float y, int sirina, int visina) {
		this.tekstura = tip.tekstura;
		this.x = x;
		this.y = y;
		this.sirina = sirina;
		this.visina = visina;
		this.brzina = tip.brzinaProjektila;
		this.snaga = tip.snagaProjektila;
		this.meta = meta;
		this.ziv = true;
		this.brzinaX = 0f;
		this.brzinaY = 0f;
		izracunajSmjer();
	}
	
	private void izracunajSmjer() {
		float ukupnoMoguceGibanje = 1.0f;
		float xUdaljenostOdMete = Math.abs(meta.dohvatiX() - x + PLOCICA_SIZE / 4);
		float yUdaljenostOdMete = Math.abs(meta.dohvatiY() - y + PLOCICA_SIZE / 4);
		float ukupnaUdaljenostOdMete = xUdaljenostOdMete + yUdaljenostOdMete;
		float xPostotakGibanja = xUdaljenostOdMete / ukupnaUdaljenostOdMete;
		brzinaX = xPostotakGibanja;
		brzinaY = ukupnoMoguceGibanje - xPostotakGibanja;
		
		if (meta.dohvatiX() < x) {
			brzinaX *= -1;
		}
		if (meta.dohvatiY() < y) {
			brzinaY *= -1;
		}
	}
	
	public void nanesiStetu() {
		meta.primiStetu(snaga);
		ziv = false;
	}
	
	public void osvjezi() {
		if (ziv) {
			izracunajSmjer();
			x += brzinaX * brzina * Delta();
			y += brzinaY * brzina * Delta();
			if (ProvjeriSudar(x, y, sirina, visina, meta.dohvatiX(), meta.dohvatiY(), meta.dohvatiSirinu(), meta.dohvatiVisinu())) {
				nanesiStetu();
			}
			crtaj();
		}
	}
	
	public void crtaj() {
		CrtajQTeksturu(tekstura, x + PLOCICA_SIZE / 4, y + PLOCICA_SIZE / 4, sirina, visina);
	}

	public float dohvatiX() {
		return x;
	}

	public float dohvatiY() {
		return y;
	}

	public void postaviX(float x) {
		this.x = x;
	}

	public void postaviY(float y) {
		this.y = y;
	}

	public int dohvatiSirinu() {
		return sirina;
	}

	public int dohvatiVisinu() {
		return visina;
	}

	public void postaviSirinu(int sirina) {
		this.sirina = sirina;
	}

	public void postaviVisinu(int visina) {
		this.visina = visina;
	}
	
	public Neprijatelj getTarget() {
		return meta;
	}
	
	public void setAlive(boolean status) {
		ziv = status;
	}
	

}
