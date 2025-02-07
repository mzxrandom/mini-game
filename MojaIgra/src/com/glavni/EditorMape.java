package com.glavni;

import static com.sporedni.Grafika.*;
import static com.sporedni.Level.*;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.opengl.Texture;

import com.sucelje.KoristnickoSucelje;
import com.sucelje.KoristnickoSucelje.Menu;

public class EditorMape {

	private Texture editorPozadina;
	private PlociceMapa mapa;
	private TipPlocice[] tipovi;
	private int indexTipova;
	private KoristnickoSucelje editorSucelje;
	private Menu editorMenu;

	public EditorMape() {
		this.mapa = UcitajMapu("mojaMapa");
		this.indexTipova = 0;
		this.tipovi = new TipPlocice[3];
		this.tipovi[0] = TipPlocice.Pijesak;
		this.tipovi[1] = TipPlocice.Zemlja;
		this.tipovi[2] = TipPlocice.Voda;
		this.editorPozadina = UcitajTeksturuBrzo("pozadinaEditor");
		napraviSucelje();
	}
	
	private void napraviSucelje() {
		editorSucelje = new KoristnickoSucelje();
		editorSucelje.napraviMenu("IzborPlocica", 1088, 100, 192, 960, 2, 0);
		editorMenu= editorSucelje.dohvatiMenu("IzborPlocica");
		editorMenu.dodajGumbBrzo("Pijesak", "plocicaPijesak");
		editorMenu.dodajGumbBrzo("Zemlja", "plocicaZemlja");
		editorMenu.dodajGumbBrzo("Voda", "plocicaVoda");
	}

	public void osvjezi() {
		crtaj();

		// Obradi unos misa
		if (Mouse.next()) {
			boolean lijeviMisDolje = Mouse.isButtonDown(0);
			if (lijeviMisDolje) {
				if (editorMenu.gumbKliknut("Pijesak")) {
					indexTipova = 0;
				} else if (editorMenu.gumbKliknut("Zemlja")) {
					indexTipova = 1;
				} else if (editorMenu.gumbKliknut("Voda")) {
					indexTipova = 2;
				} else {
					postaviPlocicu();
				}
			}
		}

		// Obradi unos s tipkovnice
		while (Keyboard.next()) {
			if (Keyboard.getEventKey() == Keyboard.KEY_RIGHT && Keyboard.getEventKeyState()) {
				povecajIndex();
			}
			// Snimi mapu u editoru sa CTRL+S
			if (Keyboard.getEventKey() == Keyboard.KEY_S && Keyboard.getEventKeyState()) {
				SnimiMapu("mojaMapa", mapa);
			}
		}
	}
	
	private void crtaj() {
		CrtajQTeksturu(editorPozadina, 1088, 0, 192, 768);
		mapa.crtajMapu();
		editorSucelje.crtajGumbove();
	}

	private void postaviPlocicu() {
		mapa.postaviPlocicu((int) Math.floor(Mouse.getX() / PLOCICA_SIZE), (int) Math.floor((VISINA - Mouse.getY() - 1) / PLOCICA_SIZE),
				tipovi[indexTipova]);
	}
	
	
	// Omogucije da editor izabere koji je tip plocice kliknut
	public void povecajIndex() {
		indexTipova++;
		if (indexTipova > tipovi.length - 1) {
			indexTipova = 0;
		}
	}

}
