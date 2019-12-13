package com.EKEY.Board.ChessFigures.Movement;

import com.EKEY.Board.BoardTile;
import com.EKEY.Board.ChessFigures.Figure;
import com.EKEY.Misc.DataShare;

/**
 * One of the basic Movement classes. Best used in repeated patterns.
 */
public class StepMovement extends Movement{
	
	private int xStep = 0;
	
	private int yStep = 0;
	
	private int repeat = 0;
	

	// xCoords =   1, 10 - Go 1 step 10 tmies
	// first param - step, second param is number of repeats
	/**
	 * The constructor lets you configure the object to suit your needs.
	 * 
	 * The constructor is best explained with an example.
	 * E:
	 * xStep = 0
	 * yStep = -1
	 * repeat = 2
	 * 
	 * This will let you walk two tiles in the front. The tiles are above the figure since we are walking from it's location.
	 * If the yStep was -2, they would have a space between them so you could walk
	 * 
	 * 
	 * 
	 * <div>
	 * o
	 * <br>
	 * x
	 * <br>
	 * o
	 * <br>
	 * x
	 * <br>
	 * f
	 * <div>
	 * 
	 * <div>
	 * f figure
	 * <br>
	 * x not walkable
	 * <br>
	 * o walkable
	 * <div>
	 * 
	 * @param xStep The amount of tiles in the x axis to step.
	 * @param yStep The amount of tiles in the y axis to step.
	 * @param repeat The number of times to repeat the loop.
	 */
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
