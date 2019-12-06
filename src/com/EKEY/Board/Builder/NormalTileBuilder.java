package com.EKEY.Board.Builder;

import java.awt.Color;

import com.EKEY.Board.BoardTile;
import com.EKEY.Board.NormalTile;
import com.EKEY.Board.ChessFigures.Figure;
import com.EKEY.Misc.DataShare;

public class NormalTileBuilder extends BoardTileBuilder{
	
	private NormalTile tile = new NormalTile(0, 0, 0, 0);
	
	@Override
	public void reset() {
		tile = new NormalTile(0, 0, 0, 0);
	}
	
	@Override
	public NormalTile getResult() {
		
		NormalTile buffTile = tile.clone();
		this.reset();
		return buffTile;
		
	}

	@Override
	public void setX(int x) {
		tile.setX(x);
	}

	@Override
	public void setY(int y) {
		tile.setY(y);
	}

	@Override
	public void setWidth(int width) {
		tile.setWidth(width);
	}

	@Override
	public void setHeight(int height) {
		tile.setHeight(height);
	}

	@Override
	public void setColor(Color color) {
		tile.setColor(color);
	}

	@Override
	public void setFigure(Figure figure) {
		tile.setTileFigure(figure);
	}

	@Override
	public BoardTile getUnifinshedProduct() {
		return tile;
	}

}
