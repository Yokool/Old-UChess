package com.EKEY.Board.ChessFigures.Movement.Flinging;

import com.EKEY.Board.BoardTile;
import com.EKEY.Board.ChessFigures.Figure;
import com.EKEY.Misc.DataShare;

public class VanillaFling extends Fling{

	@Override
	public void flingOut(Figure targetF) {
		
		BoardTile targetTile = DataShare.BOARD.getTileByLoc(targetF.getTileY(), targetF.getTileX());
		DataShare.BOARD.moveFigureToTile(figure, targetTile);
		
		targetF.deleteObject();
		
		
		
	}

}
