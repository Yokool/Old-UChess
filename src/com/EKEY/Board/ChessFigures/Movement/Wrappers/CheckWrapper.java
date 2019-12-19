package com.EKEY.Board.ChessFigures.Movement.Wrappers;

import java.util.ArrayList;

import com.EKEY.Board.BoardTile;
import com.EKEY.Board.ChessFigures.ColorEnum;
import com.EKEY.Board.ChessFigures.Movement.Movement;

public class CheckWrapper extends BaseMovementWrapper{

	public CheckWrapper(Movement movement) {
		super(movement);
	}
	
	@Override
	public void update() {
		super.update();
		
		ArrayList<BoardTile> bufList = movement.getBufferList();
		
		for(int i = 0; i < bufList.size(); i++) {
			
			BoardTile tile = bufList.get(i);
			
			if(tile.getTileFigure().getColorEnum() == ColorEnum.BLACK) {
				bufList.remove(i);
			}
			
		}
		
	}
	
	
}
