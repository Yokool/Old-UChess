package com.EKEY.Board;

import java.awt.Color;
import java.awt.Graphics;

import com.EKEY.GameObject;
import com.EKEY.Board.ChessFigures.Figure;

/**
 * An abstract class representing a single tile inside the Board.
 * A super class of all tiles, the tile has its color that will be displayed.
 */
public abstract class BoardTile extends GameObject{
	
	protected Color color;
	
	/**
	 * The figure that is currently on the tile.
	 */
	private Figure tileFigure = null;
	
	
	public BoardTile() {
		super();
	}
	
	@Override
	public void render(Graphics g) {
		
		g.setColor(color);
		g.fillRect(x, y, width, height);
		
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
