package com.EKEY.Board.Builder;

import com.EKEY.Board.BoardTile;
import com.EKEY.Board.ChessFigures.Figure;

/**
 * A director that can create all variaties of BoardTiles
 */
public class TileDirector {
	
	/**
	 * A method to create a standart empty (with no figure) tile, with no figures and the color with the type of
	 * object we are creating.
	 * 
	 * @param builder - The builder of the type we are trying to create.
	 * @return
	 */
	public BoardTile createEmptyTile(BoardTileBuilder builder) {
		
		builder.setX(0);
		builder.setY(0);
		builder.setWidth(128);
		builder.setHeight(128);
		builder.setColor( builder.getUnifinshedProduct().getColor() ); // <--- get the actual color of the tile
		builder.setFigure(null);
		
		return builder.getResult();
		
	}
	
	
}
