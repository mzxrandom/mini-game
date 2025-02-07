package com.glavni;

import java.util.concurrent.CopyOnWriteArrayList;

public class TopGunLed extends Top {

	public TopGunLed(TipTopa tip, Plocica pocetnaPlocica, CopyOnWriteArrayList<Neprijatelj> neprijatelji) {
		super(tip, pocetnaPlocica, neprijatelji);
	}
	
	@Override
	public void pucaj(Neprijatelj meta) {
		super.projektili.add(new ProjektilLed(super.tipTopa.tipProjektila, super.meta, super.dohvatiX(), super.dohvatiY(), 32, 32));
		super.meta.smanjiTrenutnuEnergiju(super.tipTopa.tipProjektila.snagaProjektila);
	}
}
