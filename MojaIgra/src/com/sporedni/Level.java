package com.sporedni;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import com.glavni.Plocica;
import com.glavni.PlociceMapa;
import com.glavni.TipPlocice;

public class Level {
	
	public static void SnimiMapu(String imeMape, PlociceMapa mapa) {
		String podaciMape = "";
		for (int i = 0; i < mapa.dohvatiSirinuPlocice(); i++) {
			for (int j = 0; j < mapa.dohvatiVisinuPlocice(); j++) {
				podaciMape += DohvatiIDPlocice(mapa.dohvatiPlocicu(i, j));
			}
		}
		try {
			File datoteka = new File(imeMape);
			BufferedWriter bw = new BufferedWriter(new FileWriter(datoteka));
			bw.write(podaciMape);
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static PlociceMapa UcitajMapu(String imeMape) {
		PlociceMapa mapa = new PlociceMapa();
		try {
			BufferedReader br = new BufferedReader(new FileReader(imeMape));
			String data = br.readLine();
			for (int i = 0; i < mapa.dohvatiSirinuPlocice(); i++) {
				for (int j = 0; j < mapa.dohvatiVisinuPlocice(); j++) {
					mapa.postaviPlocicu(i, j, DohvatiTipPlocice(data.substring(i * mapa.dohvatiVisinuPlocice() + j, i * mapa.dohvatiVisinuPlocice() + j + 1)));
				}
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return mapa;
	}
	
	public static TipPlocice DohvatiTipPlocice(String ID) {
		TipPlocice tip = TipPlocice.NULL;
		switch (ID) {
		case "0":
			tip = TipPlocice.Pijesak;
			break;
		case "1":
			tip = TipPlocice.Zemlja;
			break;
		case "2":
			tip = TipPlocice.Voda;
			break;
		case "3":
			tip = TipPlocice.NULL;
			break;
		}
		return tip;
	}
	
	public static String DohvatiIDPlocice(Plocica plocica) {
		String ID = "E";
		switch (plocica.dohvatiTipPlocice()) {
		case Pijesak:
			ID = "0";
			break;
		case Zemlja:
			ID = "1";
			break;
		case Voda:
			ID = "2";
			break;
		case NULL:
			ID = "3";
			break;
		}	
		return ID;
	}
	
	
	
	
}