package com.EKEY.Board.ChessFigures;

import java.awt.Image;

public class Queen extends Figure{
	
	public Queen() {
		super();
	}
	
	public Queen(int x, int y, int width, int height, Image image) {
		super(x, y, width, height, image);
	}
	
	public Queen(Queen clone) {
		super(clone);
	}
	
	@Override
	public void tick() {
		
	}
	
	public Queen clone() {
		return new Queen(this);
	}
	
}
