package com.EKEY.Board.ChessFigures.Prototypes;

import com.EKEY.Board.ChessFigures.Bishop;
import com.EKEY.Board.ChessFigures.King;
import com.EKEY.Board.ChessFigures.Knight;
import com.EKEY.Board.ChessFigures.Pawn;
import com.EKEY.Board.ChessFigures.Queen;
import com.EKEY.Board.ChessFigures.Rook;
import com.EKEY.Board.ChessFigures.Builder.BishopBuilder;
import com.EKEY.Board.ChessFigures.Builder.FigureDirector;
import com.EKEY.Board.ChessFigures.Builder.KingBuilder;
import com.EKEY.Board.ChessFigures.Builder.KnightBuilder;
import com.EKEY.Board.ChessFigures.Builder.PawnBuilder;
import com.EKEY.Board.ChessFigures.Builder.QueenBuilder;
import com.EKEY.Board.ChessFigures.Builder.RookBuilder;
import com.EKEY.Board.ChessFigures.Movement.MovementPrototypes;
import com.EKEY.Files.UChessImages;
import com.EKEY.Misc.DataShare;

public abstract class FigurePrototypes {
	
	private static Pawn pawn_white;
	private static Pawn pawn_black;
	
	private static Rook rook_white;
	private static Rook rook_black;
	
	private static Bishop bishop_white;
	private static Bishop bishop_black;
	
	private static Knight knight_white;
	private static Knight knight_black;
	
	private static Queen queen_white;
	private static Queen queen_black;
	
	private static King king_white;
	private static King king_black;
	
	public static void createPrototypes() {
		
		FigureDirector dirCopy = FigureDirector.getInstance();
		
		PawnBuilder pawnBuilder = new PawnBuilder();
		RookBuilder rookBuilder = new RookBuilder();
		BishopBuilder bishopBuilder = new BishopBuilder();
		KnightBuilder knightBuilder = new KnightBuilder();
		QueenBuilder queenBuilder = new QueenBuilder();
		KingBuilder kingBuilder =  new KingBuilder();
		
		pawn_white = (Pawn) dirCopy.createStandartFigure(pawnBuilder, UChessImages.pawn_white);
		pawn_black = (Pawn) dirCopy.createStandartFigure(pawnBuilder, UChessImages.pawn_black);

		pawn_white.addMovementSet(MovementPrototypes.getWhitePawnMovementSet());
		pawn_black.addMovementSet(MovementPrototypes.getBlackPawnMovement());
		
		rook_white = (Rook) dirCopy.createStandartFigure(rookBuilder, UChessImages.rook_white);
		rook_black = (Rook) dirCopy.createStandartFigure(rookBuilder, UChessImages.rook_black);
		
		rook_white.addMovementSet(MovementPrototypes.getRookMovement());
		rook_black.addMovementSet(MovementPrototypes.getRookMovement());
		
		bishop_white = (Bishop) dirCopy.createStandartFigure(bishopBuilder, UChessImages.bishop_white);
		bishop_black = (Bishop) dirCopy.createStandartFigure(bishopBuilder, UChessImages.bishop_black);
		
		bishop_white.addMovementSet(MovementPrototypes.getBishopMovement());
		bishop_black.addMovementSet(MovementPrototypes.getBishopMovement());
		
		knight_white = (Knight) dirCopy.createStandartFigure(knightBuilder, UChessImages.knight_white);
		knight_black = (Knight) dirCopy.createStandartFigure(knightBuilder, UChessImages.knight_black);
		
		knight_white.addMovementSet(MovementPrototypes.getKnightMovement());
		knight_black.addMovementSet(MovementPrototypes.getKnightMovement());
		
		queen_white = (Queen) dirCopy.createStandartFigure(queenBuilder, UChessImages.queen_white);
		queen_black = (Queen) dirCopy.createStandartFigure(queenBuilder, UChessImages.queen_black);
		
		queen_white.addMovementSet(MovementPrototypes.getQueenMovement());
		queen_black.addMovementSet(MovementPrototypes.getQueenMovement());
		
		king_white = (King) dirCopy.createStandartFigure(kingBuilder, UChessImages.king_white);
		king_black = (King) dirCopy.createStandartFigure(kingBuilder, UChessImages.king_black);
		
		king_white.addMovementSet(MovementPrototypes.getKingMovement());
		king_black.addMovementSet(MovementPrototypes.getKingMovement());
		
	}

	public static Pawn getPawn_white() {
		return pawn_white.clone();
	}

	public static Pawn getPawn_black() {
		return pawn_black.clone();
	}

	public static Rook getRook_white() {
		return rook_white.clone();
	}

	public static Rook getRook_black() {
		return rook_black.clone();
	}

	public static Bishop getBishop_white() {
		return bishop_white.clone();
	}

	public static Bishop getBishop_black() {
		return bishop_black.clone();
	}

	public static Knight getKnight_white() {
		return knight_white.clone();
	}

	public static Knight getKnight_black() {
		return knight_black.clone();
	}

	public static Queen getQueen_white() {
		return queen_white.clone();
	}

	public static Queen getQueen_black() {
		return queen_black.clone();
	}

	public static King getKing_white() {
		return king_white.clone();
	}

	public static King getKing_black() {
		return king_black.clone();
	}
	
	
}
