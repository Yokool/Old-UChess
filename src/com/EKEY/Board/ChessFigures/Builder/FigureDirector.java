package com.EKEY.Board.ChessFigures.Builder;

import java.awt.Image;

import com.EKEY.Board.BoardTile;
import com.EKEY.Board.ChessFigures.Figure;
import com.EKEY.Misc.DataShare;

public class FigureDirector {
	
	public FigureDirector() {
		DataShare.FIGUREDIRECTOR = this;
	}
	
	public Figure createFigureOnTile(FigureBuilder builder, BoardTile tile, Image figureImage) {
		
		builder.setX(tile.getX());
		builder.setY(tile.getY());
		
		builder.setWidth(128);
		builder.setHeight(128);
		
		builder.setImage(figureImage);
		
		return builder.getResult();
	}
	
}
