package com.EKEY.Board.ChessFigures.Prototypes;

import com.EKEY.Board.ChessFigures.ColorEnum;
import com.EKEY.Board.ChessFigures.Figure;
import com.EKEY.Board.ChessFigures.Builder.FigureBuilder;
import com.EKEY.Board.ChessFigures.Builder.FigureDirector;
import com.EKEY.Board.ChessFigures.Movement.MovementPrototypes;
import com.EKEY.Files.UChessImages;

public abstract class FigurePrototypes {
	
	private static Figure pawn_white;
	private static Figure pawn_black;
	
	private static Figure rook_white;
	private static Figure rook_black;
	
	private static Figure bishop_white;
	private static Figure bishop_black;
	
	private static Figure knight_white;
	private static Figure knight_black;
	
	private static Figure queen_white;
	private static Figure queen_black;
	
	private static Figure king_white;
	private static Figure king_black;
	
	public static void createPrototypes() {
		
		FigureDirector dirCopy = FigureDirector.getInstance();
		
		FigureBuilder figureBuilder = new FigureBuilder();
		
		pawn_white = dirCopy.createStandartFigure(figureBuilder, UChessImages.pawn_white, ColorEnum.WHITE);
		pawn_black = dirCopy.createStandartFigure(figureBuilder, UChessImages.pawn_black, ColorEnum.BLACK);

		pawn_white.addMovementSet(MovementPrototypes.getWhitePawnMovementSet());
		pawn_black.addMovementSet(MovementPrototypes.getBlackPawnMovement());
		
		rook_white = dirCopy.createStandartFigure(figureBuilder, UChessImages.rook_white, ColorEnum.WHITE);
		rook_black = dirCopy.createStandartFigure(figureBuilder, UChessImages.rook_black, ColorEnum.BLACK);
		
		rook_white.addMovementSet(MovementPrototypes.getRookMovement());
		rook_black.addMovementSet(MovementPrototypes.getRookMovement());
		
		bishop_white = dirCopy.createStandartFigure(figureBuilder, UChessImages.bishop_white, ColorEnum.WHITE);
		bishop_black = dirCopy.createStandartFigure(figureBuilder, UChessImages.bishop_black, ColorEnum.BLACK);
		
		bishop_white.addMovementSet(MovementPrototypes.getBishopMovement());
		bishop_black.addMovementSet(MovementPrototypes.getBishopMovement());
		
		knight_white = dirCopy.createStandartFigure(figureBuilder, UChessImages.knight_white, ColorEnum.WHITE);
		knight_black = dirCopy.createStandartFigure(figureBuilder, UChessImages.knight_black, ColorEnum.BLACK);
		
		knight_white.addMovementSet(MovementPrototypes.getKnightMovement());
		knight_black.addMovementSet(MovementPrototypes.getKnightMovement());
		
		queen_white = dirCopy.createStandartFigure(figureBuilder, UChessImages.queen_white, ColorEnum.WHITE);
		queen_black = dirCopy.createStandartFigure(figureBuilder, UChessImages.queen_black, ColorEnum.BLACK);
		
		queen_white.addMovementSet(MovementPrototypes.getQueenMovement());
		queen_black.addMovementSet(MovementPrototypes.getQueenMovement());
		
		king_white = dirCopy.createStandartFigure(figureBuilder, UChessImages.king_white, ColorEnum.WHITE);
		king_black = dirCopy.createStandartFigure(figureBuilder, UChessImages.king_black, ColorEnum.BLACK);
		
		king_white.addMovementSet(MovementPrototypes.getKingMovement());
		king_black.addMovementSet(MovementPrototypes.getKingMovement());
		
	}

	public static Figure getPawn_white() {
		return (Figure) pawn_white.clone();
	}

	public static Figure getPawn_black() {
		return (Figure) pawn_black.clone();
	}

	public static Figure getRook_white() {
		return (Figure) rook_white.clone();
	}

	public static Figure getRook_black() {
		return (Figure) rook_black.clone();
	}

	public static Figure getBishop_white() {
		return (Figure) bishop_white.clone();
	}

	public static Figure getBishop_black() {
		return (Figure) bishop_black.clone();
	}

	public static Figure getKnight_white() {
		return (Figure) knight_white.clone();
	}

	public static Figure getKnight_black() {
		return (Figure) knight_black.clone();
	}

	public static Figure getQueen_white() {
		return (Figure) queen_white.clone();
	}

	public static Figure getQueen_black() {
		return (Figure) queen_black.clone();
	}

	public static Figure getKing_white() {
		return (Figure) king_white.clone();
	}

	public static Figure getKing_black() {
		return (Figure) king_black.clone();
	}
	
	
}
