package com.EKEY.Board.ChessFigures;

import java.awt.Image;

public class Bishop extends Figure{
	
	public Bishop() {
		super();
	}
	
	public Bishop(int x, int y, int width, int height, Image image) {
		super(x, y, width, height, image);
	}
	
	public Bishop(Bishop clone) {
		super(clone);
	}
	
	@Override
	public void tick() {
		
	}
	
	public Bishop clone() {
		return new Bishop(this);
	}
	
}
