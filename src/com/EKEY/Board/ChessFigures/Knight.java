package com.EKEY.Board.ChessFigures;

import java.awt.Image;

public class Knight extends Figure{
	
	public Knight() {
		super();
	}
	
	public Knight(int x, int y, int width, int height, Image image) {
		super(x, y, width, height, image);
		this.figureImage = image;
	}
	
	@Override
	public void tick() {
		
	}
	
}
