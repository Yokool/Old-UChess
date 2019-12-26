package com.EKEY.Board.ChessFigures.Movement;

import java.util.LinkedList;

import com.EKEY.Board.BoardTile;
import com.EKEY.Board.ChessFigures.Movement.Flinging.Fling;
import com.EKEY.Misc.DataShare;

/**
 * A refined SingleMovement class. This movement works the same as single movement except it can only be executed
 * when a figure is on the single tile.
 */
public class ConditionalSingleMovement extends SingleMovement{

	public ConditionalSingleMovement(Fling fling, int x, int y) {
		super(fling, x, y);
	}
	
	@Override
	public LinkedList<BoardTile> recalc() {
		
		LinkedList<BoardTile> bufferList = new LinkedList<BoardTile>();
		
		BoardTile tile = DataShare.BOARD.getTileByLoc(figure.getTileY() + y, figure.getTileX() + x);
		
		if(tile != null) {
		
			if(tile.getTileFigure() != null) {
				
				bufferList.add(tile);
				
			}
			
		}
		
		return bufferList;
	}
}
