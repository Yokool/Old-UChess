package com.EKEY.Board.ChessFigures.Builder;

import java.awt.Image;

import com.EKEY.Board.BoardTile;
import com.EKEY.Board.ChessFigures.Figure;

public class FigureDirector {
	
	private static FigureDirector INSTANCE;
	
	private FigureDirector() {
		
	}
	
	public static FigureDirector getInstance() {
		
		if(INSTANCE == null) {
			INSTANCE = new FigureDirector();
		}
		
		return INSTANCE;
		
	}
	
	public Figure createFigureOnTile(FigureBuilder builder, BoardTile tile, Image figureImage) {
		
		builder.setX(tile.getX());
		builder.setY(tile.getY());
		
		builder.setWidth(128);
		builder.setHeight(128);
		
		builder.setImage(figureImage);
		
		return builder.getResult();
		
	}

	public Figure createStandartFigure(FigureBuilder builder, Image figureImage) {
		
		builder.setX(0);
		builder.setY(0);
		
		builder.setWidth(128);
		builder.setHeight(128);
		
		builder.setImage(figureImage);
		
		return builder.getResult();
	}
	
	
}
