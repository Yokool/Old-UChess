package com.EKEY.Board.ChessFigures.Movement.Wrappers;

import java.util.LinkedList;

import com.EKEY.Board.BoardTile;
import com.EKEY.Board.ChessFigures.Figure;
import com.EKEY.Board.ChessFigures.Movement.Movement;
import com.EKEY.Misc.DataShare;

public class CheckMovementWrapper extends BaseMovementWrapper{

	public CheckMovementWrapper(Movement wrappedMovement) {
		super(wrappedMovement);
	}
	
	@Override
	public void update() {
		
		super.update();
		
		BoardTile figureTile = DataShare.BOARD.getTileByLoc(this.getFigure().getTileY(), this.getFigure().getTileX());
		
		
		LinkedList<Figure> figureList = new LinkedList<Figure>();
		
		DataShare.BOARD.castSqure(figureTile, 4, tile -> {
			
			if(tile == null) {
				return;
			}
			
			
			if(tile.getTileFigure() == null) {
				return;
			}
			
			Figure tileFig = tile.getTileFigure();
			
			if(tileFig.getColorEnum().equals(wrappedMovement.getFigure().getColorEnum())) {
				return;
			}
			
			figureList.add(tileFig);
			
			
			
		});
		
		
		
		
		LinkedList<BoardTile> notAllowedTiles = new LinkedList<BoardTile>();
		
		for(int i = 0; i < figureList.size(); i++) {
			
			Figure f = figureList.get(i);
			
			for(int j = 0; j < f.getMovement().size(); j++) {
				Movement m = f.getMovement().get(j);
				m.update(); // TODO: ERROR LINE
				notAllowedTiles.addAll(m.getBufferList());
			}
			
		}
		
		for(int i = 0; i < notAllowedTiles.size(); i++) {
			
			BoardTile tile = notAllowedTiles.get(i);
			
			if(this.getBufferList().contains(tile)) {
				this.getBufferList().remove(tile);
			}
			
		}
		
	}
	
	@Override
	public Object clone() {
		return new CheckMovementWrapper((Movement) wrappedMovement.clone());
	}
	
}
