package com.EKEY.Board;

import java.awt.Color;

import com.EKEY.Board.Builder.NormalTileBuilder;
import com.EKEY.Board.Builder.TileDirector;
import com.EKEY.Misc.DataShare;

/**
 * A class that represents the chess board. It acts as a sort of a
 * wrappe since the object contains a BoardTile multidimensional array, which holds all the board tiles.
 * You can make a board of any size as long as the width and height
 * is bigger than 8.
 */
public class Board {
	
	private NormalTileBuilder NormalTILEBuilder = new NormalTileBuilder();
	private TileDirector tileDirector = new TileDirector();
	
	public Board() {
		DataShare.BOARD = this;
	}
	
	/**
	 * A multidimensional array which holds all the tiles.
	 * [height],[width]
	 * You can access any tile with this array.
	 */
	private BoardTile[][] tiles = null;
	
	/**
	 * A method that 
	 * 
	 * @param boardWidth - The width of the board, can't be less than 8.
	 * @param boardHeight - The height of the board, can't be less than 8.
	 */
	public void createBoard(int boardWidth, int boardHeight) {
		
		if(boardWidth < 8 || boardHeight < 8) {
			throw new IllegalArgumentException("createBoard was called with the wrong parameters.");
		}
		
		boolean coloroddness = true;
		
		tiles = new BoardTile[boardHeight][boardWidth];
		
		for(int height = 0; height < boardHeight; height++) {
			
			coloroddness = !coloroddness;
			
			for(int width = 0; width < boardWidth; width++) {
				
				BoardTile tile = tileDirector.createEmptyTile(NormalTILEBuilder);
				tile.setX(width * 128);
				tile.setY(height * 128);
				
				if(!coloroddness) {
					tile.setColor(new Color(238, 238, 210));
					coloroddness = true;
				}else {
					tile.setColor(new Color(118, 150, 86));
					coloroddness = false;
				}
				
				
				tiles[height][width] = tile;
				
				DataShare.HANDLER.registerTick(tile);
				DataShare.HANDLER.registerRender(tile);
				
			}
			
		}
	}
	
	public void createFigures() {
		
	}
	
	public BoardTile getTileByLoc(int height, int width) {
		return tiles[height][width];
	}

	public BoardTile[][] getTiles() {
		return tiles;
	}

	public void setTiles(BoardTile[][] tiles) {
		this.tiles = tiles;
	}

	
	
}
