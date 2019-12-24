package com.EKEY.Listeners;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.EKEY.Board.BoardTile;
import com.EKEY.Board.ChessFigures.Figure;
import com.EKEY.Board.ChessFigures.Movement.Movement;
import com.EKEY.Interfaces.Clickable;
import com.EKEY.Misc.DataShare;

public class ClickableMouse implements MouseListener{
	
	private Figure selectedFigure = null;
	
	public ClickableMouse() {
		DataShare.CLICKABLEMOUSE = this;
	}
	
	@Override
	public void mouseClicked(MouseEvent EVENT) {
		
		Point clickPoint = EVENT.getPoint();
		
		for(int i = 0; i < DataShare.HANDLER.getClickList().size(); i++) { // for each registered clickable object
			
			Clickable clickable = DataShare.HANDLER.getClickList().get(i);
			
			
			if(clickable.getBounds().contains(clickPoint)) { // if we are clicking in the bounds of the clickable object
				
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

	public Figure getSelectedFigure() {
		return selectedFigure;
	}

	public void setSelectedFigure(Figure selectedFigure) {
		this.selectedFigure = selectedFigure;
	}
	
	

}
