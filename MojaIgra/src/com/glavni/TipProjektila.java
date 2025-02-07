package com.glavni;

import static com.sporedni.Grafika.*;

import org.newdawn.slick.opengl.Texture;

public enum TipProjektila {

	MetakVatraMali(UcitajTeksturuBrzo("metakVatraMali"), 10, 500),
	MetakVatraVeliki(UcitajTeksturuBrzo("metakVatraVeliki"), 30, 500),
	MetakLed(UcitajTeksturuBrzo("metakLed"), 5, 400),
	MetakCrveni(UcitajTeksturuBrzo("metakCrveni"), 50, 500);
	
	
	Texture tekstura;
	int snagaProjektila;
	float brzinaProjektila;
	
	TipProjektila(Texture tekstura, int snaga, float brzina) {
		this.tekstura = tekstura;
		this.snagaProjektila = snaga;
		this.brzinaProjektila = brzina;
	}
	
}
