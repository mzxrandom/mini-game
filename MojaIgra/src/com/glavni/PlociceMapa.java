package com.glavni;

import static com.sporedni.Grafika.*;

public class PlociceMapa {
	
	public Plocica[][] mapa;
	private int brojPlocicaX, brojPlocicaY;
	
	public PlociceMapa() {
		this.brojPlocicaX = 17;
		this.brojPlocicaY = 12;
		mapa = new Plocica[brojPlocicaX][brojPlocicaY];
		for (int i = 0; i < mapa.length; i++) {
			for (int j = 0; j < mapa[i].length; j++) {
				mapa[i][j] = new Plocica(i * PLOCICA_SIZE, j * PLOCICA_SIZE, PLOCICA_SIZE, PLOCICA_SIZE, TipPlocice.Pijesak);
			}
		}
	}
	
	public PlociceMapa(int[][] novaMapa) {
		this.brojPlocicaX = novaMapa[0].length;
		this.brojPlocicaY = novaMapa.length;
		mapa = new Plocica[brojPlocicaX][brojPlocicaY];
		for (int i = 0; i < mapa.length; i++) {
			for (int j = 0; j < mapa[i].length; j++) {
				switch (novaMapa[j][i]) {
				case 0:
					mapa[i][j] = new Plocica(i * PLOCICA_SIZE, j * PLOCICA_SIZE, PLOCICA_SIZE, PLOCICA_SIZE, TipPlocice.Pijesak);
					break;
				case 1:
					mapa[i][j] = new Plocica(i * PLOCICA_SIZE, j * PLOCICA_SIZE, PLOCICA_SIZE, PLOCICA_SIZE, TipPlocice.Zemlja);
					break;
				case 2:
					mapa[i][j] = new Plocica(i * PLOCICA_SIZE, j * PLOCICA_SIZE, PLOCICA_SIZE, PLOCICA_SIZE, TipPlocice.Voda);
				}
				
			}
		}
	}
	
	public void postaviPlocicu(int xKoordinata, int yKoorinata, TipPlocice tipPlocice) {
		mapa[xKoordinata][yKoorinata] = new Plocica(xKoordinata * PLOCICA_SIZE, yKoorinata * PLOCICA_SIZE, PLOCICA_SIZE, PLOCICA_SIZE, tipPlocice);
	}
	
	public Plocica dohvatiPlocicu(int polozajX, int polozajY) {
		if (polozajX < brojPlocicaX && polozajY < brojPlocicaY && polozajX > -1 && polozajY > -1) {
			return mapa[polozajX][polozajY];
		} else {
			return new Plocica(0, 0, 0, 0, TipPlocice.NULL);
		}
	}
	
	public void crtajMapu() {
		for (int i = 0; i < mapa.length; i++) {
			for (int j = 0; j < mapa[i].length; j++) {
				mapa[i][j].crtaj();
			}
		}
	}

	public int dohvatiSirinuPlocice() {
		return brojPlocicaX;
	}

	public void postaviSirinuPlocice(int brojPlocicaX) {
		this.brojPlocicaX = brojPlocicaX;
	}

	public int dohvatiVisinuPlocice() {
		return brojPlocicaY;
	}

	public void dohvatiVisinuPlocice(int brojPlocicaY) {
		this.brojPlocicaY = brojPlocicaY;
	}
	
	
}



















