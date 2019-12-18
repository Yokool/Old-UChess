package com.EKEY.Board.ChessFigures.Builder;

import java.awt.Image;
import java.util.LinkedList;

import com.EKEY.Board.ChessFigures.ColorEnum;
import com.EKEY.Board.ChessFigures.Figure;
import com.EKEY.Board.ChessFigures.Movement.Movement;

public abstract class FigureBuilder {
	
	public abstract void reset();
	
	public abstract void setX(int x);
	public abstract void setY(int y);
	
	public abstract void setWidth(int width);
	public abstract void setHeight(int height);
	
	public abstract void setImage(Image img);
	
	public abstract void setMovement(Movement mov);
	public abstract void setMovementSet(LinkedList<Movement> mov);
	
	public abstract void setColor(ColorEnum color);
	
	public abstract Figure getResult();
	
}
