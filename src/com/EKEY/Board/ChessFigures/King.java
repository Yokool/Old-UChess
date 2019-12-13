package com.EKEY.Board.ChessFigures;

import java.awt.Image;

import com.EKEY.Board.ChessFigures.Movement.Movement;

public class King extends Figure{
	
	public King() {
		
	}
	
	public King(int x, int y, int width, int height, Image image, Movement movement) {
		super(x, y, width, height, image, movement);
	}
	
	public King(King clone) {
		super(clone);
	}
	
	@Override
	public void tick() {
		
	}
	
	public King clone() {
		return new King(this);
	}
	
}
