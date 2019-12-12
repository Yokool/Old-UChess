package com.EKEY.Board.ChessFigures.Movement;

import java.awt.Color;
import java.awt.Graphics;

import com.EKEY.Board.BoardTile;
import com.EKEY.Board.ChessFigures.Figure;
import com.EKEY.Misc.Camera;

public class WhitePawnMovement extends Movement{

	public WhitePawnMovement(Figure figure) {
		super(figure);
	}
	
	@Override
	public void renderOptions(Graphics g) {
		Color c = new Color(0f, 0, 0f, 0.5f);
		g.setColor(c);
		Camera cam = Camera.getInstance();
		g.fillOval(linkedFigure.getX() - cam.getCameraX() + 47, linkedFigure.getY() - 128 + 47 - cam.getCameraY(), 32, 32);
		g.fillOval(linkedFigure.getX() - cam.getCameraX() + 47, linkedFigure.getY() - 256 + 47 - cam.getCameraY(), 32, 32);
	}

	@Override
	public void moveFigure(BoardTile tile) {
		// TODO Auto-generated method stub
		
	}

}
