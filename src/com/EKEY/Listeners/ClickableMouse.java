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
		
		for(int i = 0; i < DataShare.HANDLER.getClickList().size(); i++) { // for each registered clickable object
			
			Clickable clickable = DataShare.HANDLER.getClickList().get(i);
			
			
			if(clickable.getBounds().contains(clickPoint)) { // if we are clicking in the bounds of the clickable object
				
				if(clickable instanceof Figure) { // figure related part
					
					Figure fig = (Figure) clickable;
					
					if(selectedFigure == null || fig != selectedFigure) { // either if we haven't selected a figure yet or we are clicking on a differnet figure that is not selected
						
						if(selectedFigure != null) { // if we are selecting a new figure
							selectedFigure.setSelected(false); // deselect the last one
						}
						
						fig.setSelected(true); // set the new one
						selectedFigure = fig;
						
						
					}
					
					
					
				}
				
				if(selectedFigure != null && clickable instanceof BoardTile) { // if we selected a figure and we are clicking on a tile
					
					BoardTile tile = (BoardTile) clickable;
					
					for(Movement m : selectedFigure.getMovement()) { // for each movement inside the selected figure
						
						m.moveFigureWithMovement(tile); // notify it that it should move to that tile
						
					}
					
					selectedFigure.setSelected(false);
					selectedFigure = null;
					
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
