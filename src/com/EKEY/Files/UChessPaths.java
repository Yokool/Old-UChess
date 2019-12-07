package com.EKEY.Files;

import java.io.File;

public abstract class UChessPaths {
	
	public static File bishop_white = null;
	public static File king_white = null;
	public static File knight_white = null;
	public static File pawn_white = null;
	public static File queen_white = null;
	public static File rook_white = null;
	
	public static File bishop_black = null;
	public static File king_black = null;
	public static File knight_black = null;
	public static File pawn_black = null;
	public static File queen_black = null;
	public static File rook_black = null;
	
	
	public static void loadFiles() {
		
		bishop_white = new File("assets\\figures\\bishop\\bishop_white.png");
		king_white = new File("assets\\king\\king_white.png");
		knight_white = new File("assets\\figures\\knight\\knight_white.png");
		pawn_white = new File("assets\\figures\\pawn\\pawn_white.png");
		queen_white = new File("assets\\figures\\queen\\queen_white.png");
		rook_white = new File("assets\\figures\\rook\\rook_white.png");
		
		bishop_black = new File("assets\\figures\\bishop\\bishop_black.png");
		king_black = new File("assets\\figures\\king\\king_black.png");
		knight_black = new File("assets\\figures\\knight\\knight_black.png");
		pawn_black = new File("assets\\figures\\pawn\\pawn_black.png");
		queen_black = new File("assets\\figures\\queen\\queen_black.png");
		rook_black = new File("assets\\figures\\rook\\rook_black.png");
		
	}
	
}
