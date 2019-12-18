package com.EKEY.Board.ChessFigures;

import java.awt.Image;

import com.EKEY.Board.ChessFigures.Movement.Movement;

public class Rook extends Figure{
	
	public Rook(int x, int y, int width, int height, Image image, ColorEnum color, Movement movement) {
		super(x, y, width, height, image, color, movement);
	}
	
	public Rook(Rook clone) {
		super(clone);
	}
	
	public Rook() {
		super();
	}

	@Override
	public void tick() {
		
	}
	
	public Rook clone() {
		return new Rook(this);
	}
	
}
