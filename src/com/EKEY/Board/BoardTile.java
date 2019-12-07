package com.EKEY.Board;

import java.awt.Color;
import java.awt.Graphics;

import com.EKEY.GameObject;
import com.EKEY.Board.ChessFigures.Figure;
import com.EKEY.Misc.DataShare;

/**
 * An abstract class representing a single tile inside the Board.
 * A super class of all tiles, the tile has its color that will be displayed.
 */
public abstract class BoardTile extends GameObject implements Cloneable{
	
	
	protected Color color;
	
	/**
	 * The figure that is currently on the tile.
	 */
	private Figure tileFigure = null;
	
	public BoardTile(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	
	// A constructor for cloning objects
	public BoardTile(BoardTile tiletoclone) {
		super(tiletoclone);
		this.color = tiletoclone.getColor();
	}
	
	@Override
	public void render(Graphics g) {
		
		g.setColor(color);
		
		g.fillRect(x - DataShare.CAMERA.getCameraX(), y - DataShare.CAMERA.getCameraY(), width, height);
		
	}
	
	public Figure getTileFigure() {
		return tileFigure;
	}

	public void setTileFigure(Figure tileFigure) {
		this.tileFigure = tileFigure;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	
	
}
