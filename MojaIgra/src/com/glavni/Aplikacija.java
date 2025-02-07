package com.glavni;

import static com.sporedni.Grafika.StartajSesiju;

import org.lwjgl.opengl.Display;

import com.sporedni.MenadzerStanja;
import com.sporedni.Vrijeme;

public class Aplikacija {
	
	public Aplikacija() {
		
		// Pozivanje staticke metode u Grafika klasi za inicijaliziranje opengl-a
		StartajSesiju();
		
		// Glavna petlja igre
		while(!Display.isCloseRequested()) {
			Vrijeme.Osvjezi();
			MenadzerStanja.Osvjezi();
			Display.update();
			Display.sync(60);
		}
		Display.destroy();
	}
	
	// Main metoda
	public static void main(String[] args) {
		new Aplikacija();
	}
	
}
