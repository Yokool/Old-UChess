package com.EKEY.Board.ChessFigures.Builder;

import java.awt.Image;

import com.EKEY.Board.ChessFigures.Bishop;
import com.EKEY.Board.ChessFigures.Figure;

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

}
