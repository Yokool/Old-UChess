package com.EKEY.Board;

import java.awt.Color;

import com.EKEY.Board.Builder.NormalTileBuilder;
import com.EKEY.Board.Builder.TileDirector;
import com.EKEY.Board.ChessFigures.Bishop;
import com.EKEY.Board.ChessFigures.Figure;
import com.EKEY.Board.ChessFigures.King;
import com.EKEY.Board.ChessFigures.Knight;
import com.EKEY.Board.ChessFigures.Pawn;
import com.EKEY.Board.ChessFigures.Queen;
import com.EKEY.Board.ChessFigures.Rook;
import com.EKEY.Board.ChessFigures.Builder.BishopBuilder;
import com.EKEY.Board.ChessFigures.Builder.KingBuilder;
import com.EKEY.Board.ChessFigures.Builder.KnightBuilder;
import com.EKEY.Board.ChessFigures.Builder.PawnBuilder;
import com.EKEY.Board.ChessFigures.Builder.QueenBuilder;
import com.EKEY.Board.ChessFigures.Builder.RookBuilder;
import com.EKEY.Files.UChessImages;
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

	private PawnBuilder pawnBuilder = new PawnBuilder();
	private QueenBuilder queenBuilder = new QueenBuilder();
	private KingBuilder kingBuilder = new KingBuilder();
	private RookBuilder rookBuilder = new RookBuilder();
	private KnightBuilder knightBuilder = new KnightBuilder();
	private BishopBuilder bishopBuilder = new BishopBuilder();

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
	 * A method that
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

		boolean odd = false;
		if (boardWidth % 3 == 0 || boardWidth % 3 == 0) {
			odd = true;
		}

		tiles = new BoardTile[boardHeight][boardWidth];

		for (int height = 0; height < boardHeight; height++) {

			if (!odd) {
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

			}

		}
	}

	public void createFigures() {
		
		int centerCord = (int) (this.boardWidth * 0.5) - 1; // we are subtracting 1 since the tiles are 0 based
		
		int DividerWidth = (int)((this.boardWidth - 2) * 0.5);
		
		// Initializing black pawns
		for(int width = 0; width < boardWidth; width++) {
			BoardTile tile_z = this.getTileByLoc(1, width);
			Pawn p = (Pawn) DataShare.FIGUREDIRECTOR.createFigureOnTile(pawnBuilder, tile_z, UChessImages.pawn_black);
			setupInitialTile(p, tile_z);
			
		}
		
		// black queen
		BoardTile tile_x = this.getTileByLoc(0, centerCord);
		Queen q_b = (Queen) DataShare.FIGUREDIRECTOR.createFigureOnTile(queenBuilder, tile_x, UChessImages.queen_black);
		setupInitialTile(q_b, tile_x);
		
		// black king
		BoardTile tile_y = this.getTileByLoc(0, centerCord + 1);
		King k_b = (King) DataShare.FIGUREDIRECTOR.createFigureOnTile(kingBuilder, tile_y, UChessImages.king_black);
		this.setupInitialTile(k_b, tile_y);
		
		
		int SecondDivider = (int)(DividerWidth / 3.0);
		
		// other black figures - left side
		for(int width = 0; width < DividerWidth; width++) {
			
			if(width < SecondDivider) {
				
				// rooks
				BoardTile tile = this.getTileByLoc(0, width);
				Rook r_b = (Rook) DataShare.FIGUREDIRECTOR.createFigureOnTile(rookBuilder, tile, UChessImages.rook_black);
				setupInitialTile(r_b, tile);
				
				BoardTile _tile = this.getTileByLoc(0, this.boardWidth - width - 1);
				Rook r2_b = (Rook) DataShare.FIGUREDIRECTOR.createFigureOnTile(rookBuilder, _tile, UChessImages.rook_black);
				setupInitialTile(r2_b, _tile);
				
			}else if (width < SecondDivider*2) {
				// knights
				BoardTile tile = this.getTileByLoc(0, width);
				Knight kn_b = (Knight) DataShare.FIGUREDIRECTOR.createFigureOnTile(knightBuilder, tile, UChessImages.knight_black);
				setupInitialTile(kn_b, tile);
				
				BoardTile _tile = this.getTileByLoc(0, this.boardWidth - width - 1);
				Knight kn2_b = (Knight) DataShare.FIGUREDIRECTOR.createFigureOnTile(knightBuilder, _tile, UChessImages.knight_black);
				setupInitialTile(kn2_b, _tile);
			}else {
				// bishops
				BoardTile tile = this.getTileByLoc(0, width);
				Bishop b_b = (Bishop) DataShare.FIGUREDIRECTOR.createFigureOnTile(bishopBuilder, tile, UChessImages.bishop_black);
				this.setupInitialTile(b_b, tile);
				
				BoardTile _tile = this.getTileByLoc(0, this.boardWidth - width - 1);
				Bishop b2_b = (Bishop) DataShare.FIGUREDIRECTOR.createFigureOnTile(bishopBuilder, _tile, UChessImages.bishop_black);
				this.setupInitialTile(b2_b, _tile);
			}
			
			
			
		}
		
		// Initializing white pawns
		for(int width = 0; width < boardWidth; width++) {
			BoardTile tile_a = this.getTileByLoc(boardHeight - 2, width);
			Pawn p = (Pawn) DataShare.FIGUREDIRECTOR.createFigureOnTile(pawnBuilder, tile_a, UChessImages.pawn_white);
			setupInitialTile(p, tile_a);
		}
		
		// white queen
		BoardTile tile_b = this.getTileByLoc(boardHeight - 1, centerCord);
		Queen q_w = (Queen) DataShare.FIGUREDIRECTOR.createFigureOnTile(queenBuilder, tile_b, UChessImages.queen_white);
		setupInitialTile(q_w, tile_b);
		
		// white king
		BoardTile tile_c = this.getTileByLoc(boardHeight - 1, centerCord + 1);
		King k_w = (King) DataShare.FIGUREDIRECTOR.createFigureOnTile(kingBuilder, tile_c, UChessImages.king_white);
		setupInitialTile(k_w, tile_c);
		
		// other black figures - left side
		for (int width = 0; width < DividerWidth; width++) {

			if (width < SecondDivider) {
				// rooks
				BoardTile tile_d = this.getTileByLoc(this.boardHeight - 1, width);
				Rook r_w = (Rook) DataShare.FIGUREDIRECTOR.createFigureOnTile(rookBuilder, tile_d,
						UChessImages.rook_white);
				setupInitialTile(r_w, tile_d);
				
				BoardTile tile_e = this.getTileByLoc(this.boardHeight - 1, this.boardWidth - width - 1);
				Rook r2_w = (Rook) DataShare.FIGUREDIRECTOR.createFigureOnTile(rookBuilder,
						tile_e, UChessImages.rook_white);
				setupInitialTile(r2_w, tile_e);

			} else if (width < SecondDivider * 2) {
				// knights
				BoardTile tile_f = this.getTileByLoc(this.boardHeight - 1, width);
				Knight kn_w = (Knight) DataShare.FIGUREDIRECTOR.createFigureOnTile(knightBuilder, tile_f,
						UChessImages.knight_white);
				setupInitialTile(kn_w, tile_f);
				
				BoardTile tile_g = this.getTileByLoc(this.boardHeight - 1, this.boardWidth - width - 1);
				Knight kn2_w = (Knight) DataShare.FIGUREDIRECTOR.createFigureOnTile(knightBuilder,
						tile_g, UChessImages.knight_white);
				setupInitialTile(kn2_w, tile_g);
				
			} else {
				// bishops
				BoardTile tile_h = this.getTileByLoc(this.boardHeight - 1, width);
				Bishop b_w = (Bishop) DataShare.FIGUREDIRECTOR.createFigureOnTile(bishopBuilder, tile_h,
						UChessImages.bishop_white);
				setupInitialTile(b_w, tile_h);
				
				BoardTile tile_i = this.getTileByLoc(this.boardHeight - 1, this.boardWidth - width - 1);
				Bishop b2_w = (Bishop) DataShare.FIGUREDIRECTOR.createFigureOnTile(bishopBuilder,
						tile_i, UChessImages.bishop_white);
				setupInitialTile(b2_w, tile_i);
			}
					
					
		}
	}
	
	private void setupInitialTile(Figure figure, BoardTile tile) {
		figure.setTileX(tile.getTileX());
		figure.setTileY(tile.getTileY());
		
		tile.setTileFigure(figure);
		
		DataShare.HANDLER.registerTick(figure);
		DataShare.HANDLER.registerFigureRender(figure);
		
	}

	public BoardTile getTileByLoc(int height, int width) {
		BoardTile tilereturn = tiles[height][width];
		
		if(tilereturn == null) {
			RuntimeException ex = new RuntimeException("getTileByLoc failed to find a cell with params: " + height + ", " + width);
			ex.printStackTrace();
			throw ex;
		}
		
		return tilereturn;
	}

	public BoardTile[][] getTiles() {
		return tiles;
	}

	public void setTiles(BoardTile[][] tiles) {
		this.tiles = tiles;
	}

}
