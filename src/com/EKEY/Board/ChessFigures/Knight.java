package com.EKEY.Board.ChessFigures;

import java.awt.Image;

import com.EKEY.Board.ChessFigures.Movement.Movement;

public class Knight extends Figure{
	
	public Knight() {
		super();
	}
	
	public Knight(int x, int y, int width, int height, Image image, ColorEnum color, Movement movement) {
		super(x, y, width, height, image, color, movement);
	}
	
	public Knight(Knight clone) {
		super(clone);
	}
	
	@Override
	public void tick() {
		
	}
	
	public Knight clone() {
		return new Knight(this);
	}
	
}
