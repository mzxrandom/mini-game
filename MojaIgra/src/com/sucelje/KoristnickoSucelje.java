package com.sucelje;

import static com.sporedni.Grafika.*;

import java.awt.Font;
import java.util.ArrayList;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.TrueTypeFont;

public class KoristnickoSucelje {
	
	private TrueTypeFont font;
	private Font awtFont;
	private ArrayList<Gumb> listaGumbova;
	private ArrayList<Menu> listaOpcija;
	
	
	public KoristnickoSucelje() {
		awtFont = new Font("Times New Roman", Font.BOLD, 24);
		font = new TrueTypeFont(awtFont, false);
		listaGumbova = new ArrayList<Gumb>();
		listaOpcija = new ArrayList<Menu>();
	}
	
	public void ispisStringa(int x, int y, String tekst) {
		font.drawString(x, y, tekst);
	}
	
	public void dodajGumb(String ime, String imeTeksture, int x, int y) {
		listaGumbova.add(new Gumb(ime, UcitajTeksturuBrzo(imeTeksture), x, y));
	}
	
	public boolean gumbKliknut(String imeGumba) {
		Gumb gumb = dohvatiGumb(imeGumba);
		float misY = VISINA - Mouse.getY() - 1;
		if (Mouse.getX() > gumb.dohvatiX() && Mouse.getX() < gumb.dohvatiX() + gumb.dohvatiSirinu() && misY > gumb.dohvatiY() && misY < gumb.dohvatiY() + gumb.dohvatiVisinu()) {
			return true;
		}
		return false;
	}
	
	private Gumb dohvatiGumb(String imeGumba) {
		for (Gumb gumb : listaGumbova) {
			if (gumb.dohvatiIme().equals(imeGumba)) {
				return gumb;
			} 
		}
		return null;
	}
	
	public void napraviMenu(String ime, int x, int y, int sirina, int visina, int sirinaOpcija, int visinaOpcija) {
		listaOpcija.add(new Menu(ime, x, y, sirina, visina, sirinaOpcija, visinaOpcija));
	}
	
	public Menu dohvatiMenu(String ime) {
		for (Menu menu : listaOpcija) {
			if (ime.equals(menu.dohvatiIme())) {
				return menu;
			}
		}
		return null;
	}
	
	public void crtajGumbove() {
		for (Gumb gumb : listaGumbova) {
			CrtajQTeksturu(gumb.dohvatiTeksturu(), gumb.dohvatiX(), gumb.dohvatiY(), gumb.dohvatiSirinu(), gumb.dohvatiVisinu());
		}
		for (Menu menu : listaOpcija) {
			menu.crtajGumbove();
		}
	}
	
	public class Menu {
		
		String ime;
		private ArrayList<Gumb> menuGumbovi;
		private int x, y, sirina, visina, brojGumbova, sirinaOpcija, visinaOpcija, padding;
		
		
		public Menu(String ime, int x, int y, int sirina, int visina, int sirinaOpcija, int visinaOpcija) {
			this.ime = ime;
			this.x = x;
			this.y = y;
			this.sirina = sirina;
			this.visina = visina;
			this.sirinaOpcija = sirinaOpcija;
			this.visinaOpcija = visinaOpcija;
			this.padding = (sirina - (sirinaOpcija * PLOCICA_SIZE)) / (sirinaOpcija + 1);
			this.brojGumbova = 0;
			this.menuGumbovi = new ArrayList<Gumb>();
		}
		
		public void dodajGumb(Gumb gumb) {
			postaviGumb(gumb);
		}
		
		public void dodajGumbBrzo(String ime, String imeTekstureGumba) {
			Gumb b = new Gumb(ime, UcitajTeksturuBrzo(imeTekstureGumba), 0, 0);
			postaviGumb(b);
		}
		
		public void postaviGumb(Gumb gumb) {
			if (sirinaOpcija != 0) {
				gumb.postaviY(y + (brojGumbova / sirinaOpcija) * PLOCICA_SIZE);
			}
			gumb.postaviX(x + (brojGumbova % 2) * (padding + PLOCICA_SIZE) + padding);
			brojGumbova++;
			menuGumbovi.add(gumb);
		}
		
		public boolean gumbKliknut(String imeGumba) {
			Gumb gumb = dohvatiGumb(imeGumba);
			float misY = VISINA - Mouse.getY() - 1;
			if (Mouse.getX() > gumb.dohvatiX() && Mouse.getX() < gumb.dohvatiX() + gumb.dohvatiSirinu() && misY > gumb.dohvatiY() && misY < gumb.dohvatiY() + gumb.dohvatiVisinu()) {
				return true;
			}
			return false;
		}
		
		private Gumb dohvatiGumb(String imeGumba) {
			for (Gumb gumb : menuGumbovi) {
				if (gumb.dohvatiIme().equals(imeGumba)) {
					return gumb;
				} 
			}
			return null;
		}
		
		public void crtajGumbove() {
			for (Gumb gumb : menuGumbovi) {
				CrtajQTeksturu(gumb.dohvatiTeksturu(), gumb.dohvatiX(), gumb.dohvatiY(), gumb.dohvatiSirinu(), gumb.dohvatiVisinu());
			}
		}
		
		public String dohvatiIme() {
			return ime;
		}
	}

}















