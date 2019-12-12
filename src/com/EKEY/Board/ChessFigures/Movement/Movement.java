package com.EKEY.Board.ChessFigures.Movement;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import com.EKEY.Board.BoardTile;
import com.EKEY.Board.ChessFigures.Figure;
import com.EKEY.Misc.Camera;
import com.EKEY.Misc.DataShare;

public class Movement {
	
	private Figure figure;
	
	private int xStep = 0;
	
	
	private int yStep = 0;
	
	private int repeat = 0;
	

	private ArrayList<BoardTile> bufferList = new ArrayList<BoardTile>();
	
	
	// xCoords =   1, 10 - Go 1 step 10 tmies
	// first param - step, second param is number of repeats
	
	public Movement(int xStep, int yStep, int repeat) {
		
		this.xStep = xStep;
		this.repeat = repeat;
		this.yStep = yStep;
		
	}
	
	public void recalc() {
		
		int xTracker = 0;
		int yTracker = 0;
		
		for(int i = 0; i < repeat; i++) {
			xTracker += xStep;
			yTracker += yStep;
			
			bufferList.add(DataShare.BOARD.getTileByLoc(figure.getTileY() + yTracker, figure.getTileX() + xTracker) );
		}
		
	}
	
	public void renderOptions(Graphics g) {
		bufferList.clear();
		recalc();
		
		for(BoardTile tile : bufferList) {
			Camera cam = Camera.getInstance();
			g.setColor(new Color(0.0f, 0.0f, 0.0f, 0.5f));
			g.fillOval(tile.getX() - cam.getCameraX() + 47, tile.getY() - cam.getCameraY() + 47, 32, 32);
			
		}
		
	}
	
	public static void Setup(Figure f, Movement m) {
		f.setMovement(m);
		m.setFigure(f);
	}
	
	// TODO: NOT IMPLEMENTED YET
	@Deprecated
	public void moveFigure(BoardTile tile) {
		
	}

	public void setFigure(Figure figure) {
		this.figure = figure;
	}
	
	
	
	
}
