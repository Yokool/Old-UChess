package com.EKEY.Board.ChessFigures.Builder;

import java.awt.Image;
import java.util.LinkedList;

import com.EKEY.Board.ChessFigures.Figure;
import com.EKEY.Board.ChessFigures.King;
import com.EKEY.Board.ChessFigures.Movement.Movement;

public class KingBuilder extends FigureBuilder{
	
	public King king = new King();
	
	@Override
	public void reset() {
		king = new King();
	}

	@Override
	public void setX(int x) {
		king.setX(x);
	}

	@Override
	public void setY(int y) {
		king.setY(y);
	}

	@Override
	public void setWidth(int width) {
		king.setWidth(width);
	}

	@Override
	public void setHeight(int height) {
		king.setHeight(height);
	}

	@Override
	public void setImage(Image img) {
		king.setFigureImage(img);
	}

	@Override
	public Figure getResult() {
		King bk = king;
		this.reset();
		return bk;
	}
	
	@Override
	public void setMovement(Movement mov) {
		king.addMovement(mov);
	}

	@Override
	public void setMovementSet(LinkedList<Movement> mov) {
		king.addMovementSet(mov);
	}
	
}
