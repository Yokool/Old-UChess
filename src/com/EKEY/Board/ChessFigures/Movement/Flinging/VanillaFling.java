package com.EKEY.Board.ChessFigures.Movement.Flinging;

import com.EKEY.Board.BoardTile;
import com.EKEY.Board.ChessFigures.Figure;
import com.EKEY.Misc.DataShare;

/**
 * The most basic of the Fling classes. Works like in the normal chess game which "instantly" kills the figure, throwing it out.
 */
public class VanillaFling extends Fling{

	@Override
	public void flingOut(Figure targetF) {
		
		BoardTile targetTile = DataShare.BOARD.getTileByLoc(targetF.getTileY(), targetF.getTileX());
		DataShare.BOARD.moveFigureToTile(figure, targetTile);
		
		targetF.deleteObject();
		
		
		
	}

}
