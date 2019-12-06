package com.EKEY.Board.Builder;

import java.awt.Color;

import com.EKEY.Board.BoardTile;
import com.EKEY.Board.ChessFigures.Figure;

/**
 * A board tile builder, that methods to set the boardtiles.
 */
public abstract class BoardTileBuilder {
	
	public abstract void reset();
	
	public abstract void setX(int x);
	public abstract void setY(int y);
	
	public abstract void setWidth(int width);
	public abstract void setHeight(int height);
	
	public abstract void setColor(Color color);
	public abstract void setFigure(Figure figure);
	
	public abstract BoardTile getResult();
	public abstract BoardTile getUnifinshedProduct();
	
}
