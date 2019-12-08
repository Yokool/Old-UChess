package com.EKEY.Board.ChessFigures.Builder;

import java.awt.Image;

import com.EKEY.Board.ChessFigures.Figure;
import com.EKEY.Board.ChessFigures.Rook;

public class RookBuilder extends FigureBuilder{
	
	Rook rook = new Rook();
	
	@Override
	public void reset() {
		rook = new Rook();
	}

	@Override
	public void setX(int x) {
		rook.setX(x);
	}

	@Override
	public void setY(int y) {
		rook.setY(y);
	}

	@Override
	public void setWidth(int width) {
		rook.setWidth(width);
	}

	@Override
	public void setHeight(int height) {
		rook.setHeight(height);
	}

	@Override
	public void setImage(Image img) {
		rook.setFigureImage(img);
	}

	@Override
	public Figure getResult() {
		Rook br = rook;
		this.reset();
		return br;
	}

}