package com.EKEY.Board.ChessFigures.Builder;

import java.awt.Image;

import com.EKEY.Board.ChessFigures.Figure;
import com.EKEY.Board.ChessFigures.Queen;

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
	
}
