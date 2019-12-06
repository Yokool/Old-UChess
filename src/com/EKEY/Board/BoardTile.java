package com.EKEY.Board;

import com.EKEY.GameObject;
import com.EKEY.Board.ChessFigures.Figure;

/**
 * A class representing a single tile inside the Board.
 */
public class BoardTile extends GameObject{
	
	public BoardTile(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	/**
	 * The figure that is currently on the tile.
	 */
	private Figure tileFigure = null;
	
	
	
	public Figure getTileFigure() {
		return tileFigure;
	}

	public void setTileFigure(Figure tileFigure) {
		this.tileFigure = tileFigure;
	}

	@Override
	public void render() {
		
	}

	@Override
	public void tick() {
		
	}
	
	
	
}
