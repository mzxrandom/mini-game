package com.glavni;

public enum TipPlocice {
	
	Pijesak("plocicaPijesak", true),
	Zemlja("plocicaZemlja", false),
	Voda("plocicaVoda", false),
	NULL("plocicaVoda", false);
	
	String imeTeksture;
	boolean mozeGraditiToranj;
	
	TipPlocice(String imeTeksture, boolean mozeGraditToranj) {
		this.imeTeksture = imeTeksture;
		this.mozeGraditiToranj = mozeGraditToranj;
	}

}
