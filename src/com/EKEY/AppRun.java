package com.EKEY;

import java.awt.Dimension;

import com.EKEY.Board.Board;
import com.EKEY.Board.ChessFigures.ColorEnum;
import com.EKEY.Board.ChessFigures.Movement.MovementPrototypes;
import com.EKEY.Board.ChessFigures.Prototypes.FigurePrototypes;
import com.EKEY.Board.Turns.Player;
import com.EKEY.Board.Turns.TurnSystem;
import com.EKEY.Files.UChessImages;
import com.EKEY.Files.UChessPaths;
import com.EKEY.GUI.Window;

public class AppRun {
	
	public void run() {
		
		// Initializing the main game
		Handler handler = new Handler();
		Game game = new Game(handler);
		
		// Loading files and their paths
		UChessPaths.loadFiles();
		UChessImages.loadAllImages();
		
		// Initializing static prototypes
		MovementPrototypes.createMovementPrototypes();
		FigurePrototypes.createPrototypes();
		
		// Building the window
		Window w = new Window("UChess", new Dimension(1080, 720), game);
		w.buildFrame();
		
		// Initializing the turn system
		TurnSystem turnSystem = new TurnSystem();
		
		
		// Initializing all the players
		Player whitePlayer = new Player(ColorEnum.WHITE);
		Player blackPlayer = new Player(ColorEnum.BLACK);
		
		// Creating the board and the figures
		Board board = new Board();
		board.createBoard(8, 8);
		board.createFigures();
		
		// Start the turn system
		turnSystem.startTheGame();
				
		// Starting the game
		game.startGame();
		
		
	}
	
}
