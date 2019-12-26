package com.EKEY.Board.ChessFigures.Movement;

import java.util.LinkedList;

import com.EKEY.Board.BoardTile;
import com.EKEY.Board.ChessFigures.Movement.Flinging.Fling;
import com.EKEY.Misc.DataShare;

/**
 * One of the basic Movement classes. Best used in repeated patterns.
 */
public class StepMovement extends Movement{
	
	private int xStep = 0;
	
	private int yStep = 0;
	
	private int repeat = 0;
	
	private boolean canSkipFigures = false;

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
	public StepMovement(Fling fling,int xStep, int yStep, int repeat) {
		super(fling);
		this.xStep = xStep;
		this.repeat = repeat;
		this.yStep = yStep;
		
		if(Math.abs(xStep) > 1 || Math.abs(yStep) > 1) {
			this.canSkipFigures = true;
		}
		
	}
	

	@Override
	public LinkedList<BoardTile> recalc() {
		
		LinkedList<BoardTile> bufferList = new LinkedList<BoardTile>();
		
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
				
				if(!canSkipFigures) {
					bufferList.add(t);
					break;
					
				}else {
					continue;
				}
				
			}
			
			bufferList.add(t);
			
		}
		
		return bufferList;
	}
	
	@Override
	public Object clone() {
		return super.clone();
	}
	
	
	public int getxStep() {
		return xStep;
	}

	public void setxStep(int xStep) {
		this.xStep = xStep;
	}

	public int getyStep() {
		return yStep;
	}

	public void setyStep(int yStep) {
		this.yStep = yStep;
	}

	public int getRepeat() {
		return repeat;
	}

	public void setRepeat(int repeat) {
		this.repeat = repeat;
	}

	public boolean isCanSkipFigures() {
		return canSkipFigures;
	}

	public void setCanSkipFigures(boolean canSkipFigures) {
		this.canSkipFigures = canSkipFigures;
	}
	
	

}
