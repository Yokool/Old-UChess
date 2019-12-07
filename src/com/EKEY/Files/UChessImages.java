package com.EKEY.Files;

import java.awt.Image;

public abstract class UChessImages {
	
	public static Image pawn_white = null;
	public static Image pawn_black = null;
	
	public static void loadAllImages() {
		
		pawn_white = ImageLoader.loadImage(UChessPaths.pawn_white);
		pawn_black = ImageLoader.loadImage(UChessPaths.pawn_black);
		
	}
	
	
}
