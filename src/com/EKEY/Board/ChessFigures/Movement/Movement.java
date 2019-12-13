package com.EKEY.Board.ChessFigures.Movement;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import com.EKEY.Board.BoardTile;
import com.EKEY.Board.ChessFigures.Figure;
import com.EKEY.Misc.Camera;
import com.EKEY.Misc.DataShare;

public abstract class Movement {
	
	protected Figure figure;
	
	protected ArrayList<BoardTile> bufferList = new ArrayList<BoardTile>();
	
	
	// xCoords =   1, 10 - Go 1 step 10 tmies
	// first param - step, second param is number of repeats
	
	public Movement(Figure figure) {
		this.figure = figure;
	}
	
	
	protected abstract void recalc();
	
	public void renderOptions(Graphics g) {
		bufferList.clear();
		recalc();
		
		for(BoardTile tile : bufferList) {
			Camera cam = Camera.getInstance();
			g.setColor(new Color(0.0f, 0.0f, 0.0f, 0.5f));
			g.fillOval(tile.getX() - cam.getCameraX() + 47, tile.getY() - cam.getCameraY() + 47, 32, 32);
			
		}
		
	}
	
	// TODO: NOT IMPLEMENTED YET
	@Deprecated
	public void moveFigure(BoardTile tile) {
		
	}

	public void setFigure(Figure figure) {
		this.figure = figure;
	}
	
	
	
	
}
