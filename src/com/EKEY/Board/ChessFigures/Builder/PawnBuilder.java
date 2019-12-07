package com.EKEY.Board.ChessFigures.Builder;

import java.awt.Image;

import com.EKEY.Board.ChessFigures.Pawn;

public class PawnBuilder extends FigureBuilder{
	
	Pawn pawn = new Pawn();

	@Override
	public void reset() {
		pawn = new Pawn();
	}

	@Override
	public void setX(int x) {
		pawn.setX(x);
	}

	@Override
	public void setY(int y) {
		pawn.setY(y);
	}

	@Override
	public void setWidth(int width) {
		pawn.setWidth(width);
	}

	@Override
	public void setHeight(int height) {
		pawn.setHeight(height);
	}

	@Override
	public void setImage(Image img) {
		pawn.setFigureImage(img);
	}

	@Override
	public Pawn getResult() {
		
		Pawn bP = pawn;
		reset();
		return bP;
		
	}
	
}
