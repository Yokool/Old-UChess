package com.EKEY.Board;

import java.awt.Color;
import java.util.function.Consumer;

import com.EKEY.Board.Builder.NormalTileBuilder;
import com.EKEY.Board.Builder.TileDirector;
import com.EKEY.Board.ChessFigures.Figure;
import com.EKEY.Board.ChessFigures.Prototypes.FigurePrototypes;
import com.EKEY.Misc.DataShare;

/**
 * A class that represents the chess board. It acts as a sort of a wrappe since
 * the object contains a BoardTile multidimensional array, which holds all the
 * board tiles. You can make a board of any size as long as the width and height
 * is bigger than 8.
 */
public class Board {

	private NormalTileBuilder NormalTILEBuilder = new NormalTileBuilder();
	private TileDirector tileDirector = new TileDirector();
	
	private int boardWidth = 0;
	private int boardHeight = 0;

	public Board() {
		DataShare.BOARD = this;
	}

	/**
	 * A multidimensional array which holds all the tiles. [height],[width] You can
	 * access any tile with this array.
	 */
	private BoardTile[][] tiles = null;

	/**
	 * A method that creates the board with the specified parameters.
	 * 
	 * @param boardWidth  - The width of the board, can't be less than 8.
	 * @param boardHeight - The height of the board, can't be less than 8.
	 */
	public void createBoard(int boardWidth, int boardHeight) {

		if (boardWidth < 8 || boardHeight < 8) {
			throw new IllegalArgumentException("createBoard was called with the wrong parameters.");
		}

		this.boardWidth = boardWidth;
		this.boardHeight = boardHeight;

		boolean coloroddness = true;

		boolean even = false;
		if (boardWidth % 2 == 0) {
			even = true;
		}

		tiles = new BoardTile[boardHeight][boardWidth];

		for (int height = 0; height < boardHeight; height++) {

			if (even) {
				coloroddness = !coloroddness;
			}

			for (int width = 0; width < boardWidth; width++) {

				BoardTile tile = tileDirector.createEmptyTile(NormalTILEBuilder);
				tile.setX(width * 128);
				tile.setY(height * 128);
				
				
				if (!coloroddness) {
					tile.setColor(new Color(238, 238, 210));
					coloroddness = true;
				} else {
					tile.setColor(new Color(118, 150, 86));
					coloroddness = false;
				}

				tiles[height][width] = tile;
				tile.setTileDimension(width, height);
				
				
				DataShare.HANDLER.registerTick(tile);
				DataShare.HANDLER.registerRender(tile);
				DataShare.HANDLER.registerClickable(tile);

			}

		}
	}
	
