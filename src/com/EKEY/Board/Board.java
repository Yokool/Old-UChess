package com.EKEY.Board;

import java.awt.Color;

import com.EKEY.Board.Builder.NormalTileBuilder;
import com.EKEY.Board.Builder.TileDirector;
import com.EKEY.Board.ChessFigures.Bishop;
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
			
			Pawn p = (Pawn) DataShare.FIGUREDIRECTOR.createFigureOnTile(pawnBuilder, tiles[1][width], UChessImages.pawn_black);
			tiles[1][width].setTileFigure(p);
			DataShare.HANDLER.registerFigureRender(p);
			
		}
		
		// black queen
		Queen q_b = (Queen) DataShare.FIGUREDIRECTOR.createFigureOnTile(queenBuilder, tiles[0][centerCord], UChessImages.queen_black);
		tiles[0][centerCord].setTileFigure(q_b);
		DataShare.HANDLER.registerFigureRender(q_b); // TODO: TICKING
		
		// black king
		King k_b = (King) DataShare.FIGUREDIRECTOR.createFigureOnTile(kingBuilder, tiles[0][centerCord + 1], UChessImages.king_black);
		tiles[0][centerCord + 1].setTileFigure(k_b);
		DataShare.HANDLER.registerFigureRender(k_b);
		
		
		int SecondDivider = (int)(DividerWidth / 3.0);
		
		// other black figures - left side
		for(int width = 0; width < DividerWidth; width++) {
			
			if(width < SecondDivider) {
				// rooks
				Rook r_b = (Rook) DataShare.FIGUREDIRECTOR.createFigureOnTile(rookBuilder, tiles[0][width], UChessImages.rook_black);
				tiles[0][width].setTileFigure(r_b);
				DataShare.HANDLER.registerFigureRender(r_b);
				
				Rook r2_b = (Rook) DataShare.FIGUREDIRECTOR.createFigureOnTile(rookBuilder, tiles[0][this.boardWidth - width - 1], UChessImages.rook_black);
				tiles[0][this.boardWidth - width - 1].setTileFigure(r2_b);
				DataShare.HANDLER.registerFigureRender(r2_b);
				
			}else if (width < SecondDivider*2) {
				// knights
				Knight kn_b = (Knight) DataShare.FIGUREDIRECTOR.createFigureOnTile(knightBuilder, tiles[0][width], UChessImages.knight_black);
				tiles[0][width].setTileFigure(kn_b);
				DataShare.HANDLER.registerFigureRender(kn_b);
				
				Knight kn2_b = (Knight) DataShare.FIGUREDIRECTOR.createFigureOnTile(knightBuilder, tiles[0][this.boardWidth - width - 1], UChessImages.knight_black);
				tiles[0][this.boardWidth - width - 1].setTileFigure(kn2_b);
				DataShare.HANDLER.registerFigureRender(kn2_b);
			}else {
				// bishops
				Bishop b_b = (Bishop) DataShare.FIGUREDIRECTOR.createFigureOnTile(bishopBuilder, tiles[0][width], UChessImages.bishop_black);
				tiles[0][width].setTileFigure(b_b);
				DataShare.HANDLER.registerFigureRender(b_b);
				
				Bishop b2_b = (Bishop) DataShare.FIGUREDIRECTOR.createFigureOnTile(bishopBuilder, tiles[0][this.boardWidth - width - 1], UChessImages.bishop_black);
				tiles[0][this.boardWidth - width - 1].setTileFigure(b2_b);
				DataShare.HANDLER.registerFigureRender(b2_b);
			}
			
			
			
		}
		
		// Initializing white pawns
		for(int width = 0; width < boardWidth; width++) {
			Pawn p = (Pawn) DataShare.FIGUREDIRECTOR.createFigureOnTile(pawnBuilder, tiles[boardHeight - 2][width], UChessImages.pawn_white);
			tiles[boardHeight - 2][width].setTileFigure(p);
			DataShare.HANDLER.registerFigureRender(p);
		}
		
		// white queen
		Queen q_w = (Queen) DataShare.FIGUREDIRECTOR.createFigureOnTile(queenBuilder, tiles[boardHeight - 1][centerCord], UChessImages.queen_white);
		tiles[boardHeight - 1][centerCord].setTileFigure(q_w);
		DataShare.HANDLER.registerFigureRender(q_w); // TODO: TICKING
		
		// white king
		King k_w = (King) DataShare.FIGUREDIRECTOR.createFigureOnTile(kingBuilder, tiles[boardHeight - 1][centerCord + 1], UChessImages.king_white);
		tiles[boardHeight - 1][centerCord + 1].setTileFigure(k_w);
		DataShare.HANDLER.registerFigureRender(k_w);
		
		// other black figures - left side
		for (int width = 0; width < DividerWidth; width++) {

			if (width < SecondDivider) {
				// rooks
				Rook r_w = (Rook) DataShare.FIGUREDIRECTOR.createFigureOnTile(rookBuilder, tiles[this.boardWidth - 1][width],
						UChessImages.rook_white);
				tiles[this.boardWidth - 1][width].setTileFigure(r_w);
				DataShare.HANDLER.registerFigureRender(r_w);

				Rook r2_w = (Rook) DataShare.FIGUREDIRECTOR.createFigureOnTile(rookBuilder,
						tiles[this.boardWidth - 1][this.boardWidth - width - 1], UChessImages.rook_white);
				tiles[this.boardWidth - 1][this.boardWidth - width - 1].setTileFigure(r2_w);
				DataShare.HANDLER.registerFigureRender(r2_w);

			} else if (width < SecondDivider * 2) {
				// knights
				Knight kn_w = (Knight) DataShare.FIGUREDIRECTOR.createFigureOnTile(knightBuilder, tiles[this.boardWidth - 1][width],
						UChessImages.knight_white);
				tiles[this.boardWidth - 1][width].setTileFigure(kn_w);
				DataShare.HANDLER.registerFigureRender(kn_w);

				Knight kn2_w = (Knight) DataShare.FIGUREDIRECTOR.createFigureOnTile(knightBuilder,
						tiles[this.boardWidth - 1][this.boardWidth - width - 1], UChessImages.knight_white);
				tiles[this.boardWidth - 1][this.boardWidth - width - 1].setTileFigure(kn2_w);
				DataShare.HANDLER.registerFigureRender(kn2_w);
			} else {
				// bishops
				Bishop b_w = (Bishop) DataShare.FIGUREDIRECTOR.createFigureOnTile(bishopBuilder, tiles[this.boardWidth - 1][width],
						UChessImages.bishop_white);
				tiles[this.boardWidth - 1][width].setTileFigure(b_w);
				DataShare.HANDLER.registerFigureRender(b_w);

				Bishop b2_w = (Bishop) DataShare.FIGUREDIRECTOR.createFigureOnTile(bishopBuilder,
						tiles[this.boardWidth - 1][this.boardWidth - width - 1], UChessImages.bishop_white);
				tiles[this.boardWidth - 1][this.boardWidth - width - 1].setTileFigure(b2_w);
				DataShare.HANDLER.registerFigureRender(b2_w);
			}
					
					
		}
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
