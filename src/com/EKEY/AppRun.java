package com.EKEY;

import java.awt.Dimension;

import com.EKEY.Board.Board;
import com.EKEY.GUI.Window;
import com.EKEY.Misc.Camera;

public class AppRun {
	
	public void run() {
		
		Handler handler = new Handler();
		Game game = new Game(handler);
		
		Window w = new Window("UChess", new Dimension(1080, 720), game);
		w.buildFrame();
		
		Camera camera = new Camera();
		
		Board board = new Board();
		board.createBoard(8, 8);
		
		game.startGame();
		
	}
	
}
