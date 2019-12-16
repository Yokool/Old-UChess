package com.EKEY.Board.ChessFigures.Builder;

import java.awt.Image;
import java.util.LinkedList;

import com.EKEY.Board.ChessFigures.Figure;
import com.EKEY.Board.ChessFigures.Knight;
import com.EKEY.Board.ChessFigures.Movement.Movement;

public class KnightBuilder extends FigureBuilder{
	
	Knight knight = new Knight();
	
	@Override
	public void reset() {
		knight = new Knight();
	}

	@Override
	public void setX(int x) {
		knight.setX(x);
	}

	@Override
	public void setY(int y) {
		knight.setY(y);
	}

	@Override
	public void setWidth(int width) {
		knight.setWidth(width);
	}

	@Override
	public void setHeight(int height) {
		knight.setHeight(height);
	}

	@Override
	public void setImage(Image img) {
		knight.setFigureImage(img);
	}

	@Override
	public Figure getResult() {
		Knight bk = knight;
		this.reset();
		return bk;
	}
	
	@Override
	public void setMovement(Movement mov) {
		knight.addMovement(mov);
	}

	@Override
	public void setMovementSet(LinkedList<Movement> mov) {
		knight.addMovementSet(mov);
	}

}
