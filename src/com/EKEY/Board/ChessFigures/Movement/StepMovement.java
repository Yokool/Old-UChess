package com.EKEY.Board.ChessFigures.Movement;

import com.EKEY.Board.BoardTile;
import com.EKEY.Board.ChessFigures.Figure;
import com.EKEY.Misc.DataShare;

public class StepMovement extends Movement{
	
	private int xStep = 0;
	
	private int yStep = 0;
	
	private int repeat = 0;
	
	
	public StepMovement(Figure figure,int xStep, int yStep, int repeat) {
		super(figure);
		this.xStep = xStep;
		this.repeat = repeat;
		this.yStep = yStep;
		
	}

	@Override
	public void recalc() {
		
		int xTracker = 0;
		int yTracker = 0;
		
		for(int i = 0; i < repeat; i++) {
			xTracker += xStep;
			yTracker += yStep;
			
			BoardTile t = DataShare.BOARD.getTileByLoc(figure.getTileY() + yTracker, figure.getTileX() + xTracker);
			
			if(t == null) {
				continue;
			}
			
			if(t.getTileFigure() != null) {
				continue;
			}
			
			bufferList.add(t);
		}
	}

	

}
