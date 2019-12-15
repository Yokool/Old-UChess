package com.EKEY.Listeners;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.AbstractList;
import java.util.Collections;
import java.util.ListIterator;

import com.EKEY.Board.BoardTile;
import com.EKEY.Board.ChessFigures.Figure;
import com.EKEY.Board.ChessFigures.Movement.Movement;
import com.EKEY.Interfaces.Clickable;
import com.EKEY.Misc.DataShare;

public class ClickableMouse implements MouseListener{
	
	private Figure selectedFigure = null;
	
	@Override
	public void mouseClicked(MouseEvent EVENT) {
		
		Point clickPoint = EVENT.getPoint();
		
		for(int i = 0; i < DataShare.HANDLER.getClickList().size(); i++) {
			
			Clickable clickable = DataShare.HANDLER.getClickList().get(i);
			
			
			if(clickable.getBounds().contains(clickPoint)) {
				
				if(clickable instanceof Figure) {
					
					Figure fig = (Figure) clickable;
					
					if(selectedFigure == null || fig != selectedFigure) {
						
						if(selectedFigure != null) {
							selectedFigure.setSelected(false);
						}
						
						fig.setSelected(true);
						selectedFigure = fig;
						
						
					}
					
					
					
				}
				
				if(selectedFigure != null && clickable instanceof BoardTile) {
					
					BoardTile tile = (BoardTile) clickable;
					
					for(Movement m : selectedFigure.getMovement()) {
						
						m.notified(tile);
						
					}
					
				}
				
				clickable.onClick();
				
			}
			
		}
		
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		
	}

}
