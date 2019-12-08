package com.EKEY.Board.ChessFigures.Builder;

import java.awt.Image;

import com.EKEY.Board.ChessFigures.Figure;
import com.EKEY.Board.ChessFigures.King;

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
	
	
	
}
