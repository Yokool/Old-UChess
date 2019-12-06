package com.EKEY.Board;

/**
 * A class that represents the chess board. It acts as a sort of a
 * wrappe since the object contains a BoardTile multidimensional array, which holds all the board tiles.
 * You can make a board of any size as long as the width and height
 * is bigger than 8.
 */
public class Board {
	
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
		
		tiles = new BoardTile[boardHeight][boardWidth];
		
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
