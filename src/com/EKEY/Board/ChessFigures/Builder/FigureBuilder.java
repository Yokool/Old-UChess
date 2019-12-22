package com.EKEY.Board.ChessFigures.Builder;

import java.awt.Image;
import java.util.LinkedList;

import com.EKEY.Board.ChessFigures.ColorEnum;
import com.EKEY.Board.ChessFigures.Figure;
import com.EKEY.Board.ChessFigures.Movement.Movement;

public class FigureBuilder {
	
	private Figure figure = new Figure();
	
	public void reset() {
		figure = new Figure();
	}
	
	public void setX(int x) {
		figure.setX(x);
	}
	
	public void setY(int y) {
		figure.setY(y);
	}
	
	public void setWidth(int width) {
		figure.setWidth(width);
	}
	
	public void setHeight(int height) {
		figure.setHeight(height);
	}
	
	public void setImage(Image img) {
		figure.setFigureImage(img);
	}
	
	public void setMovement(Movement mov) {
		figure.addMovement(mov);
	}
	
	public void setMovementSet(LinkedList<Movement> mov) {
		figure.addMovementSet(mov);
	}
	
	public void setColor(ColorEnum color) {
		figure.setColorEnum(color);
	}
	
	public Figure getResult() {
		
		Figure fig = figure;
		this.reset();
		return fig;
	}
	
}
