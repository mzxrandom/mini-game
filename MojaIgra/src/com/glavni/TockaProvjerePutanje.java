package com.glavni;

public class TockaProvjerePutanje {
	
	private Plocica plocica;
	private int xSmjer, ySmjer;
	
	public TockaProvjerePutanje(Plocica plocica, int xSmjer, int ySmjer) {
		this.plocica = plocica;
		this.xSmjer = xSmjer;
		this.ySmjer = ySmjer;
	}

	public Plocica dohvatiPlocicu() {
		return this.plocica;
	}

	public int dohvatiXSmjer() {
		return this.xSmjer;
	}

	public int dohvatiYSmjer() {
		return this.ySmjer;
	}
	
}
