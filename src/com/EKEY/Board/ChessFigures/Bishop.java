package com.EKEY.Board.ChessFigures;

import java.awt.Image;

import com.EKEY.Board.ChessFigures.Movement.Movement;

public class Bishop extends Figure{
	
	public Bishop() {
		super();
	}
	
	public Bishop(int x, int y, int width, int height, Image image, Movement movement) {
		super(x, y, width, height, image, movement);
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
