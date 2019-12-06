package com.EKEY;

import java.awt.Dimension;

import com.EKEY.Board.Board;
import com.EKEY.Board.NormalTile;
import com.EKEY.GUI.Window;

public class AppRun {
	
	public void run() {
		
		Handler handler = new Handler();
		Game game = new Game(handler);
		
		Window w = new Window("UChess", new Dimension(1080, 720), game);
		w.buildFrame();
		
		Board board = new Board();
		board.createBoard(8, 8);
		
		game.startGame();
		
	}
	
}
