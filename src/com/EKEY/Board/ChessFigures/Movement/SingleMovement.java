package com.EKEY.Board.ChessFigures.Movement;

import com.EKEY.Board.BoardTile;
import com.EKEY.Board.ChessFigures.Movement.Flinging.Fling;
import com.EKEY.Misc.DataShare;

/**
 * A movement type that allows a figure to move to a single cell from its location.
 */
public class SingleMovement extends Movement{
	
	private int x;
	private int y;
	
	/**
	 * 
	 * @param figure
	 * @param x The x position of the tile we want to go onto from the figure x location.
	 * @param y The y position of the tile we want to go onto from the figure y location.
	 */
	public SingleMovement(Fling fling, int x, int y) {
		super(fling);
		this.x = x;
		this.y = y;
	}

	@Override
	protected void recalc() {
		
		BoardTile tile = DataShare.BOARD.getTileByLoc(figure.getTileY() + y, figure.getTileX() + x);
		
		if(tile == null) {
			return;
		}
		
		bufferList.add(tile);
		
	}
	
	@Override
	public Object clone() {
		return super.clone();
	}

}
