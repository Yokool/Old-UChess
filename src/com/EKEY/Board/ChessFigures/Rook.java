package com.EKEY.Board.ChessFigures;

import java.awt.Image;

public class Rook extends Figure{
	
	public Rook(int x, int y, int width, int height, Image image) {
		super(x, y, width, height, image);
	}
	
	public Rook(Rook clone) {
		super(clone);
	}
	
	@Override
	public void tick() {
		
	}
	
	public Rook clone() {
		return new Rook(this);
	}
	
}
