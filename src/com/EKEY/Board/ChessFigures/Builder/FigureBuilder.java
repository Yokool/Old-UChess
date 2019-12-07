package com.EKEY.Board.ChessFigures.Builder;

import java.awt.Image;

import com.EKEY.Board.ChessFigures.Figure;

public abstract class FigureBuilder {
	
	public abstract void reset();
	
	public abstract void setX(int x);
	public abstract void setY(int y);
	
	public abstract void setWidth(int width);
	public abstract void setHeight(int height);
	
	public abstract void setImage(Image img);
	
	public abstract Figure getResult();
	
}