	/**
	 * A method that creates all the starter figures.
	 */
	public void createFigures() {
		
		int centerCord = (int) (this.boardWidth * 0.5) - 1; // we are subtracting 1 since the tiles are 0 based
		
		int DividerWidth = (int)((this.boardWidth - 2) * 0.5);
		
		// Initializing black pawns
		for(int width = 0; width < boardWidth; width++) {
			BoardTile tile_z = this.getTileByLoc(1, width);
			Figure p = FigurePrototypes.getPawn_black();
			
			setupInitialTile(p, tile_z);
			
		}
		
		// black queen
		BoardTile tile_x = this.getTileByLoc(0, centerCord);
		Figure q_b = FigurePrototypes.getQueen_black();
		setupInitialTile(q_b, tile_x);
		
		// black king
		BoardTile tile_y = this.getTileByLoc(0, centerCord + 1);
		Figure k_b = FigurePrototypes.getKing_black();
		this.setupInitialTile(k_b, tile_y);
		
		int SecondDivider = (int)(DividerWidth / 3.0);
		
		// other black figures - left side
		for(int width = 0; width < DividerWidth; width++) {
			
			if(width < SecondDivider) {
				
				// rooks
				BoardTile tile = this.getTileByLoc(0, width);
				Figure r_b = FigurePrototypes.getRook_black();
				setupInitialTile(r_b, tile);
				
				
				BoardTile _tile = this.getTileByLoc(0, this.boardWidth - width - 1);
				Figure r2_b = FigurePrototypes.getRook_black();
				setupInitialTile(r2_b, _tile);
				
				
			}else if (width < SecondDivider*2) {
				// knights
				BoardTile tile = this.getTileByLoc(0, width);
				Figure kn_b = FigurePrototypes.getKnight_black();
				setupInitialTile(kn_b, tile);
				
				BoardTile _tile = this.getTileByLoc(0, this.boardWidth - width - 1);
				Figure kn2_b = FigurePrototypes.getKnight_black();
				setupInitialTile(kn2_b, _tile);
				
			}else {
				// bishops
				BoardTile tile = this.getTileByLoc(0, width);
				Figure b_b = FigurePrototypes.getBishop_black();
				this.setupInitialTile(b_b, tile);
				
				BoardTile _tile = this.getTileByLoc(0, this.boardWidth - width - 1);
				Figure b2_b = FigurePrototypes.getBishop_black();
				this.setupInitialTile(b2_b, _tile);
				
			}
			
			
			
		}
		
		// Initializing white pawns
		for(int width = 0; width < boardWidth; width++) {
			BoardTile tile_a = this.getTileByLoc(boardHeight - 2, width);
			
			Figure p = FigurePrototypes.getPawn_white();
			
			setupInitialTile(p, tile_a);
		}
		
		// white queen
		BoardTile tile_b = this.getTileByLoc(boardHeight - 1, centerCord);
		Figure q_w = FigurePrototypes.getQueen_white();
		setupInitialTile(q_w, tile_b);
		
		// white king
		BoardTile tile_c = this.getTileByLoc(boardHeight - 1, centerCord + 1);
		Figure k_w = FigurePrototypes.getKing_white();
		setupInitialTile(k_w, tile_c);
		
		// other black figures - left side
		for (int width = 0; width < DividerWidth; width++) {

			if (width < SecondDivider) {
				// rooks
				BoardTile tile_d = this.getTileByLoc(this.boardHeight - 1, width);
				Figure r_w = FigurePrototypes.getRook_white();
				setupInitialTile(r_w, tile_d);
				
				
				BoardTile tile_e = this.getTileByLoc(this.boardHeight - 1, this.boardWidth - width - 1);
				Figure r2_w = FigurePrototypes.getRook_white();
				setupInitialTile(r2_w, tile_e);
				

			} else if (width < SecondDivider * 2) {
				// knights
				BoardTile tile_f = this.getTileByLoc(this.boardHeight - 1, width);
				Figure kn_w = FigurePrototypes.getKnight_white();
				setupInitialTile(kn_w, tile_f);
				
				BoardTile tile_g = this.getTileByLoc(this.boardHeight - 1, this.boardWidth - width - 1);
				Figure kn2_w = FigurePrototypes.getKnight_white();
				setupInitialTile(kn2_w, tile_g);
				
				
			} else {
				// bishops
				BoardTile tile_h = this.getTileByLoc(this.boardHeight - 1, width);
				Figure b_w = FigurePrototypes.getBishop_white();
				setupInitialTile(b_w, tile_h);
				
				BoardTile tile_i = this.getTileByLoc(this.boardHeight - 1, this.boardWidth - width - 1);
				Figure b2_w = FigurePrototypes.getBishop_white();
				setupInitialTile(b2_w, tile_i);
				
			}
					
					
		}
	}
	
	/**
	 * Used during world generation to setup figures and tiles in bulk.
	 * @param figure
	 * @param tile
	 */
	private void setupInitialTile(Figure figure, BoardTile tile) {
		
		figure.setX(tile.getX());
		figure.setY(tile.getY());
		
		
		Board.setTileCoords(figure, tile);
		
		DataShare.HANDLER.registerTick(figure);
		DataShare.HANDLER.registerFigureRender(figure);
		DataShare.HANDLER.registerClickable(figure);
		
	}
	
	/**
	 * A helper method that sets the variables for figure and tile. IE. When moving a figure, this method should be called to easily
	 * set the needed variables.
	 * 
	 * @param figure Figure being set.
	 * @param tile The BoardTile being set.
	 */
	public static void setTileCoords(Figure figure, BoardTile tile) {
		
		figure.setTileX(tile.getTileX());
		figure.setTileY(tile.getTileY());
		
		tile.setTileFigure(figure);
		
	}
	
