package com.EKEY;

import java.awt.Dimension;

import com.EKEY.Board.Board;
import com.EKEY.Board.ChessFigures.Builder.FigureDirector;
import com.EKEY.Board.ChessFigures.Movement.MovementPrototypes;
import com.EKEY.Board.ChessFigures.Prototypes.FigurePrototypes;
import com.EKEY.Files.UChessImages;
import com.EKEY.Files.UChessPaths;
import com.EKEY.GUI.Window;
import com.EKEY.Misc.Camera;

public class AppRun {
	
	public void run() {
		
		Handler handler = new Handler();
		Game game = new Game(handler);
		
		UChessPaths.loadFiles();
		UChessImages.loadAllImages();
		
		FigurePrototypes.createPrototypes();
		MovementPrototypes.createMovementPrototypes();
		
		Window w = new Window("UChess", new Dimension(1080, 720), game);
		w.buildFrame();
		
		Board board = new Board();
		board.createBoard(8, 8);
		board.createFigures();
		
		game.startGame();
		
	}
	
}
