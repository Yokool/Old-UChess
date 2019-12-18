package com.EKEY.Board.ChessFigures;

import java.awt.Image;

import com.EKEY.Board.ChessFigures.Movement.Movement;

public class Queen extends Figure{
	
	public Queen() {
		super();
	}
	
	public Queen(int x, int y, int width, int height, Image image, ColorEnum color, Movement movement) {
		super(x, y, width, height, image, color, movement);
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