	/**
	 * A helper method that returns a tile with the specified coordinates, from the Board this method is being called on.
	 * 
	 * @param height The height of the tile we are searching for. 
	 * @param width The width of the tile we are searching for.
	 * @return
	 */
	public BoardTile getTileByLoc(int height, int width) {
		BoardTile tilereturn = null;
		try {
			tilereturn = tiles[height][width];
		}catch(Exception ex) {
			//System.err.println("getTileByLoc failed to find a cell with params: " + height + ", " + width);
		}
		
		return tilereturn;
	}
	
	public void moveFigureToTile(Figure figure, BoardTile tile) {
		
		BoardTile curTile = this.getTileByLoc(figure.getTileY(), figure.getTileX());
		System.out.println("Moving figure from: X:" + curTile.getTileX() + " Y: " + curTile.getTileY() + " to X: " + tile.getTileX() + " Y: " + tile.getTileY());
		
		if(tile.getTileFigure() != null) {
			return;
		}
		
		curTile.setTileFigure(null);
		tile.setTileFigure(figure);
		
		figure.setX(tile.getX());
		figure.setY(tile.getY());
		
		figure.setTileX(tile.getTileX());
		figure.setTileY(tile.getTileY());
		
		

	}

	public BoardTile[][] getTiles() {
		return tiles;
	}

	public void setTiles(BoardTile[][] tiles) {
		this.tiles = tiles;
	}
	
	public void castRay(BoardTile start, Directions dir, int limit, Consumer<BoardTile> con) { // TODO: STEP REFACTOR
		
		for(int loc = 0; loc <= limit; loc++) {
			BoardTile t = step(start , dir, loc);
			con.accept(t);
		}
		
	}
	
	public BoardTile step(BoardTile start, Directions dir, int amount) {
		
		BoardTile returnB = null;
		
		switch(dir) {
		
		case EAST:
			returnB = this.getTileByLoc(start.getTileY(), start.getTileX() + amount);
			break;
		case NORTH:		
			returnB = this.getTileByLoc(start.getTileY() - amount, start.getTileX());	
			break;
		case SOUTH:	
			returnB = this.getTileByLoc(start.getTileY() + amount, start.getTileX());
			break;
		case WEST:
			returnB = this.getTileByLoc(start.getTileY(), start.getTileX() - amount);
			break;
		}
		
		return returnB;
		
	}
	
	public void castSqure(BoardTile start, int radius, Consumer<BoardTile> con) {

		// casting rays in all four directions
		castRay(start, Directions.SOUTH, radius, tile -> {
			con.accept(tile);
		});
		
		// right corner cube
		for(int x = start.getTileX() + 1; x <= start.getTileX() + radius; x++) {
			
			for(int y = start.getTileY() - 1; y >= start.getTileY() - radius; y--) {
				
				BoardTile tile = this.getTileByLoc(y, x);
				con.accept(tile);
				
			}
			
		}
		
		castRay(start, Directions.WEST, radius, tile -> {
			con.accept(tile);
		});
		
		for(int x = start.getTileX() + 1; x <= start.getTileX() + radius; x++) {
			
			for(int y = start.getTileY() + 1; y <= start.getTileY() + radius; y++) {
				
				BoardTile tile = this.getTileByLoc(y, x);
				con.accept(tile);
				
			}
			
		}
		
		castRay(start, Directions.SOUTH, radius, tile -> {
			con.accept(tile);
		});
		
		for(int x = start.getTileX() - 1; x >= start.getTileX() - radius; x--) {
			
			for(int y = start.getTileY() + 1; y <= start.getTileY() + radius; y++) {
				
				BoardTile tile = this.getTileByLoc(y, x);
				con.accept(tile);
				
			}
			
		}
		
		castRay(start, Directions.EAST, radius, tile -> {
			con.accept(tile);
		});
		
		for(int x = start.getTileX() - 1; x >= start.getTileX() - radius; x--) {
			
			for(int y = start.getTileY() - 1; y >= start.getTileY() - radius; y--) {
				
				BoardTile tile = this.getTileByLoc(y, x);
				con.accept(tile);
				
			}
			
		}
		
		
	}
	
}

enum Directions{
	
	NORTH,
	EAST,
	WEST,
	SOUTH
	
}
