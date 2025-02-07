package com.sporedni;

import static org.lwjgl.opengl.GL11.*;

import java.io.IOException;
import java.io.InputStream;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class Grafika {
	
	public static final int SIRINA = 1280, VISINA = 768;
	public static final int PLOCICA_SIZE = 64;
	
	public static void StartajSesiju() {
		Display.setTitle("MojaIgra");
		try {
			Display.setDisplayMode(new DisplayMode(SIRINA, VISINA));
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, SIRINA, VISINA, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_TEXTURE_2D);
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
	}
	
	public static boolean ProvjeriSudar(float x1, float y1, float sirina1, float visina1, float x2, float y2, float sirina2, float visina2) {
		if (x1 + sirina1 > x2 && x1 < x2 + sirina2 && y1 + visina1 > y2 && y1 < y2 + visina2 ) {
			return true;
		}		
		return false;
	}
	
	public static void CrtajQ(float x, float y, float sirina, float visina) {
		glBegin(GL_QUADS);
		glVertex2f(x, y);
		glVertex2f(x + sirina, y);
		glVertex2f(x + sirina, y + visina);
		glVertex2f(x, y + visina);
		glEnd();
	}
	
	public static void CrtajQTeksturu(Texture tekstura, float x, float y, float sirina, float visina) {
		tekstura.bind();
		glTranslatef(x, y, 0);
		glBegin(GL_QUADS);
		glTexCoord2f(0, 0);
		glVertex2f(0, 0);
		glTexCoord2f(1, 0);
		glVertex2f(sirina, 0);
		glTexCoord2f(1, 1);
		glVertex2f(sirina, visina);
		glTexCoord2f(0, 1);
		glVertex2f(0, visina);
		glEnd();
		glLoadIdentity();
	}
	
	public static void CrtajQTeksturuRot(Texture tekstura, float x, float y, float sirina, float visina, float kut) {
		tekstura.bind();
		glTranslatef(x + sirina / 2, y + visina / 2, 0);
		glRotatef(kut, 0 , 0, 1);
		glTranslatef(- sirina / 2, - visina / 2, 0);
		glBegin(GL_QUADS);
		glTexCoord2f(0, 0);
		glVertex2f(0, 0);
		glTexCoord2f(1, 0);
		glVertex2f(sirina, 0);
		glTexCoord2f(1, 1);
		glVertex2f(sirina, visina);
		glTexCoord2f(0, 1);
		glVertex2f(0, visina);
		glEnd();
		glLoadIdentity();
	}
	
	public static Texture UcitajTeksturu(String putanja, String tipDatoteke) {
		Texture tekstura = null;
		InputStream inp = ResourceLoader.getResourceAsStream(putanja);
		try {
			tekstura = TextureLoader.getTexture(tipDatoteke, inp);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return tekstura;
		
	}
	
	public static Texture UcitajTeksturuBrzo(String ime) {
		Texture tekstura = null;
		tekstura = UcitajTeksturu("slicice/" + ime + ".png", "PNG");
		return tekstura;
	}
	

}






















