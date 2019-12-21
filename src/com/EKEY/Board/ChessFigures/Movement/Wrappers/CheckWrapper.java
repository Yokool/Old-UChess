package com.EKEY.Board.ChessFigures.Movement.Wrappers;

import java.util.LinkedList;

import com.EKEY.Board.BoardTile;
import com.EKEY.Board.ChessFigures.ColorEnum;
import com.EKEY.Board.ChessFigures.Figure;
import com.EKEY.Board.ChessFigures.Movement.Movement;
import com.EKEY.Misc.DataShare;

public class CheckWrapper extends BaseMovementWrapper{

	public CheckWrapper(Movement movement) {
		super(movement);
	}
	
	@Override
	public void update() {
		
		super.update();
		
		System.out.println("CHECK WRAPPER DEBUG:");
		System.out.println(figure);
		System.out.println(figure.getTileX());
		System.out.println(figure.getTileY());
		
		BoardTile figureTile = DataShare.BOARD.getTileByLoc(figure.getTileY(), figure.getTileX());
		
		
		LinkedList<Figure> figureList = new LinkedList<Figure>();
		
		DataShare.BOARD.castSqure(figureTile, 8, tile -> {
			
			if(tile == null) {
				return;
			}
			
			if(tile.getTileFigure() != null) {
				
				Figure f = tile.getTileFigure();
				
				ColorEnum fe = f.getColorEnum();
				ColorEnum ft = tile.getTileFigure().getColorEnum();
				
				if(fe == ft) {
					return;
				}
				
				
				if(f.getMovement() == null) {
					return;
				}
				
				figureList.add(f);
				
			}
			
		});
		
		LinkedList<BoardTile> finalList = new LinkedList<BoardTile>();
		
		for(int i = 0; i < figureList.size(); i++) {
			
			Figure f = figureList.get(i);
			
			for(int j = 0; i < f.getMovement().size(); j++) {
				
				Movement m = f.getMovement().get(j);
				
				m.update();
				
				m.getBufferList().forEach(tile -> {
					finalList.add(tile);
				});
				
			}
			
			
		}
		
		for(int i = 0; i < movement.getBufferList().size(); i++) {
			
			BoardTile tile = movement.getBufferList().get(i);
			
			for(int j = 0; j < finalList.size(); j++) {
				BoardTile b = finalList.get(j);
				
				if(tile.getTileX() == b.getTileX() && tile.getTileY() == b.getTileY()) {
					movement.getBufferList().remove(i);
					System.out.println("REMOVING");
				}
				
			}
			
		}
		
		
	
	}
	
	@Override
	public Object clone() {
		return new CheckWrapper((Movement) this.movement.clone()); // FIXME: RETURNING BASEMOVEMENTWRAPPER
	}
	
}
