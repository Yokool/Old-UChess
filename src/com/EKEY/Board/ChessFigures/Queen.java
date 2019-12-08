package com.EKEY.Board.ChessFigures;

import java.awt.Image;

public class Queen extends Figure{
	
	public Queen() {
		super();
	}
	
	public Queen(int x, int y, int width, int height, Image image) {
		super(x, y, width, height, image);
		this.figureImage = image;
	}
	
	@Override
	public void tick() {
		
	}
	
}
