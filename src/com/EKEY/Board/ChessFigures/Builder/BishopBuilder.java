package com.EKEY.Board.ChessFigures.Builder;

import java.awt.Image;
import java.util.LinkedList;

import com.EKEY.Board.ChessFigures.Bishop;
import com.EKEY.Board.ChessFigures.Figure;
import com.EKEY.Board.ChessFigures.Movement.Movement;

public class BishopBuilder extends FigureBuilder{
	
	private Bishop bishop = new Bishop();
	
	@Override
	public void reset() {
		bishop = new Bishop();
	}

	@Override
	public void setX(int x) {
		bishop.setX(x);
	}

	@Override
	public void setY(int y) {
		bishop.setY(y);
	}

	@Override
	public void setWidth(int width) {
		bishop.setWidth(width);
	}

	@Override
	public void setHeight(int height) {
		bishop.setHeight(height);
	}

	@Override
	public void setImage(Image img) {
		bishop.setFigureImage(img);
	}

	@Override
	public Figure getResult() {
		
		Bishop bs = bishop;
		this.reset();
		return bs;
	}

	@Override
	public void setMovement(Movement mov) {
		bishop.addMovement(mov);
	}

	@Override
	public void setMovementSet(LinkedList<Movement> mov) {
		bishop.addMovementSet(mov);
	}

}
