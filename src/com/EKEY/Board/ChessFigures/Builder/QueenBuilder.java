package com.EKEY.Board.ChessFigures.Builder;

import java.awt.Image;
import java.util.LinkedList;

import com.EKEY.Board.ChessFigures.ColorEnum;
import com.EKEY.Board.ChessFigures.Queen;
import com.EKEY.Board.ChessFigures.Movement.Movement;

public class QueenBuilder extends FigureBuilder{
	
	Queen queen = new Queen();

	@Override
	public void reset() {
		queen = new Queen();
	}

	@Override
	public void setX(int x) {
		queen.setX(x);
	}

	@Override
	public void setY(int y) {
		queen.setY(y);
	}

	@Override
	public void setWidth(int width) {
		queen.setWidth(width);
	}

	@Override
	public void setHeight(int height) {
		queen.setHeight(height);
	}

	@Override
	public void setImage(Image img) {
		queen.setFigureImage(img);
	}

	@Override
	public Queen getResult() {
		Queen bq = queen;
		this.reset();
		return bq;
	}
	
	@Override
	public void setMovement(Movement mov) {
		queen.addMovement(mov);
	}

	@Override
	public void setMovementSet(LinkedList<Movement> mov) {
		queen.addMovementSet(mov);
	}
	
	@Override
	public void setColor(ColorEnum color) {
		queen.setColorEnum(color);
	}
	
}
