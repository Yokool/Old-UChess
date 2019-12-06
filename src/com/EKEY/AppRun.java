package com.EKEY;

import java.awt.Dimension;

import com.EKEY.GUI.Window;

public class AppRun {
	
	public void run() {
		
		Game game = new Game();
		
		Window w = new Window("UChess", new Dimension(1080, 720), game);
		w.buildFrame();
		
		
	}
	
}
