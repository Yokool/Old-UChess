package com.EKEY.Board.ChessFigures.Movement;

import java.awt.Graphics;

import com.EKEY.Board.BoardTile;
import com.EKEY.Board.ChessFigures.Figure;

public abstract class Movement {
	
	protected Figure linkedFigure;
	
	public Movement(Figure figure) {
		
		this.linkedFigure = figure;
		
	}
	
	public abstract void renderOptions(Graphics g);
	public abstract void moveFigure(BoardTile tile);
	
}
