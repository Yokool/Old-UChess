package com.EKEY.Files;

import java.awt.Image;

public abstract class UChessImages {
	
	public static Image pawn_white = null;
	public static Image pawn_black = null;
	
	public static Image rook_white = null;
	public static Image rook_black = null;
	
	public static Image knight_white = null;
	public static Image knight_black = null;
	
	public static Image bishop_white = null;
	public static Image bishop_black = null;
	
	public static Image king_white = null;
	public static Image king_black = null;
	
	public static Image queen_white = null;
	public static Image queen_black = null;
	
	
	public static void loadAllImages() {
		
		pawn_white = ImageLoader.loadImage(UChessPaths.pawn_white);
		pawn_black = ImageLoader.loadImage(UChessPaths.pawn_black);
		
		rook_white = ImageLoader.loadImage(UChessPaths.rook_white);
		rook_black = ImageLoader.loadImage(UChessPaths.rook_black);
		
		knight_white = ImageLoader.loadImage(UChessPaths.knight_white);
		knight_black = ImageLoader.loadImage(UChessPaths.knight_black);
		
		bishop_white = ImageLoader.loadImage(UChessPaths.bishop_white);
		bishop_black = ImageLoader.loadImage(UChessPaths.bishop_black);
		
		king_white = ImageLoader.loadImage(UChessPaths.king_white);
		king_black = ImageLoader.loadImage(UChessPaths.king_black);
		
		queen_white = ImageLoader.loadImage(UChessPaths.queen_white);
		queen_black = ImageLoader.loadImage(UChessPaths.queen_black);
		
		
	}
	
	
}
