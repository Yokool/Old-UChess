package com.EKEY.Board.ChessFigures;

import java.awt.Image;

public class Pawn extends Figure{
	// TODO WIP
	public Pawn(int x, int y, int width, int height, Image image) {
		super(x, y, width, height, image);
	}
	
	public Pawn() {
		super();
	}
	
	public Pawn(Pawn clone) {
		super(clone);
	}

	@Override
	public void tick() {
		
	}
	
	public Pawn clone() {
		return new Pawn(this);
	}

}
